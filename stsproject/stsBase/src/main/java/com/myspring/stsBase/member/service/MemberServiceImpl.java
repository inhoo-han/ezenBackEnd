package com.myspring.stsBase.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.stsBase.member.dao.MemberDAO;
import com.myspring.stsBase.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	//[�븘�뱶]
	@Autowired //setter 吏��슱 �닔 �엳寃� �빐以�
	private MemberDAO memberDAO;
	
	//[硫붿꽌�뱶]
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

	//로그인
	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException {
		
		return memberDAO.loginCheck(memberVO);
	}
}
