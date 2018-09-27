package com.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	//实现逻辑检查
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//如果用户已经登录，就会在currentUser种保存当前用户的User对象
		if(request.getSession().getAttribute("currentUser") != null){
			return true;
		}
		//用户没有登录，就让下一个链接为当前请求的URL
		response.sendRedirect("/login?next=".concat(request.getRequestURI()));
		return false;
	}
}
