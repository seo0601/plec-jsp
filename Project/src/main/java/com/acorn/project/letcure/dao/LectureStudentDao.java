package com.acorn.project.letcure.dao;

import java.util.List;

import com.acorn.project.lecture.dto.LectureStudentDto;


public interface LectureStudentDao {
	//수강 신청
	public void lectureSignup (LectureStudentDto dto);
	//수강 신청 취소
	
	public List<LectureStudentDto> studentList(LectureStudentDto dto);
	
	
	public int getSequence();
	
	public LectureStudentDto getData(int num);
	
	public int getCount();
}
