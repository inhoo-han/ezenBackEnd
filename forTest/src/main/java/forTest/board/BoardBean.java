package forTest.board;

import java.sql.Date;

public class BoardBean {

	//[필드]
	//1. 게시물번호
	private int num;
	//2. 작성자명
	private String name;
	//3. 제목
	private String subject;
	//4. 내용
	private String content;
	//5. 작성일
	private Date regdate;
	//6. 비밀번호
	private String pass;
	//7. 조회수
	private int count;
	
	//[생성자]
	public BoardBean() {
		System.out.println("BoardBean생성");
	}
	
	//regdate 제외한 생성자
	public BoardBean(int num, String name, String subject, String content, Date ragdate, String pass, int count) {
		super();
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.pass = pass;
		this.count = count;
	}

	//[getter, setter]
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
