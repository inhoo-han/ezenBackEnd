package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMembers() throws DataAccessException {
		List<MemberVO> memberList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return memberList;
	}

	@Override
	public void insertMember(MemberVO memVo) throws DataAccessException {
		sqlSession.insert("mapper.member.insertMember", memVo);
	}

	@Override
	public MemberVO findMember(String id) throws DataAccessException {
		MemberVO memVo = (MemberVO)sqlSession.selectOne("mapper.member.findMember", id);
		return memVo;
	}

	@Override
	public void updateMember(MemberVO memVo) throws DataAccessException {
		sqlSession.update("mapper.member.updateMember", memVo);
	}

	@Override
	public void deleteMember(String id) throws DataAccessException {
		sqlSession.delete("mapper.member.deleteMember", id);
	}
	

}