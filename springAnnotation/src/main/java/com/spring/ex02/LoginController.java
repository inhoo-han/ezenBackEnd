package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {

	@RequestMapping(value="/test/loginForm.do", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	@RequestMapping(value="/test/login.do", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginResult");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		mav.addObject("id",id);
		mav.addObject("pwd",pwd);
		return mav;
	}
}
