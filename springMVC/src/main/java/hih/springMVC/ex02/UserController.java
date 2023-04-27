package hih.springMVC.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
	
	//매핑이 login일 때
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.setViewName(viewName);
//		mav.setViewName("login");
		return mav;
	}
	
	//매핑이 memberInfo일 때
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);
		mav.setViewName(viewName);
//		mav.setViewName("memberInfo");
		return mav;
	}
	
	//파일이름 가져오는 getViewName 메서드
	public String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		System.out.println("컨텍스트 경로 : " + contextPath);
		String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
		System.out.println("기존 uri 값 : " + uri);
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
			System.out.println("변경된 uri 값 : " + uri);
		}
		int begin = 0, end;
		if(!(contextPath == null) || "".equals(contextPath)) {
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
		if(fileName.lastIndexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if(fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		System.out.println("fileName : " + fileName);
		return fileName;
	}
}
