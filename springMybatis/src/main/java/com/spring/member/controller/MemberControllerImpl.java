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
      mav.addObject("memberList",memberList);
      return mav;
   }

   @Override
   public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
      request.setCharacterEncoding("utf-8");
      MemberVO memVo = new MemberVO();
      //회원가입창에서 전송된 회원정보를 bind()메서드를 이용하여 memVo 해당 속성(field)에 자동으로 설정
      bind(request, memVo);
      memberService.addMember(memVo);
      ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
      return mav;
   }

   public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String viewName = getViewName(request);
       ModelAndView mav = new ModelAndView("memberForm");
       mav.setViewName(viewName);
       return mav;
   }
   
   public ModelAndView modMemberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String viewName = getViewName(request);
       String id = request.getParameter("id");
       MemberVO memVo = new MemberVO();
       memVo = memberService.findMember(id);
       ModelAndView mav = new ModelAndView(viewName);
       mav.addObject("member", memVo);
       return mav;
   }

	@Override
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
	    MemberVO memVo = new MemberVO();
	    bind(request, memVo);
	    memberService.updateMember(memVo);
	    ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
	    String id = request.getParameter("id");
	    memberService.removeMember(id);
	    ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
	    return mav;
	}

	//[getViewName()]
	//request 객체에서 URL 요청명을 가져와서 .do와 폴더를 제외한 요청명을 구하는 메서드
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
	      fileName=fileName.substring(fileName.lastIndexOf("/"), fileName.length());
	   }
	   return fileName;
	}


}