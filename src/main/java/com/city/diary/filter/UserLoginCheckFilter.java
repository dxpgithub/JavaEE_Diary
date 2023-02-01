package com.city.diary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户登录检查过滤器
 */
@WebFilter(
		description = "用户登录检查过滤器", 
		urlPatterns = { 
				"/*"
		})
public class UserLoginCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserLoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String uri=request.getRequestURI();
		System.out.println(uri);
		//请求为登录及注册
		if(uri.equals("/diary/login.jsp")||uri.equals("/diary/login.do")||uri.equals("/diary/register.do")||uri.equals("/diary/include/error.jsp")||uri.equals("/diary/applogin.do")
			||uri.startsWith("/diary/img")||uri.startsWith("/diary/bootstrap5")||uri.startsWith("/diary/file")
			||uri.endsWith(".css")||uri.endsWith(".js")||uri.endsWith(".ico")||uri.endsWith(".png")||uri.endsWith(".mp3")||uri.endsWith("map")	
				) {
					chain.doFilter(request, response);
		}
		

		//拦截
		else {
			HttpSession session=request.getSession();
			Cookie[] cookies=request.getCookies();
			//判断Cookie是否选取免登陆
			if(cookies!=null &&cookies.length>0) {
				for(Cookie cookie:cookies) {
					if("user".equals(cookie.getName())) {
						String value=cookie.getValue();
						String[] val=value.split("-");
						String userName=val[0];
						String userPwd=val[1];
						System.out.println("免登陆");
						String url="login.do?username="+userName+"&userpassword="+userPwd;
						request.getRequestDispatcher(url).forward(request, response);
						return;
					}
				}
			}
			if(session.getAttribute("userid")==null) {
				//木有登录
				System.out.println("未登录"+session.getAttribute("userid"));
				//重定向到登录界面
				response.sendRedirect("/diary/login.jsp");
			}
			else {
				//已经登录；通过，可以访问目标地址
				chain.doFilter(request, response);
			}
		}
		
		
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String driver=config.getInitParameter("driver");
		System.out.println("登录过滤器初始方法执行");
	}

}
