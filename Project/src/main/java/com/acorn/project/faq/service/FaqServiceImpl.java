package com.acorn.project.faq.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.project.faq.dao.FaqDao;
import com.acorn.project.faq.dto.FaqDto;

@Service
public class FaqServiceImpl implements FaqService{

	@Autowired
	private FaqDao faqDao;
	
	@Override
	public void saveContent(FaqDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContent(FaqDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getData(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

}
