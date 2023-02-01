package com.city.diary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.diary.factory.ServiceFactory;
import com.city.diary.model.NotetypeModel;
import com.city.diary.model.UserModel;
import com.city.diary.result.Result;
import com.city.diary.service.INotetypeService;
import com.city.diary.service.IUserService;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class NotetypeDeleteController
 */
@WebServlet("/notetypedelete.do")
public class NotetypeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		Result<NotetypeModel> resultnotetype=new Result<NotetypeModel>();
		INotetypeService nts=ServiceFactory.createNotetypeService();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		try {
			System.out.println("类别删除请求");
			String typename=request.getParameter("typename");
			System.out.println("删除类别"+typename);
			UserModel user=(UserModel)request.getSession().getAttribute("userid");
			if(typename==null) {
				resultnotetype.setCode(0);
				resultnotetype.setMsg("系统异常");
				response.sendRedirect("notelist.do");
			}
			NotetypeModel ntm=new NotetypeModel();
			ntm.setTypename(typename);
			ntm.setUserid(user.getUserid());
		
			nts.delete(ntm);
			resultnotetype.setCode(1);
			resultnotetype.setMsg("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String resultjson=mapper.writeValueAsString(resultnotetype);
		out.print(resultjson);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
