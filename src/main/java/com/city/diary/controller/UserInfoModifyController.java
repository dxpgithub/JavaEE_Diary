package com.city.diary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.city.diary.factory.ServiceFactory;
import com.city.diary.model.UserModel;
import com.city.diary.result.Result;
import com.city.diary.service.IUserService;

/**
 * Servlet implementation class UserInfoModifyController
 */
@WebServlet("/userinfomodify.do")
@MultipartConfig
public class UserInfoModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService us=ServiceFactory.createUserService();
		Result<UserModel> resultuser=new Result<UserModel>();
		UserModel user=(UserModel)request.getSession().getAttribute("userid");
		System.out.println("用户信息修改请求");
		int userid=Integer.valueOf(request.getParameter("uid"));
		String name=request.getParameter("nick");
		String password=request.getParameter("password");
		String mood=request.getParameter("mood");
		String phone=request.getParameter("phone");
		
		String sex=request.getParameter("sex");
		Part photo=request.getPart("headimg");
	
		byte[] photos=photo.getInputStream().readAllBytes();
		
		String phototype=photo.getContentType(); //取得图片类型
		
		
		user.setUserid(userid);
		user.setUsername(name);
		user.setUserpassword(password);
		user.setUserphone(phone);
		user.setUsersex(sex);
		user.setUsermood(mood);
		if(!phototype.equals("image/jpeg")) {
			user.setPhoto(user.getPhoto());
			user.setPhotoType(user.getPhotoType());
		}
		else {
			user.setPhoto(photos);
			user.setPhotoType(phototype);
		}
		try {
			
			us.modify(user);
				resultuser.setCode(1);
				resultuser.setResult(user);
				request.getSession().setAttribute("userid",resultuser.getResult());
		} catch (Exception e) {
			//response.sendRedirect("/diary/include/error.jsp?message="+e.getLocalizedMessage());
		}
		response.sendRedirect("touserinfomodify.do");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
