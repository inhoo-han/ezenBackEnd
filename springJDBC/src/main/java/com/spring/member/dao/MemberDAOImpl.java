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
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public List selectAllMembers() throws DataAccessException {
		String query = "select * from memberTbl order by joinDate desc";
		List memberList=new ArrayList();
		
		memberList=this.jdbcTemplate.query(query, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rownum) throws SQLException{
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
	public void addMember(MemberVO memVO) throws DataAccessException {
		String id = memVO.getId();
		String pwd = memVO.getPwd();
		String name = memVO.getName();
		String email = memVO.getEmail();
		String query = "insert into membertbl (id, pwd, name, email) values('"
		+ id + "', '"+ pwd +"', '" + name + "', '" + email+ "')";
		
	}

}