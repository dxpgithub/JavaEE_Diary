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
import com.city.diary.result.Result;
import com.city.diary.service.INoteService;
import com.city.diary.service.INotetypeService;
import com.city.diary.service.IUserService;
import com.city.diary.util.Page;

/**
 * Servlet implementation class NoteListController
 */
@WebServlet("/notelist.do")
public class NoteListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenum=1;
		int pagesize=5;
		UserModel user=(UserModel)request.getSession().getAttribute("userid");
		INoteService ns=ServiceFactory.createNoteService();
		
		if(request.getParameter("pagenum")!=null) {
			pagenum=Integer.valueOf(request.getParameter("pagenum")) ;
			//&&request.getParameter("pagesize")!=null
			//pagesize=Integer.valueOf(request.getParameter("pagesize"));
		}
		
		
		
		try {
			long count=ns.findNoteCount(user.getUserid());
			
			
			
			Page<NoteModel> page=new Page<NoteModel>(pagenum, pagesize, count);
			int index=(pagenum-1)*pagesize;
			
			page.setDatalist(ns.findNoteByPage(index,pagesize,user.getUserid()));
			request.setAttribute("page",page );
			INotetypeService nts=ServiceFactory.createNotetypeService();
			List<NotetypeModel> typelist=nts.getByAll(user.getUserid());
			request.setAttribute("typelist", typelist);
			List<NoteModel> datelist;
			datelist = ns.getByDate(user.getUserid());
			request.setAttribute("datelist", datelist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//设置动态包含
		request.setAttribute("changePage","../note/notelist.jsp");
		//转发到主界面
		request.getRequestDispatcher("/include/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
