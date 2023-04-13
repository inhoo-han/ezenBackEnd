package jspFile.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding="utf-8";
		//업로드 할 파일의 경로
		File currentDirPath = new File("D:\\HIH\\file_upload");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//파일을 저장할 디렉토리 생성
		factory.setRepository(currentDirPath);
		//최대 업로드 가능한 파일 크기를 설정
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		//[1] 파일 업로드 도중 서버가 끊길 때
		//[2] 업로드될 공간이 부족할 경우 등. 
		try {
			//request,요청한 자료를 전부 items에 담겠다는 뜻
			List items=upload.parseRequest(request);
			for(int i=0; i<items.size(); i++){
				FileItem fileItem = (FileItem)items.get(i);
				//.isFormField()? : form의 내용이 문자냐 묻는 것
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encoding));
				}else {
					System.out.println("매개변수명 : " + fileItem.getFieldName());
					System.out.println("파일명 : " + fileItem.getName());
					System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
					if(fileItem.getSize() > 0) {
						/*파일 이름 가져오기*/
						//lastIndexOf("문자") : 문자를 뒤에서부터 찾는다. index는 앞에서부터 매긴다.
						int idx = fileItem.getName().lastIndexOf("\\");
						//indexOf == -1 : 못찾았다는 뜻
						//파일 경로를(\\)로 안 하고 (/)로 하는 경우도 있어서 그렇다.
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						//기호 다음부터 끝까지 받아오겠다(해당 파일의 이름을 받아오겠다ㅡ맨 뒤는 파일이름이니까ㅡ)
						String fileName = fileItem.getName().substring(idx+1);
						File uploadFile = new File(currentDirPath + "/" + fileName);
						//마지막으로, 저장하는 명령 수행
						fileItem.write(uploadFile);
					}
				}
			}
			System.out.println("파일 업로드 성공");
		} catch (Exception e) {
			System.out.println("파일 업로드 실패");
			e.printStackTrace();
		}
	}
}
