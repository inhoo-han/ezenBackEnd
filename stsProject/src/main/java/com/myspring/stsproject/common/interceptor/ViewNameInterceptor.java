package com.myspring.stsproject.common.interceptor;

import javax.servlet.http.HttpServletRequest;

public class ViewNameInterceptor {

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
