package com.city.diary.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.diary.factory.ServiceFactory;
import com.city.diary.model.UserModel;
import com.city.diary.result.Result;
import com.city.diary.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class AppLoginController
 */
@WebServlet("/applogin.do")
public class AppLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			
			
		
		
		
		//创建JSON的Mapper对象
	    ObjectMapper mapper=new ObjectMapper();
	    //设置响应类型
	    response.setContentType("application/json");
	    //设置响应字符编码集
	    response.setCharacterEncoding("UTF-8");
	    //取得用户文本流
	    PrintWriter out=response.getWriter();
	    Result<String> result=new Result<String>();
	    
	    try {
	    	InputStream inputStream=null;
			Reader input = null;
			Writer output = new StringWriter();
				inputStream=request.getInputStream();
				
				input = new InputStreamReader(inputStream);
				
		        char[] buffer = new char[1024*4];
		        int n = 0;
		       String outpassword=null;
		       String outname=null;
		        while(-1 != (n = input.read(buffer))) {
		        	output.write(buffer, 0, n);
		        } 
		        System.out.println(output);
		        String soutput=output.toString().trim();
		        outpassword=soutput.substring(13, soutput.indexOf(","));
		        outname=soutput.substring(soutput.lastIndexOf(":")+1);
		        System.out.println(outname);
		        String password=outpassword.substring(0,outpassword.indexOf("\""));
		        String uid=outname.substring(outname.indexOf("\"")+1,outname.lastIndexOf("\""));
		        System.out.println(uid);
		        
			IUserService us=ServiceFactory.createUserService();
			UserModel um=new UserModel();
			if(uid!=null) {
				um=us.getById(Integer.valueOf(uid));
				result.setCode(1);
				result.setMsg("验证成功！");
			}else {
				result.setCode(0);
				result.setMsg("验证失败！");
			}
	    }
		catch(Exception e) {
				result.setCode(0);
				result.setMsg("登录失败,失败原因:"+e.getLocalizedMessage());
		}
	    
	    if(result.getCode()==1){
	    	//将Result对象转换为JSON
		    String resultjson=mapper.writeValueAsString(result);
		    out.println(resultjson);
		    out.flush();
		    out.close();
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
