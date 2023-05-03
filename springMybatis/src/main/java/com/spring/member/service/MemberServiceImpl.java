package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	//[필드]
	private MemberDAO memberDAO;
	
	//[setter] : memberDAO빈을 주입하기 위해 setter구현
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
		memberDAO.insertMember(memVo);
	}

	@Override
	public MemberVO findMember(String id) throws DataAccessException {
		MemberVO memVo = (MemberVO)memberDAO.findMember(id);
		return memVo;
	}

	@Override
	public void updateMember(MemberVO memVo) throws DataAccessException {
		memberDAO.updateMember(memVo);
	}

	@Override
	public void removeMember(String id) throws DataAccessException {
		memberDAO.deleteMember(id);
	}
}
