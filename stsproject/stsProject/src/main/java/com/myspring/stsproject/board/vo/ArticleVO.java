package com.myspring.stsproject.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("articleVO")
public class ArticleVO {
	private int level;
	private int articleNo;
	private int parentNo;
	private String title;
	private String content;
	private String imageFileName;
	private Date writeDate;
	private String id;
	
	public ArticleVO() {
		System.out.println("ArticleVO�깮�꽦");
	}
	
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
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				imageFileName = URLDecoder.decode(imageFileName, "utf-8");
			}else {
				imageFileName = null;
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("");
		}
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		try {
			if(imageFileName != null && imageFileName.length() != 0) {
				this.imageFileName = URLDecoder.decode(imageFileName, "utf-8");
			}else {
				imageFileName = null;
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("");
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
