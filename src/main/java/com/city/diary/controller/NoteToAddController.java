package com.city.diary.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.city.diary.service.INoteService;
import com.city.diary.service.INotetypeService;

/**
 * Servlet implementation class NoteAddController
 */
@WebServlet("/tonoteadd.do")
public class NoteToAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel user=(UserModel)request.getSession().getAttribute("userid");
		INotetypeService nts=ServiceFactory.createNotetypeService();
		INoteService ns=ServiceFactory.createNoteService();
		try {
			List<NotetypeModel> typelist=nts.getByAll(user.getUserid());
			request.setAttribute("GetType", typelist);
			request.setAttribute("typelist", typelist);
			List<NoteModel> datelist;
			datelist = ns.getByDate(user.getUserid());
			request.setAttribute("datelist", datelist);
			request.setAttribute("changePage", "../note/add.jsp");
			request.getRequestDispatcher("/include/main.jsp").forward(request, response);
		} catch (Exception e) {
			
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
