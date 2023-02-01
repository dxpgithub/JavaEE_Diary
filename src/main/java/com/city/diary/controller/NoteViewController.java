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
 * Servlet implementation class NoteViewController
 */
@WebServlet("/noteview.do")
public class NoteViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noteids=request.getParameter("noteid");
		System.out.println(noteids);
		if(noteids!=""||noteids!=null) {
			try {
				int noteid=Integer.valueOf(request.getParameter("noteid"));
				
				UserModel user=(UserModel)request.getSession().getAttribute("userid");
				INoteService ns=ServiceFactory.createNoteService();
				INotetypeService nts=ServiceFactory.createNotetypeService();
				List<NoteModel> singlenote;
				
					singlenote = ns.finNoteById(noteid,user.getUserid());
					List<NotetypeModel> typelist;
					typelist = nts.getByAll(user.getUserid());
					request.setAttribute("typelist", typelist);
			request.setAttribute("singlenote",singlenote );
			
			
			
			//设置动态包含
			request.setAttribute("changePage","../note/view.jsp");
			//转发到主界面
			request.getRequestDispatcher("/include/main.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
