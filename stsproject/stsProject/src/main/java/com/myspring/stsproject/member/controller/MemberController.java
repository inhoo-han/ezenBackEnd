package com.myspring.stsproject.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.stsproject.member.vo.MemberVO;

public interface MemberController {
	//ModelAndView 媛� 由ы꽩媛� listMembers媛� 硫붿꽌�뱶
	//회원 목록
	public ModelAndView listMembers(HttpServletRequest request,	HttpServletResponse response) throws Exception;
	//회원 추가
	public ModelAndView addMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//회원 정보 변경
	public ModelAndView updateMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//회원 삭제
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//로그인
	public ModelAndView login(@ModelAttribute("memberVO") MemberVO memberVO, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	//로그아웃
	public ModelAndView logout(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
	