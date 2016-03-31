package com.tch.test.spring_mvc_mybatis.interceptor.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInteceptor2  extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		System.out.println("prehandle -------MyInteceptor2");
		String uri = request.getRequestURI();
		if(uri.indexOf("rest") != -1){
			response.getWriter().print("contains  rest");
			return false;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion -------MyInteceptor2");
	}

	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle -------MyInteceptor2");
	}
	
}
