package com.acorn.project.faq.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn.project.faq.dto.FaqDto;

public interface FaqService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void saveContent(FaqDto dto);
	public void updateContent(FaqDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request);
	
	
}
