package com.myspring.stsAPI.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class FileDownloadController {

	//[field]
	//이미지 경로
	private static String IMAGE_REPO_PATH="D:\\HIH\\backend\\stsproject\\image_repo";
	
	//[method]
	//image download
	/*
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = IMAGE_REPO_PATH + "\\" + imageFileName;
		File file = new File(downFile);		//다운로드할 파일 객체를 생성
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName=" + imageFileName);		//헤더에 파일 이름 설정
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		while (true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
	*/
	
	//썸네일 라이브러리 활용
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = IMAGE_REPO_PATH + "\\" + imageFileName;
		File file = new File(downFile);		//다운로드할 파일 객체를 생성
		
		/* 썸네일 폴더를 만들어 썸네일 이미지 전송
		int lastIndex = imageFileName.lastIndexOf(".");				//확장자가 시작되는 인덱스 번호 추출
		String fileName = imageFileName.substring(0,lastIndex);		//확장자를 제외한 파일 이름만 추출
		File thumbnail = new File(IMAGE_REPO_PATH + "\\thumbnail\\" + fileName + ".png"); 		//썸네일 이미지는 전보 png파일이다.
		if(file.exists()) {
			thumbnail.getParentFile().mkdir();
			Thumbnails.of(file).size(50, 50).outputFormat("png").toFile(thumbnail);
		}
		
		FileInputStream in = new FileInputStream(thumbnail);
		byte[] buffer = new byte[1024*8];
		while (true) {
			int count = in.read(buffer);
			if(count == -1) {
				break;
			}
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		*/
		//썸네일 이미지 파일을 서버에 따로 생성하지 않고 바로 브라우저에 다운로드 기능으로 처리하는 방법
		if(file.exists()) {
			Thumbnails.of(file).size(50, 50).outputFormat("png").toOutputStream(out);
		}else {
			return;
		}
		byte[] buffer = new byte[1024*8];
		out.write(buffer);
		out.close();
	}
}
