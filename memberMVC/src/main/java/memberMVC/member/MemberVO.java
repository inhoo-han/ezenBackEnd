package memberMVC.member;

import java.sql.Date;

public class MemberVO {
	//[필드]
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;

	//[생성자]
	//빈 생성자
	public MemberVO() {
		
	}
	
	//joinDate제외 생성자
	public MemberVO(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	//joinDate포함 생성자
	public MemberVO(String id, String pwd, String name, String email, Date joinDate) {
		this(id, pwd, name, email);
		this.joinDate = joinDate;
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
