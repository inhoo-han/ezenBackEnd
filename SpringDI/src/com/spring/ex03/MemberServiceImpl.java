package com.spring.ex03;

public class MemberServiceImpl implements MemberService{
	
	//[필드]
	//주입되는 빈을 저장할 MemberDAO타입의 속성을 선언
	private MemberDAO memDAO;
	
	
	//[setter]
	//설정 파일에서 memberDAO 빈을 생성한 뒤 setter로 속성 memDAO에 주입
	public void setMemDAO(MemberDAO memDAO) {
		this.memDAO = memDAO;
	}

	@Override
	public void listMembers() {
		//주입된 빈을 이용하여 listMembers() 메서드를 호출
		memDAO.listMembers();
	}
}
