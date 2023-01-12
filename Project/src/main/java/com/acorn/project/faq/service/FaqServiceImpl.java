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
	public void getList(HttpServletRequest request) {
		
	}
	@Override
	public void saveContent(FaqDto dto) {
		faqDao.insert(dto);
	}

	@Override
	public void updateContent(FaqDto dto) {
		faqDao.update(dto);
	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		faqDao.delete(num);
	}

	@Override
	public void getData(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		FaqDto dto=faqDao.getData(num);
		request.setAttribute("dto", dto);
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
	}
}
