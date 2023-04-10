package servletdb.ex02;
//테이블에서 조회한 레코드의 컬럼값을 저장하는 용도이다. 

import java.sql.Date;

public class MemberVO {
	//필드 - db의 컬럼 이름, 자료형과 동일하게 만든다. 자료형은 무조건. 이름은 권고사항.
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	//생성자
	public MemberVO() {
		System.out.println("MemberVO생성자 호출");
	}
	//getter, setter생성
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
