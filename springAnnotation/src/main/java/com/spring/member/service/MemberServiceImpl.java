package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	//[필드]
	@Autowired //setter 지울 수 있게 해줌
	private MemberDAO memberDAO;
	
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
