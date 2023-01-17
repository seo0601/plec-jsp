package com.acorn.project.lecture.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReviewDto;
import com.acorn.project.lecture.dto.LectureStudentDto;


public interface LectureService {
	//프론트엔드 리스트 가져오기
	public void frontEndList(HttpServletRequest request);
	//자바스크립트 리스트 가져오기
	public void jsList(HttpServletRequest request);
	//html_css 리스트 가져오기
	public void html_cssList(HttpServletRequest request);
	//react 리스트 가져오기
	public void reactList(HttpServletRequest request);
	//vue.js 리스트 가져오기
	public void vueList(HttpServletRequest request);
	//jQuery 리스트 가져오기
	public void jQueryList(HttpServletRequest request);
	//백엔드 리스트 가져오기
	public void backEndList(HttpServletRequest request);
	//java 리스트 가져오기
	public void javaList(HttpServletRequest request);
	//spring 리스트 가져오기
	public void springList(HttpServletRequest request);	
	//spring boot 리스트 가져오기
	public void springbootList(HttpServletRequest request);
	//모바일 리스트 가져오기
	public void mobileList(HttpServletRequest request);
	//kotlin 리스트 가져오기
	public void kotlinList(HttpServletRequest request);
	//이미지 업로드
	public void saveImage(LectureDto dto, HttpServletRequest request);
	//강의 저장하기
	public void insert(LectureDto dto, HttpServletRequest request);
	//강의 상세보기
	public void getDetail(HttpServletRequest request);
	//강의 하나의 정보 가져오기
	public void getData(HttpServletRequest request);
	//강의 수정
	public void updateContent(LectureDto dto, HttpServletRequest request);
	//강의 삭제
	public void deleteContent(int num, HttpServletRequest request);
	
	//강의 신청
	public void lectureSignup(LectureStudentDto dto, HttpServletRequest request);
	
	//후기 저장
	public void saveReview(HttpServletRequest request); 
	//후기 삭제
	public void deleteReview(HttpServletRequest request);
	//후기 수정
	public void updateReview(LectureReviewDto dto); 
	public void moreReviewList(HttpServletRequest request); //리뷰 더보기 기능
}
