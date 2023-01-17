package com.acorn.project.users.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.project.users.service.UsersService;

@RestController
public class CheckIdController {
	@Autowired
	private UsersService service;
	
	@RequestMapping("/users/checkid")
	public Map<String, Object> checkid(String inputId){
		Map<String, Object> isExist= service.isExistId(inputId);
		return isExist;
	}
}
