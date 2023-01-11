package com.acorn.project.faq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.acorn.project.faq.service.FaqService;

@Controller
public class FaqController {

	@Autowired
	private FaqService service;
	
	
}
