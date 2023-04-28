package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	//[필드]
	private JdbcTemplate jdbcTemplate;
	
	public void setDateSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//[메서드]
	@Override
	public List selectAllMembers() throws DataAccessException {
		//회원목록 가져다주기
		String query = "select * from membertbl order by joinDate desc";
		List memberList = new ArrayList();
		memberList = this.jdbcTemplate.query(query, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				MemberVO memVO = new MemberVO();
				memVO.setId(rs.getString("id"));
				memVO.setPwd(rs.getString("pwd"));
				memVO.setName(rs.getString("name"));
				memVO.setEmail(rs.getString("email"));
				memVO.setJoinDate(rs.getDate("joinDate"));
				return memVO;
			}
		});
		return memberList;
	}

	@Override
	public void addMember(MemberVO memVo) throws DataAccessException {
		String id = memVo.getId();
		String pwd = memVo.getPwd();
		String name = memVo.getName();
		String email = memVo.getEmail();
		String query = "insert into membertbl(id,pwd,name,email) values('" + 
						id + "','" + pwd + "','" + name + "','" + email + "')";
		jdbcTemplate.update(query);
	}

}
