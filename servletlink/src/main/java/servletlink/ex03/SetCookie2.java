package servletlink.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set2")
public class SetCookie2 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date date = new Date();
		Cookie ck = new Cookie("cookieTest", URLEncoder.encode("하늘이 맑네요😊", "utf-8"));
		//쿠키의 수명을 정해준다. 거의 데스노트.
//		ck.setMaxAge(24*60*60); //하루살이 쿠키. 쿠키는 초단위구나!
		//setMaxAge를 음수로 주면 Session쿠키가 만들어진다.
		ck.setMaxAge(-1);
		//addCookie : 만든 쿠키를 브라우저로 전송
		response.addCookie(ck);
		out.print("쿠키 구운 시간 : " + date +"<br>");
		out.print("쿠키가 저장되었습니다.");
	}

}
