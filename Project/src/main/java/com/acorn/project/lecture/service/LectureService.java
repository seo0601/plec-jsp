package com.acorn.project.lecture.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.acorn.project.lecture.dto.LectureDto;


public interface LectureService {
	//백엔드 리스트 가져오기
	public void backEndList(HttpServletRequest request);
	//프론트엔드 리스트 가져오기
	public void frontEndList(HttpServletRequest request);
	//모바일 리스트 가져오기
	public void mobileList(HttpServletRequest request);
	//이미지 업로드
	public void saveImage(LectureDto dto, HttpServletRequest request);
	//동영상 저장하기
	public void insert(LectureDto dto, HttpServletRequest request);
	//강의 상세 보기
	public void getDetail(ModelAndView mView, int num);
}
