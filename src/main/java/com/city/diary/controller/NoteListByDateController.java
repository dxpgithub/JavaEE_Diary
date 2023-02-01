package com.city.diary.controller;

import java.io.IOException;
import java.util.Date;
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
import com.city.diary.util.DateUtils;

/**
 * Servlet implementation class NoteListByDateController
 */
@WebServlet("/notebydate.do")
public class NoteListByDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pubtime=request.getParameter("pubtime");
		UserModel user=(UserModel)request.getSession().getAttribute("userid");
		INoteService ns=ServiceFactory.createNoteService();
		INotetypeService nts=ServiceFactory.createNotetypeService();
		if(pubtime!=null) {
			try {
				List<NoteModel> pubtimelist;	
				List<NotetypeModel> typelist;
				Date pubdate=DateUtils.StrToDate(pubtime);
				int year=pubdate.getYear()+1900;
				int month=pubdate.getMonth()+1;
				String endpubdate=""+year+"-"+""+month+"";
				endpubdate+="-31";
				typelist = nts.getByAll(user.getUserid());
				
				List<NoteModel> datelist;
				datelist = ns.getByDate(user.getUserid());
				pubtimelist=ns.getByPubtime(pubdate,user.getUserid(),endpubdate);
				request.setAttribute("typelist", typelist);
				request.setAttribute("namelist", pubtimelist);
				request.setAttribute("datelist", datelist);
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
