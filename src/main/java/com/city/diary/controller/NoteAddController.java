package com.city.diary.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.diary.factory.ServiceFactory;
import com.city.diary.model.NoteModel;
import com.city.diary.model.NotetypeModel;
import com.city.diary.model.UserModel;
import com.city.diary.result.Result;
import com.city.diary.service.INoteService;
import com.city.diary.service.INotetypeService;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class NoteAddController
 */
@WebServlet("/noteadd.do")
public class NoteAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html;charset=utf-8");
		ObjectMapper mapper=new ObjectMapper();
		PrintWriter out=response.getWriter();
		int typeid=Integer.valueOf(request.getParameter("typeid")) ;
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		System.out.println("typeid"+typeid);
		System.out.println("title"+title);
		System.out.println("content"+content);
		UserModel user=(UserModel)request.getSession().getAttribute("userid");
		Result<NoteModel> resultnote=new Result<NoteModel>();
		INoteService ns=ServiceFactory.createNoteService();
		NoteModel nm=new NoteModel();
		nm.setTitle(title);
		nm.setContent(content);
		nm.setNoteowner(user.getUserid());
		nm.setTypeid(typeid);
		
			ns.addnote(nm);
			request.getRequestDispatcher("/include/main.jsp").forward(request, response);
			String resultjson=mapper.writeValueAsString(resultnote);
			out.print(resultjson);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
