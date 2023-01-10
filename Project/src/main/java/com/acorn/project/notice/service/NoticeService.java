package com.acorn.project.notice.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn.project.notice.dto.NoticeDto;


public interface NoticeService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void saveContent(NoticeDto dto);
	public void updateContent(NoticeDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request);
}
