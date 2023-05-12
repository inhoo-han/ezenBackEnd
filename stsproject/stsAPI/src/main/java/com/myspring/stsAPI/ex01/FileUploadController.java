package com.myspring.stsAPI.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
	
	//[field]
	//이미지 경로
	private static String IMAGE_REPO_PATH="D:\\HIH\\backend\\stsproject\\image_repo";
	
	//[method]
	@RequestMapping(value="/form")
	public String form() {
		return "uploadForm";
	}
	
	//이미지의 정보를 map에 담는 메서드
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView upload(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
		multipartRequest.setCharacterEncoding("utf-8");
		Map map = new HashMap();		//매개변수 정보와 파일 정보를 저장할 Map 생성
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			System.out.println("name : " + name + "    value : " + value);
			map.put(name, value);
		}
		List fileList = fileProcess(multipartRequest);
		map.put("fileList", fileList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("result");
		return mav;
	}
	
	//파일 처리 메서드
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
		List<String> fileList = new ArrayList();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);		//파일 이름에 대한 MultipartFile객체를 가져옴
			String originalFileName = mFile.getOriginalFilename(); 			//실제 파일 이름을 가져옴
			fileList.add(originalFileName);
			File file = new File(IMAGE_REPO_PATH + "\\" + fileName);
			if(mFile.getSize() != 0) {
				if(! file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				//﻿임시로 저장한 multipartfile을 실제 파일로 전송
				mFile.transferTo(new File(IMAGE_REPO_PATH + "\\" + originalFileName));
			}
			
		}
		return fileList;
	}
}
