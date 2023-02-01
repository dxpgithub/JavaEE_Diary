package com.city.diary.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.diary.factory.ServiceFactory;
import com.city.diary.model.UserModel;
import com.city.diary.service.IUserService;


/**
 * 用户注册后处理
 */
@WebServlet(description = "用户注册后处理", urlPatterns = {"/register.do" })
@MultipartConfig
public class UserRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static byte[] File2byte(File tradeFile){
	        byte[] buffer = null;
	        try
	        {
	            FileInputStream fis = new FileInputStream(tradeFile);
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            byte[] b = new byte[1024];
	            int n;
	            while ((n = fis.read(b)) != -1)
	            {
	                bos.write(b, 0, n);
	            }
	            fis.close();
	            bos.close();
	            buffer = bos.toByteArray();
	        }catch (FileNotFoundException e){
	            e.printStackTrace();
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	        return buffer;
	    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("用户注册");
		String registname =	request.getParameter("registname");
		String registphone= request.getParameter("registphone");
		String registpwd =  request.getParameter("registpwd");
		String registsex =	request.getParameter("registsex");
		if(registname==null||registname.trim().length()==0||registphone==null||registphone.trim().length()==0||registpwd==null||registpwd.trim().length()==0||registsex==null||registsex.trim().length()==0) {
			 response.sendRedirect("toregister.do");
		 }
		else {
			 IUserService us=ServiceFactory.createUserService();
				try {
					UserModel um=new UserModel();
					um.setUsername(registname);
					um.setUserphone(registphone);
					um.setUserpassword(registpwd);
					um.setUsersex(registsex);
					String headphoto="/img/404q.png";
					//得到图片路径
					String realPath=request.getServletContext().getRealPath(headphoto);
					System.out.println(realPath);
					//通过图片完整路径，得到File对象
					File file=new File(realPath);
					 byte[] bytes = File2byte(file);
					//通过截取，得到图片后缀
					String pic=headphoto.substring(headphoto.lastIndexOf(".")+1);
					if("png".equalsIgnoreCase(pic)) {
						response.setContentType("image/png");
					}
					else if("jpg".equalsIgnoreCase(pic)||"jpeg".equalsIgnoreCase(pic)) {
						response.setContentType("image/jpg");
					}
					else if("jpg".equalsIgnoreCase(pic)||"jpeg".equalsIgnoreCase(pic)) {
						response.setContentType("image/jpg");
					}	
					else if("gif".equalsIgnoreCase(pic)||"jpeg".equalsIgnoreCase(pic)) {
						response.setContentType("image/gif");
					}	
					um.setPhoto(bytes);
					um.setPhotoType("image/"+pic);
					um.setUsermood("我一直在寻找着什么，寻找着某个人");
					us.add(um);
					
					response.sendRedirect("toregister.do");
				}catch(Exception e) {
					
					response.sendRedirect("/diary/include/error.jsp?message="+e.getLocalizedMessage());
				}
		}
		
		
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
