package forSecondTest.ex01;

public class MemberVO {
	
	//[필드]
	private String name;
	private String email;
	private String pass;
	private String telecom;
	private int telno;
	
	//[생성자]
	public MemberVO() {
		System.out.println("MemberVO생성");
	}
	public MemberVO(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	
	public MemberVO(String name, String email, String pass, String telecom, int telno) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.telecom = telecom;
		this.telno = telno;
	}
	
	//[getter, setter]
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

	public int getTelno() {
		return telno;
	}

	public void setTelno(int telno) {
		this.telno = telno;
	}
	
	
}
