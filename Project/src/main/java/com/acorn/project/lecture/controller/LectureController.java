package com.acorn.project.lecture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.service.LectureService;


@Controller
public class LectureController {

	@Autowired private LectureService service;
	
	@Value("${file.location}")
	private String fileLocation;
	
	@GetMapping(
			value="/lecture/images/{imageName}",
			produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE}
		)
	@ResponseBody
	public byte[] galleryImage(@PathVariable("imageName") String imageName) throws IOException {
		
		String absolutePath=fileLocation+File.separator+imageName;
		//파일에서 읽어들일 InputStream
		InputStream is=new FileInputStream(absolutePath);
		//이미지 데이터(byte)를 읽어서 배열에 담아서 클라이언트에게 응답한다.
		return IOUtils.toByteArray(is);
	}	
	//백엔드 리스트
	@RequestMapping(value = "/lecture/backend/backendList")
	public String backEndList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.backEndList(request);
		
		return "lecture/backend/backendList";
	}
	//프론트엔드 리스트
	@RequestMapping(value = "/lecture/frontend/frontendList")
	public String frontEndList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.frontEndList(request);
		
		return "lecture/frontend/frontendList";
	}
	//모바일 리스트
	@RequestMapping(value = "/lecture/mobile/mobileList")
	public String mobileList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.mobileList(request);
		
		return "lecture/mobile/mobileList";
	}
	
	@RequestMapping(value = "/lecture/upload_form")
	public String uploadForm() {
		
		return "lecture/upload_form";
	}
	
	@RequestMapping(value = "/lecture/upload")
	public String upload(LectureDto dto, HttpServletRequest request) {
		service.saveImage(dto, request);
		
		return "lecture/upload";
	}
	
	@RequestMapping("/lecture/insert")
	public String insert(LectureDto dto, HttpServletRequest request) {
		service.insert(dto, request);
		
		return "lecture/upload";
	}
	
	@RequestMapping(value = "/lecture/detail", method = RequestMethod.GET)
	public ModelAndView detail(ModelAndView mView, int num) {
		service.getDetail(mView, num);
		mView.setViewName("lecture/detail");
		
		return mView;
	}

}
