package servletAPI2.ex04;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener {
	//[필드]
	String user_id;
	String user_pwd;
	//현재 접속자수를 확인
	static int total_user = 0;
	
	
	//[생성자]
	public LoginImpl() {

	}
	public LoginImpl(String user_id, String user_pwd) {
		this.user_id = user_id;
		this.user_pwd = user_pwd;
	}
	
	//[오버라이드]
	//사용자가 접속을 시도할 때 발생
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("사용자가 접속하였습니다.");
		++total_user;
	}
	//사용자가 접속을 끊을 때 발생
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("사용자가 접속을 해제하였습니다.");
		total_user--;
	}	
}
