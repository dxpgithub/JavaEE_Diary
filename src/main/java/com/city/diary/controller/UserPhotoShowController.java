package com.city.diary.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import com.city.diary.util.ConnectionFactory;

/**
 * Servlet implementation class UserPhotoShowController
 */
@WebServlet("/photoshow.do")
@MultipartConfig
public class UserPhotoShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
		//获取图片
		String headphoto=request.getParameter("imageName");
		System.out.println(headphoto);
		//得到图片路径
		String realPath=request.getServletContext().getRealPath(headphoto);
		//通过图片完整路径，得到File对象
		File file=new File(realPath);
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
		FileUtils.copyFile(file,response.getOutputStream());
		
*/
		String id=request.getParameter("Name");
		System.out.println(id);
		try {
			Connection cn=ConnectionFactory.getConnection();
			String sqlid="select * from diaryuser where userid=?";
			String sqlphone="select * from diaryuser where userphone=?";
			if(id.trim().length()==11) {
				PreparedStatement ps=cn.prepareStatement(sqlphone);
				ps.setString(1,id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					String contentType=rs.getString("phototype");
					if(contentType!=null) {
						response.setContentType(contentType);
						ServletOutputStream out=response.getOutputStream();
						InputStream in=rs.getBinaryStream("headphoto");
						int data=0;
						while((data=in.read())!=-1) {
							out.write(data);
						}
						out.flush();
						out.close();
						in.close();
					}
				}
				rs.close();
				cn.close();
				ps.close();
			}
			else {
				PreparedStatement ps=cn.prepareStatement(sqlid);
				ps.setString(1,id);
				System.out.println("按ID显示头像"+id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					String contentType=rs.getString("phototype");
					System.out.println(contentType);
					if(contentType!=null) {
						response.setContentType(contentType);
						ServletOutputStream out=response.getOutputStream();
						InputStream in=rs.getBinaryStream("headphoto");
						int data=0;
						while((data=in.read())!=-1) {
							out.write(data);
						}
						out.flush();
						out.close();
						in.close();
					}
				}
				rs.close();
				cn.close();
				ps.close();
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
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
