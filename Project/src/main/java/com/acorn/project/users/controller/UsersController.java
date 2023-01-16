package com.acorn.project.users.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.project.users.dto.UsersDto;
import com.acorn.project.users.service.UsersService;



@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@Value("${file.location}")
	private String fileLocation;

	@GetMapping(
			value="/users/images/{imageName}",
			produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE}
		)
	@ResponseBody
	public byte[] profileImage(@PathVariable("imageName") String imageName) throws IOException {

		String absolutePath=fileLocation+File.separator+imageName;
		InputStream is=new FileInputStream(absolutePath);
		return IOUtils.toByteArray(is);
	}	
	
	@RequestMapping("/users/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		return "users/list";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/signup_form")
	public String signupForm() {
		
		return "users/signup_form";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/signup")
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		service.addUser(dto);
		mView.setViewName("users/signup");
		return mView;
	}

	@RequestMapping(method=RequestMethod.GET, value="/users/loginform")
	public String loginForm() {
		
		return "users/loginform";
	}

	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto, String url, 
			HttpSession session, HttpServletResponse response) {

		service.loginProcess(dto, session, response);
		
		String encodedUrl=URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodedUrl", encodedUrl);
		
		mView.setViewName("users/login");
		return mView;
	}	
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "users/logout";
	}
	@RequestMapping("/users/info")
	public ModelAndView info(HttpSession session, ModelAndView mView) {
		
		service.getInfo(session, mView);
		
		mView.setViewName("users/info");
		return mView;
	}	
	

	@RequestMapping("/users/delete")
	public ModelAndView delete(HttpSession session, ModelAndView mView) {
		service.deleteUser(session, mView);
		mView.setViewName("users/delete");
		return mView;
	}
	
	@RequestMapping("/users/users_delete")
	public String userDelete(String id , HttpServletRequest request) {
		service.forceDelete(id, request);
		return "redirect:/users/list";
	}
	
	
	@RequestMapping("/users/updateform")
	public ModelAndView updateform(HttpSession session, ModelAndView mView) {
		service.getInfo(session, mView);
		mView.setViewName("users/updateform");
		return mView;
	}

	@RequestMapping(value = "/users/update", method=RequestMethod.POST)
	public ModelAndView update(UsersDto dto, HttpSession session, ModelAndView mView,
			 HttpServletRequest request) {

		service.updateUser(dto, session, mView);
		mView.setViewName("redirect:/users/info");
		return mView;
	}
	
	//ajax 프로필 사진 업로드 요청처리
	@RequestMapping(value = "/users/profile_upload", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> profileUpload(HttpServletRequest request, MultipartFile image){
		
		//서비스를 이용해서 이미지를 upload 폴더에 저장하고 리턴되는 Map 을 리턴해서 json 문자열 응답하기
		return service.saveProfileImage(request, image);
	}
	
	@RequestMapping("/users/pwd_updateform")
	public String pwdUpdateForm() {
	
		return "users/pwd_updateform";
	}	
	
	@RequestMapping("/users/pwd_update")
	public ModelAndView pwdUpdate(UsersDto dto, ModelAndView mView, HttpSession session) {
		service.updateUserPwd(session, dto, mView);
		mView.setViewName("users/pwd_update");
		return mView;
	}	
}