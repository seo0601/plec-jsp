package com.acorn.project.faq.service;

import java.util.List;

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
		String question=request.getParameter("question");
		String content=request.getParameter("content");
		FaqDto dto=new FaqDto();
		dto.setQuestion(question);
		dto.setContent(content);
		List<FaqDto> list=faqDao.getList(dto);
		request.setAttribute("list", list);
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
	public void getDetail(HttpServletRequest request) {
		String question=request.getParameter("question");
		String content=request.getParameter("content");
		FaqDto dto=new FaqDto();
		dto.setQuestion(question);
		dto.setContent(content);
		List<FaqDto> list=faqDao.getList(dto);
		request.setAttribute("list", list);
	}

	@Override
	public void getData(HttpServletRequest request) {
		
	}

}
