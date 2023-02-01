package com.city.diary.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * UTF-8转码过滤器
 */
@WebFilter("/*")
public class AUTF8Filter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest Servletrequest, ServletResponse Servletresponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)Servletrequest;
		HttpServletResponse response =(HttpServletResponse)Servletresponse;
		
		//处理POST请求
		request.setCharacterEncoding("UTF-8");
		
		//得到请求类型
		String method=request.getMethod();
		if("GET".equalsIgnoreCase(method)) {//忽略大小写比较
			//得到服务器版本
			String serverInfo=request.getServletContext().getServerInfo();
			//通过截取字符串得到版本号
			String version=serverInfo.substring(serverInfo.lastIndexOf("/")+1,serverInfo.indexOf("."));
			//判断服务器版本是否在7以下
			if(version!=null && Integer.parseInt(version)<8) {
				//Tomcat7及以下服务器GET请求
				MyWapper mywapper=new MyWapper(request);
				chain.doFilter(mywapper, response);
				return ;
			}
		}
		chain.doFilter(request, response);
	}
	/*
	 * 1.定义内部类(本质是Request对象)
	 * 2.HttpServletRequestWrapper继承包装类
	 * 3.重写方法
	 */
	class MyWapper extends HttpServletRequestWrapper{
		//定义成员变量 HttpServletRequest对象 (提升构造器中request对象的作用域)
		private HttpServletRequest request;
		/*
		 * 带参数构造
		 * 可以得到需要处理的request对象
		 */
		public MyWapper(HttpServletRequest request) {
			super(request);
			this.request=request;
		}
		/*
		 * 重写getParament，处理乱码
		 */
		public String getParament(String name) {
			//获取参数(乱码的参数值)
			String value =request.getParameter(name);
			//判断参数值是否为空
			if(value==null) {
				return value;
			}
			//通过 new String处理乱码
			try {
				value =new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return value;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
