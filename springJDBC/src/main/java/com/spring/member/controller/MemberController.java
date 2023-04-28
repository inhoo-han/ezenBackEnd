package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	//인터페이스의 추상메서드
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception; 
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception; 
}
