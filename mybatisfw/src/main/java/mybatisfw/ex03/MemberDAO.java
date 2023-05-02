package mybatisfw.ex03;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import mybatisfw.ex01.MemberVO;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper = null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				//resource의 값을 전부 읽어들이는 기능
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				System.out.println("☹MemberDAO - DB연결 중 에러 발생☹");
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	//회원 정보 목록 메서드
	public List<MemberVO> selectAllMemberList(){
		sqlMapper = getInstance(); //DB연결
		SqlSession session = sqlMapper.openSession();	//.openSession() : 사용할 객체를 가져옴
		List<MemberVO> memberList = session.selectList("mapper.member.selectAllMemberList");
		return memberList;
	}
	
	//회원 정보 목록 메서드
//	public List<HashMap<String, String>> selectAllMemberList(){
//		sqlMapper = getInstance(); //DB연결
//		SqlSession session = sqlMapper.openSession();	//.openSession() : 사용할 객체를 가져옴
//		List<HashMap<String, String>> memberList = session.selectList("mapper.member.selectAllMemberList");
//		return memberList;
//	}
	
	//아이디로 회원 검색
	public MemberVO selectMemberById(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = session.selectOne("mapper.member.selectMemberById", id);
		return memberVO;
	}
	
	//이름(name)으로 회원 검색
	public List<MemberVO> selectMemberByName(String name) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memberList = session.selectList("mapper.member.selectMemberByName", name);
		return memberList;
	}

}
