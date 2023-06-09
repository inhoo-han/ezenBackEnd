package memberMVC.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	//변수 선언
	BoardService boardService;
	ArticleVO articleVO;
	private static String IMG_REPO = "D:\\HIH\\board\\image_upload";
	
	@Override
	public void init() throws ServletException {
		//BoardService의 인스턴스객체 생성
		boardService = new BoardService();
		articleVO = new ArticleVO();
		System.out.println("init호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nextPage = "";
		PrintWriter out; //230420추가
		HttpSession session; //230421추가
		String action = request.getPathInfo(); //요청(매핑)명을 가져온다.
		System.out.println("요청 매핑 이름 : " + action);
		//getPathInfo요청을 처리하면서 에러가 발생할 수 있다.
		try {
			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			if (action == null || action.equals("/listArticles.do")) {
				//230425추가
				String _section = request.getParameter("section");
				String _pageNum = request.getParameter("pageNum");
				int section = Integer.parseInt((_section == null)? "1" : _section);
				int pageNum = Integer.parseInt((_pageNum == null)? "1" : _pageNum);
				Map<String, Integer> pagingMap = new HashMap<String, Integer>();
				pagingMap.put("section", section);
				pagingMap.put("pageNum", pageNum);
				Map articleMap = boardService.listArticles(pagingMap);
				articleMap.put("section", section);
				articleMap.put("pageNum", pageNum);
				System.out.println("section : " + section);
				System.out.println("pageNum : " + pageNum);
				request.setAttribute("articleMap", articleMap);
				nextPage = "/boardInfo/listArticles.jsp";
			}
			else if(action.equals("/articleForm.do")) {
				nextPage = "/boardInfo/articleForm.jsp";
			}//글쓰기 버튼 클릭시
			else if(action.equals("/addArticle.do")) {
				// ↓여기변경
				int articleNo = 0;
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				//articleVO.setArticleNo(0); //articleNo는 세팅하지 않는다.
				//parentNo는 나중에 변수 넣어서 세팅한다(답글 달 경우에는 해당 articleNo가 내 parentNo가 되므로)
				articleVO.setParentNo(0);
				//아이디 연동하는 부분, 오늘은 안 한다. Spring에서 한다. 
				articleVO.setId("hih");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				// ↓여기변경 BoardService > addArticle()
				articleNo = boardService.addArticle(articleVO);
				// ↓여기변경 - 새 글 추가시 이미지를 첨부한 경우에만 수행
				if(imageFileName != null && imageFileName.length() != 0) {
					//temp폴더에 임시로 업로드된 파일 객체를 생성
					File srcFile = new File(IMG_REPO + "\\temp\\" + imageFileName);
					//dest : destination(도착지) - 새 글 추가된 글번호로 폴더를 생성
					File destDir = new File(IMG_REPO + "\\" + articleNo);
					//mkdir : 폴더 만드는 명령어(cmd에서 써봤다)
					destDir.mkdir();
					//FileUtils(commons선택): 파일 이동 도와주는 클래스 - temp폴더의 파일을 글번호 폴더로 이동
					                            // 누구를,   어디로,    옮겨말어
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					//해당 폴더에 이미지가 추가되었다면 임시 파일은 제거
					srcFile.delete();
				}
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('🤗새 글이 추가되었습니다🤗');");
				out.print("location.href='" + request.getContextPath() + "/board/listArticles.do';");
				out.print("</script>");
				//return에 아무것도 적지 않으면 그대로 빠져나온다. 아무것도 리턴하지 않고. 
				return; 
			}
			//게시물 클릭시
			else if(action.equals("/viewArticle.do")) {
				String articleNo = request.getParameter("articleNo");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNo));
				request.setAttribute("article", articleVO);
				nextPage = "/boardInfo/viewArticle.jsp";
			}
			//게시물 수정반영하기 버튼 클릭시(원글만. 댓글포함X)
			else if(action.equals("/modArticle.do")) {
				Map<String, String> articleMap = upload(request, response);
				int articleNo = Integer.parseInt(articleMap.get("articleNo"));
				articleVO.setArticleNo(articleNo);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setArticleNo(articleNo);
				articleVO.setParentNo(0);
				articleVO.setId("hello");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.modArticle(articleVO);
				//이미지를 첨부한 경우에만 수행
				if(imageFileName != null && imageFileName.length() != 0) {
					//변경 전의 이미지 이름
					String originalFileName = articleMap.get("originalFileName");
					File srcFile = new File(IMG_REPO + "\\temp\\" + imageFileName); 
					File destDir = new File(IMG_REPO + "\\" + articleNo);
					destDir.mkdir();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					File oldFile = new File(IMG_REPO + "\\" + articleNo + "\\" + originalFileName);
					oldFile.delete();
				}
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('🤗글 수정이 완료되었습니다🤗');");
				out.print("location.href='" + request.getContextPath() + "/board/viewArticle.do?articleNo=" + articleNo + "';");
				out.print("</script>");
				return;
			}
			//게시물 삭제버튼 클릭시
			else if(action.equals("/removeArticle.do")) {
				//"articleNo"라는 매개변수의 값을 가져올게용. input은 무조건 String형태라 형변환 했어용.
				int articleNo = Integer.parseInt(request.getParameter("articleNo"));
				//내 글번호를 parentNo로 가지고 있는 애들까지 데리고 와야 하므로 List로 받는다.
				List<Integer> articleNoList = boardService.removeArticle(articleNo);
				for(int no : articleNoList) {
					//imgDir: 이미지가 들어있는 곳
					File imgDir = new File(IMG_REPO + "\\" + no);
					if(imgDir.exists()) {
						FileUtils.deleteDirectory(imgDir);
					}
				}
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('🤗글을 삭제하였습니다.🤗');");
				out.print("location.href='" + request.getContextPath() + "/board/listArticles.do';");
				out.print("</script>");
				return;
			}
			//답글쓰기 버튼 클릭시
			else if(action.equals("/replyForm.do")) {
				int parentNo = Integer.parseInt(request.getParameter("parentNo"));
				System.out.println("✔✔답글쓸 부모의 번호 :" + parentNo);
				//getSession(): 세션있?불러와. 세션없?만들어.
				session = request.getSession();
				session.setAttribute("parentNo", parentNo);
				nextPage = "/boardInfo/replyForm.jsp";
			}
			//답글쓰기 > 답글반영하기 버튼 클릭시
			else if(action.equals("/addReply.do")) {
				session = request.getSession();
				int parentNo=(Integer)session.getAttribute("parentNo");
				session.removeAttribute("parentNo");
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				articleVO.setParentNo(parentNo);
				articleVO.setId("hello");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				int articleNo = boardService.addReply(articleVO);
				//답글에 이미지 첨부했는지 여부 파악
				if(imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(IMG_REPO + "\\temp\\" + imageFileName);
					File destDir = new File(IMG_REPO + "\\" + articleNo);
					destDir.mkdir();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					
				}
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('🤗답글을 등록하였습니다.🤗');");
				out.print("location.href='" + request.getContextPath() + "/board/viewArticle.do?articleNo=" + articleNo + "';");
				out.print("</script>");
				return;
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println("☹BoardController - 요청 처리 중 에러 발생☹");
			e.printStackTrace();
		}
	}
	
	//이미지 파일 업로드 + 새 글에 추가할 관련정보 해시맵에 저장할 메서드
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		//글 이미지 저장 폴더에 대한 파일 객체를 생성
		File currentDirPath = new File(IMG_REPO);
		//저장할 수 있는 팩토리 클래스 선언
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++) {
				FileItem fileItem = (FileItem)items.get(i);
				if(fileItem.isFormField()) {
					//전송되어 온 내용이 폼 필드일 경우
					System.out.println(fileItem.getFieldName() + " = " + fileItem.getString(encoding));
					//*추가부분* 파일 업로드로 같이 전송되어 온 제목(키)과 내용(값)을 Map(키, 값)으로 저장(return으로 반환) 
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				}else {
					//전송되어 온 내용이 폼 필드가 아닌 경우 = 이미지인 경우
					System.out.println("매개변수 명 : " + fileItem.getFieldName());
					System.out.println("파일 명 : " + fileItem.getName());
					System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
					//실제 이미지를 업로드 할 영역
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx+1);
						//*추가부분* 해시맵에도 파일이름을 담는다. 
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("☹BoardController - 파일 업로드 중 에러가 발생하였습니다☹");
			e.printStackTrace();
		}
		return articleMap;
	}
	
}