package com.myspring.stsproject.board.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;

public class ArticleVO {
	//[�븘�뱶]
	//1. 湲��쓽 源딆씠瑜� ���옣
	private int level;
	//2. 湲�踰덊샇 
	private int articleNo;
	//3. 遺�紐� 湲�踰덊샇
	private int parentNo;
	//4. 湲� �젣紐�
	private String title;
	//5. 湲� �궡�슜
	private String content;
	//6. �씠誘몄� �뙆�씪 �씠由�
	private String imageFileName;
	//7. �옉�꽦�씪
	private Date writeDate;
	//8. �옉�꽦�옄 ID(FK)
	private String id;
	
	//[�깮�꽦�옄]
	public ArticleVO() {
		System.out.println("ArticleVO�깮�꽦");
	}
	
	//writeDate�젣�쇅�븳 �깮�꽦�옄(Menu>Source>Generate Constructor using Fields)
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
		//�씠誘몄��뿉 �븳湲��씠 �뱾�뼱媛� �닔 �엳湲곕븣臾몄뿉 try-catch
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
		//�씠誘몄��뿉 �븳湲��씠 �뱾�뼱媛� �닔 �엳湲곕븣臾몄뿉 try-catch
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
