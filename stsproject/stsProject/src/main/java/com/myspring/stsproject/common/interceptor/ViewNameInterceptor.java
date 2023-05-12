package com.myspring.stsproject.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	//컨트롤러 실행 전에 호출 할 때 사용
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			//아래 getViewName메서드 있어서 viewName만 가져와줌
			String viewName = getViewName(request);
			//viewName을 request에 바인딩 하였음
			request.setAttribute("viewName", viewName);
		} catch (Exception e) {
			System.out.println("☹ViewNameInterceptor - 인터셉터 중 에러☹");
		}
		return true;
	}
	
	//컨트롤러 실행 후 디스패처 서블릿 뷰로 보내기 전에 호출 할 때 사용
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	//뷰까지 수행한 뒤 호출 할 때 사용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

	//[getViewName()]
	private String getViewName(HttpServletRequest request) throws Exception{
	   String contextPath = request.getContextPath();
	   String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	   if(uri == null || uri.trim().equals("")) {
	      uri=request.getRequestURI();
	   }
	   int begin =0, end;
	   if(!((contextPath == null) || "".equals(contextPath))) {
	      begin = contextPath.length();
	   }
	   if(uri.indexOf(";") != -1) {
	      end = uri.indexOf(";");
	   }else if(uri.indexOf("?") != -1) {
	      end = uri.indexOf("?");
	   }else {
	      end = uri.length();
	   }
	   String fileName = uri.substring(begin,end);
	   if(fileName.lastIndexOf(".")!= -1) {
	      fileName=fileName.substring(0,fileName.lastIndexOf("."));
	   }
	   if(fileName.lastIndexOf("/") != -1) {
	      fileName=fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
	   }
	   return fileName;
	}
}
