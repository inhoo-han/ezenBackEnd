package mybatisfw.ex04;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//아이디로 회원 검색 메서드
	public MemberVO selectMemberById(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = session.selectOne("mapper.member.selectMemberById", id);
		return memberVO;
	}
	
	//이름(name)으로 회원 검색 메서드
	public List<MemberVO> selectMemberByName(String name) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memberList = session.selectList("mapper.member.selectMemberByName", name);
		return memberList;
	}
	
	//회원 추가 메서드[MemberVO방식]
	public void insertMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.insertMember", memberVO);
		session.commit();
	}
	
	//회원 추가 메서드[HashMap방식]
	public void insertMember2(Map<String, String> memberMap) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("mapper.member.insertMember2", memberMap);
		session.commit();
	}
	
	//회원 수정 메서드
	public void updateMember(MemberVO memberVO) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("mapper.member.updateMember", memberVO);
		session.commit();
	}
	
	//회원 삭제 메서드
	public void delMember(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("mapper.member.delMember", id);
		session.commit();
	}
	
	//동적 조회
	public List<MemberVO> searchMember(MemberVO memberVO){
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> list = session.selectList("mapper.member.searchMember", memberVO);
		return list;
	}
}
