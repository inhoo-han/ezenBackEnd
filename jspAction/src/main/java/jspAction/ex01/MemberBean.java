package jspAction.ex01;

import java.sql.Date;

/*MemberVO와 비슷한 역할을 하는 클래스
 * DB에서는 저장할 변수에 반드시 private속성을 붙여준다.
 * 외부에서 마음대로 수정할 수 없어야 하므로! */
public class MemberBean {
	//[필드]
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;

	//[생성자]
	//빈 생성자
	public MemberBean() {
		
	}
	
	//joinDate제외 생성자
	public MemberBean(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	//[getter & setter]
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

