package com.city.diary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.diary.factory.ServiceFactory;
import com.city.diary.model.UserModel;
import com.city.diary.result.Result;
import com.city.diary.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 用户登录处理Controller
 */
@WebServlet(description = "用户登录处理", urlPatterns = { "/login.do" })
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static boolean isNumeric(String str){
	    for(int i=str.length();--i>=0;){
	        int chr=str.charAt(i);
	        if(chr<48 || chr>57)
	            return false;
	    }
	   return true;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("username");
		System.out.println(userid);
		String password=request.getParameter("userpassword");
		System.out.println(password);
		
		String remember=request.getParameter("remember");
		if(remember==null) {
			 remember="NotRemember";
		}
		System.out.println(remember);//取勾选记住我选项
	
		IUserService us=ServiceFactory.createUserService();
		Result<UserModel> resultuser=new Result<UserModel>();
		if(userid!=null&&userid.trim().length()!=0 &&password!=null&&password.trim().length()!=0) {
			//如果接收输入参数为空
			resultuser.setCode(0);//设置状态码
			resultuser.setMsg("用户名或密码不能为空！");//设置消息
			if(userid.trim().length()==11) {
				//按电话查找用户
				System.out.println("按电话查找用户"+userid);
				try {
					UserModel um=us.getByPhone(userid);//USerModel类,按电话登录
					System.out.println("登录用户"+um.getUserid());
					if(um==null	|| !userid.equals(um.getUserphone())) {
						//取用户为空,或前端取得的输入！=数据库取值
						resultuser.setCode(0);
						resultuser.setMsg("该用户不存在！");
						
					}
					else if(!password.equals(um.getUserpassword())) {
						//如果密码不正确
						resultuser.setCode(0);
						resultuser.setMsg("用户密码不正确！");
						
					}
					else {
						System.out.println("登录成功");
						resultuser.setCode(1);
						
					}
					resultuser.setResult(um);
				}catch(Exception e) {
					e.printStackTrace();
					response.sendRedirect("./include/erroe.jsp?message="+e.getLocalizedMessage());
				}
			}
			//
			else if(userid.trim().length()!=11&&isNumeric(userid)) {
				//按UID查找用户
				System.out.println("按UID查找用户"+userid);
				
				try {
					int no=0;
					no=Integer.valueOf(userid);
					UserModel um=us.getById(no);//USerModel类，按UID登录
					if(um==null || um.getUserid()!=no) {
						//取用户为空，或前端取得的输入！=数据库取值
						System.out.println("取用户为空"+um);
						resultuser.setCode(0);
						resultuser.setMsg("该用户不存在！");
					}

					else if(!password.equals(um.getUserpassword())) {
						//如果密码不正确
						resultuser.setCode(0);
						resultuser.setMsg("用户密码不正确！");
					}
					else {
						System.out.println("登录成功");
						resultuser.setCode(1);
					}
					resultuser.setResult(um);
				}catch(Exception e) {
					e.printStackTrace();
					response.sendRedirect("./include/erroe.jsp?message="+e.getLocalizedMessage());
				}
			}
			else {
				resultuser.setCode(0);
			}
		//判断是否选择记住密码
		if(remember.equals("1")) {
			System.out.println("勾选记住我选择项，设置Cookie");
			Cookie cookie=new Cookie("user",userid+"-"+password);
			//设置失效时间
			cookie.setMaxAge(7*24*60*60);
			//响应给客户端
			response.addCookie(cookie);
			
		} else {
			//未选择记住我
			Cookie cookie=new Cookie("user",null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	
			
			
		}
		if(resultuser.getCode()==1){
			//如果登录状态码为：1，重定向主界面
			
			request.getSession().setAttribute("userid",resultuser.getResult());
			System.out.println("登录状态码："+resultuser.getCode());
			response.sendRedirect("notelist.do");
			//request.getRequestDispatcher("notelist.do").forward(request, response);
			
		}
		else if(resultuser.getCode()==0) {
			//如果登录状态码为：0。转发到login.jsp
			System.out.println("登录状态码："+resultuser.getCode());
			System.out.println("状态码信息："+resultuser.getMsg());
			response.sendRedirect("login.jsp");
			//request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("./include/erroe.jsp");
		}
		
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
