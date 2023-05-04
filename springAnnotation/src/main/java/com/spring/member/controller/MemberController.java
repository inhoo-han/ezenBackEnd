package com.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.vo.MemberVO;

public interface MemberController {
	//ModelAndView 가 리턴값 listMembers가 메서드
	public ModelAndView listMembers(HttpServletRequest request,	HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
	