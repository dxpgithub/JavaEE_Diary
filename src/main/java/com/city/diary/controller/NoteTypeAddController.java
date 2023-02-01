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
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class NoteTypeAddController
 */
@WebServlet("/typeaddormodify.do")
public class NoteTypeAddController extends HttpServlet {
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
		int typeid=0;
		try {
			System.out.println("类别增加或修改请求");
			String typename=request.getParameter("typename");
			String stypeid=request.getParameter("typeid");
			if(!stypeid.equals("")) {
				 typeid=Integer.valueOf( request.getParameter("typeid"));
				 System.out.println(typeid);
			}
			
			
			UserModel user=(UserModel)request.getSession().getAttribute("userid");
			if(typename==null) {
				resultnotetype.setCode(0);
				resultnotetype.setMsg("类别名称不能为空");
				response.sendRedirect("notelist.do");
			}
			NotetypeModel ntm=new NotetypeModel();
			ntm.setTypename(typename);
			ntm.setTypeid(typeid);
			ntm.setUserid(user.getUserid());
			
			int code=nts.checkTypeName(ntm);
			if(code==0) {
				resultnotetype.setCode(0);
				resultnotetype.setMsg("类别已经存在");
				return;
			}
			
			if(stypeid.equals("")) {
				nts.addtype(ntm);
				resultnotetype.setCode(1);
				resultnotetype.setMsg("增添成功");
				
			}
			else {
				nts.changetype(ntm);
				resultnotetype.setCode(1);
				resultnotetype.setMsg("更新成功");
				
				
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultnotetype.setCode(0);
			resultnotetype.setMsg("增加或更新失败");
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
