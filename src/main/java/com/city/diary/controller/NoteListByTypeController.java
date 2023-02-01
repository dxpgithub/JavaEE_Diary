package com.city.diary.controller;

import java.io.IOException;
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
 * Servlet implementation class NoteListByTypeController
 */
@WebServlet("/notebytype.do")
public class NoteListByTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typename=request.getParameter("typename");
		UserModel user=(UserModel)request.getSession().getAttribute("userid");
		INoteService ns=ServiceFactory.createNoteService();
		INotetypeService nts=ServiceFactory.createNotetypeService();
		if(typename!=null) {
			try {
				List<NoteModel> namelist;	
				List<NotetypeModel> typelist;
				List<NoteModel> datelist;
				namelist = ns.getByType(typename,user.getUserid());
				typelist = nts.getByAll(user.getUserid());
				
				datelist = ns.getByDate(user.getUserid());
				
				request.setAttribute("typelist", typelist);
				request.setAttribute("datelist", datelist);
				request.setAttribute("namelist", namelist);
				request.setAttribute("changePage", "../note/namelist.jsp");
				request.getRequestDispatcher("/include/main.jsp").forward(request, response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else
		{
			request.getRequestDispatcher("/include/main.jsp").forward(request, response);
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
