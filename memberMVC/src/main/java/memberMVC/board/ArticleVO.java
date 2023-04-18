package memberMVC.board;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;

public class ArticleVO {
	//[필드]
	//1. 글의 깊이를 저장
	private int level;
	//2. 글번호 
	private int articleNo;
	//3. 부모 글번호
	private int parentNo;
	//4. 글 제목
	private String title;
	//5. 글 내용
	private String content;
	//6. 이미지 파일 이름
	private String imageFileName;
	//7. 작성일
	private Date writeDate;
	//8. 작성자 ID(FK)
	private String id;
	
	//[생성자]
	public ArticleVO() {
		System.out.println("ArticleVO생성");
	}
	
	//writeDate제외한 생성자(Menu>Source>Generate Constructor using Fields)
	public ArticleVO(int level, int articleNo, int parentNo, String title, String content, String imageFileName,
			String id) {
		super();
		this.level = level;
		this.articleNo = articleNo;
		this.parentNo = parentNo;
		this.title = title;
		this.content = content;
		this.imageFileName = imageFileName;
		this.id = id;
	}

	//[getter,setter]
	//(Menu>Source>Generate Getters and Setters)
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageFileName() {
		//이미지에 한글이 들어갈 수 있기때문에 try-catch
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				imageFileName = URLDecoder.decode(imageFileName, "utf-8");
			}else {
				imageFileName = null;
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("☹이미지 로딩 중 에러 발생☹");
		}
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		//이미지에 한글이 들어갈 수 있기때문에 try-catch
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				this.imageFileName = URLDecoder.decode(imageFileName, "utf-8");
			}else {
				imageFileName = null;
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("☹이미지 저장 중 에러 발생☹");
		}
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
