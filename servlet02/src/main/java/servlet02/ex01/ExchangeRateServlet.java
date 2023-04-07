package servlet02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange")
public class ExchangeRateServlet extends HttpServlet {
	//달러
	private static float USD_RATE = 1291.30F;
	//엔화
	private static float JSP_RATE = 990.37F;
	//위안
	private static float CNY_RATE = 188.62f;
	//파운드
	private static float GBP_RATE = 1585.65f;
	//유로
	private static float EUR_RATE = 1397.83f;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");		//수행할 요청
		String won = request.getParameter("won");		//변환할 원화
		String operator = request.getParameter("operator");		//반환 종류(달러..유로)
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><body>");
			pw.print("<h2>변환 결과</h2>");
			pw.print("<p>" + result + "</p>");
			pw.print("<a href='/servlet02/exchange'> 계산 다시하기");
			pw.print("</body></html>");
			return;
		}
		pw.print("<html><head><title>환율계산기</title></head>");
		pw.print("<body><h2>환율계산기</h2>");
		pw.print("<form name='frmCalc' method='get' action='/servlet02/exchange'>");
		pw.print("원화 : <input type='text' name='won' size=10>");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		//보이지 않지만 데이터를 전송해주는 역할을 한다. type='hidden' name, value보유
		pw.print("<input type='hidden' name='command' value='calculate'>");
		pw.print("<input type='submit' value='변환'>");
		pw.print("</form></body></html>");
		pw.close();
	}
	//환율계산의 결과값을 리턴한는 메서드
	private static String calculate(float won, String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result=String.format("%.2f 달러", won/USD_RATE);
		} else if(operator.equals("en")) {
			result=String.format("%.2f 엔", won/JSP_RATE);
		} else if(operator.equals("wian")) {
			result=String.format("%.2f 위안", won/CNY_RATE);
		} else if(operator.equals("pound")) {
			result=String.format("%.2f 파운드", won/GBP_RATE);
		} else if(operator.equals("euro")) {
			result=String.format("%.2f 유로", won/EUR_RATE);
		}
		return result;
	}

}
