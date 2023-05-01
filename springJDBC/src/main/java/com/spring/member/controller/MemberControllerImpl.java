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
      mav.addObject("memberList",memberList);
      return mav;
   }

   @Override
   public ModelAndView MemberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String viewName = getViewName(request);
       ModelAndView mav = new ModelAndView("memberForm");
       mav.setViewName(viewName);
       return mav;
   }
   
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