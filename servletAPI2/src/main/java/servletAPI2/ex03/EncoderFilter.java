package servletAPI2.ex03;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

//어떤 서블릿을 실행해도 모두 이 필터를 거쳐 가겠다는 뜻
//@WebFilter("/*")
//                          ↓클래스 상속          ↓인터페이스 구현
public class EncoderFilter extends HttpFilter implements Filter {
     
	//애플리케이션 스코프 변수 선언
	ServletContext context;
    public EncoderFilter() {
        super();
    }

	public void destroy() {

	}

	//doFilter(): 실제 필터 기능을 구현하는 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 메서드 호출");
		request.setCharacterEncoding("utf-8");
		//다음 필터로 넘기는 작업(like binding)
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("필터에서 utf-8 인코딩 작업을 수행");
		context = fConfig.getServletContext();
	}
}
