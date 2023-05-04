package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl extends MultiActionController implements MemberController{
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@Override
	@RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List memberList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memberList",memberList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberVO memVo = new MemberVO();
		//회원가입창에서 전송된 회원정보를 bind()메서드를 이용하여 memVo 해당 속성(field)에 자동으로 설정
		bind(request, memVo);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@RequestMapping(value="/member/memberForm.do", method=RequestMethod.GET)
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView("memberForm");
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/member/modMemberForm.do", method=RequestMethod.GET)
	public ModelAndView modMemberForm(@RequestParam("id") String id, MemberVO memberVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		memberVO = memberService.findMember(id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("member", memberVO);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/updateMember.do", method=RequestMethod.GET)
	public ModelAndView updateMember(@ModelAttribute("memberVO") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
	    memberService.updateMember(memberVO);
	    ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do", method=RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
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