package com.acorn.project.letcure.dao;

import java.util.List;

import com.acorn.project.lecture.dto.LectureStudentDto;


public interface LectureStudentDao {
	//수강 신청
	public void lectureSignup (LectureStudentDto dto);
	//수강 신청 취소
	
	//수강 신청한 회원의 목록
	public List<LectureStudentDto> getList(LectureStudentDto dto);
	
	public int getSequence();
}
