package forChoRong.ex01;

import java.sql.Date;

/*MemberVO와 비슷한 역할을 하는 클래스
 * DB에서는 저장할 변수에 반드시 private속성을 붙여준다.
 * 외부에서 마음대로 수정할 수 없어야 하므로! */
public class MemberBean {
	//[필드]
	private String name;
	private String pwd;
	private String message;
	private int num;

	//[생성자]
	//빈 생성자
	public MemberBean() {
		
	}
	
	//joinDate제외 생성자
	public MemberBean(String name, String pwd, String message, int num) {
		this.name = name;
		this.pwd = pwd;
		this.message = message;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	//[getter & setter]
	
	
}

