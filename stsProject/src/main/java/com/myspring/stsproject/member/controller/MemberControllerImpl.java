package com.myspring.stsproject.member.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.template.AddAttributeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.stsproject.member.service.MemberService;
import com.myspring.stsproject.member.vo.MemberVO;

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
		//�쉶�썝媛��엯李쎌뿉�꽌 �쟾�넚�맂 �쉶�썝�젙蹂대�� bind()硫붿꽌�뱶瑜� �씠�슜�븯�뿬 memVo �빐�떦 �냽�꽦(field)�뿉 �옄�룞�쑝濡� �꽕�젙
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
	
	/* */
	@RequestMapping(value="/member/loginForm.do", method=RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	   @Override
	   @RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	   public ModelAndView login(@ModelAttribute("memberVO") MemberVO memberVO, RedirectAttributes rAttr, HttpServletRequest request,
	         HttpServletResponse response) throws Exception {
	      ModelAndView mav = new ModelAndView();
	      memberVO = memberService.login(memberVO);
	      if (memberVO != null) {
	         HttpSession session = request.getSession();
	         session.setAttribute("memberVO", memberVO);
	         session.setAttribute("isLogOn", true);
	 		System.out.println("isLogOn : " + session.getAttribute("isLogOn"));
	 		System.out.println("member : " + session.getAttribute("member"));
	         mav.setViewName("redirect:/member/listMembers.do");
	      }else {
	         rAttr.addAttribute("result", "loginFailed");
	         mav.setViewName("redirect:/member/loginForm.do");
	      }
	      return mav;
	   }

	@Override
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(MemberVO memberVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session=request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
 		System.out.println("isLogOn : " + session.getAttribute("isLogOn"));
 		System.out.println("member : " + session.getAttribute("member"));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}

}
