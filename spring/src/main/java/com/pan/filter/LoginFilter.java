package com.pan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	public void destroy() {
		System.out.println("过滤器destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		System.out.println("过滤器doFilter");
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		
		String username = (String) session.getAttribute("username");
		
		String url = servletRequest.getRequestURI();
		System.out.println(url);
		
		//登入页面无需过滤
		if (url.indexOf("login")>-1) {
			chain.doFilter(servletRequest, servletResponse);
			return ;
		}
		//如果没有获取到登入信息，就跳转到登入页面
		if (username == null ||"".equals(username)) {
			//跳转到登入页面
			servletResponse.sendRedirect("login");
		}else{
			// 已经登陆,继续此次请求
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器init");
	}

}
