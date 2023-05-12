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
	//�̹��� ���
	private static String IMAGE_REPO_PATH="D:\\HIH\\backend\\stsproject\\image_repo";
	
	//[method]
	//image download
	/*
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = IMAGE_REPO_PATH + "\\" + imageFileName;
		File file = new File(downFile);		//�ٿ�ε��� ���� ��ü�� ����
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName=" + imageFileName);		//����� ���� �̸� ����
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
	
	//����� ���̺귯�� Ȱ��
	@RequestMapping("/download")
	public void download(@RequestParam("imageFileName") String imageFileName, HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		String downFile = IMAGE_REPO_PATH + "\\" + imageFileName;
		File file = new File(downFile);		//�ٿ�ε��� ���� ��ü�� ����
		
		/* ����� ������ ����� ����� �̹��� ����
		int lastIndex = imageFileName.lastIndexOf(".");				//Ȯ���ڰ� ���۵Ǵ� �ε��� ��ȣ ����
		String fileName = imageFileName.substring(0,lastIndex);		//Ȯ���ڸ� ������ ���� �̸��� ����
		File thumbnail = new File(IMAGE_REPO_PATH + "\\thumbnail\\" + fileName + ".png"); 		//����� �̹����� ���� png�����̴�.
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
		//����� �̹��� ������ ������ ���� �������� �ʰ� �ٷ� �������� �ٿ�ε� ������� ó���ϴ� ���
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
