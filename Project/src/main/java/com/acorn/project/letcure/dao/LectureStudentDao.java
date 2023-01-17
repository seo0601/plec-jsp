package com.acorn.project.letcure.dao;

import java.util.List;

import com.acorn.project.lecture.dto.LectureStudentDto;


public interface LectureStudentDao {
	//수강 신청
	public void lectureSignup (LectureStudentDto dto);
	//수강 신청 취소
	
	//프론트엔드 리스트
	public List<LectureStudentDto> frontEndList(LectureStudentDto dto);
	public List<LectureStudentDto> jsList(LectureStudentDto dto);
	public List<LectureStudentDto> html_cssList(LectureStudentDto dto);
	public List<LectureStudentDto> reactList(LectureStudentDto dto);
	public List<LectureStudentDto> vueList(LectureStudentDto dto);
	public List<LectureStudentDto> jQueryList(LectureStudentDto dto);
	//백엔드 리스트
	public List<LectureStudentDto> backEndList(LectureStudentDto dto);
	public List<LectureStudentDto> javaList(LectureStudentDto dto);
	public List<LectureStudentDto> springList(LectureStudentDto dto);
	public List<LectureStudentDto> springbootList(LectureStudentDto dto);
	//모바일 리스트
	public List<LectureStudentDto> mobileList(LectureStudentDto dto);
	public List<LectureStudentDto> kotlinList(LectureStudentDto dto);
	
	public int getSequence();
	
	public LectureStudentDto getData(int num);
	
	public int getCount();
}
