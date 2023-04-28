package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

public class MemberControllerImpl extends MultiActionController implements MemberController{
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memberList", memberList);
		return mav;
	}

	@Override
	public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memVo = new MemberVO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		memVo.setId(id);
		memVo.setPwd(pwd);
		memVo.setName(name);
		memVo.setEmail(email);
		memberService.addMember(memVo);
		List memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView("listMembers");
		mav.addObject("memberList", memberList);
		return mav;
	}

	@Override
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return null;
	}

	//매핑이름에서 메서드 이름만 가져오는 getViewName 메서드
	private String getViewName(HttpServletRequest request) throws Exception{
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
