package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	//[필드]
	private MemberDAO memberDAO;
	
	//[setter]
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	//[메서드]
	@Override
	public List listMembers() throws DataAccessException {
		List memberList = memberDAO.selectAllMembers();
		return memberList;
	}

	@Override
	public void addMember(MemberVO memVo) throws DataAccessException {
		memberDAO.addMember(memVo);
	}
}
