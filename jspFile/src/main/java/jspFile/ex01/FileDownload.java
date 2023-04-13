package jspFile.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fileFolder = "D:\\HIH\\file_upload";
		//"fileName"으로 값을 받아 온다고. 잘 기억해 두라고 하셨다.
		String fileName = (String)request.getParameter("fileName");
		System.out.println("파일이름 : " + fileName);
		
		/*OutputStream : 파일을 내보낸다.*/
		OutputStream outs = response.getOutputStream();
		String downFile = fileFolder + "\\" + fileName;
		File file = new File(downFile);
		
		/*파일이 혼자 움직이는게 아니라 송장처럼 정보가 함께 다닌다. 이 정보를 세팅하자.*/
		//캐쉬를 이용하지 않고 캐쉬를 컨트롤하겠다는 의미
		response.setHeader("Cache-Control","no-cache");
		//Header내용을 추가할 때는 addHeader를 사용한다.
		response.addHeader("Content-disposition","attachment;fileName=" + fileName);
		
		/*FileInputStream : 파일을 읽어들인다.*/
		FileInputStream fileInputS = new FileInputStream(file);
		//한 번에 8kb씩 읽어들이겠다. 
		byte[] buffer = new byte[1024*8];
		//8kb가 넘는 이미지들은 8kb씩 끝날때까지 반복해서 읽어들인다.
		while(true) {
			int count = fileInputS.read(buffer);
			//더이상 읽어들일 값이 없다면 count == -1이 된다.
			if(count == -1) {
				break;
			}
			outs.write(buffer, 0, count);
		}
		//뭔가를 읽어들인 뒤에는 반드시 닫아주어야 한다. 
		fileInputS.close();
		outs.close();
	}
}
