package com.acorn.project.letcure.dao;

import java.util.List;

import com.acorn.project.lecture.dto.LectureStudentDto;


public interface LectureStudentDao {
	//수강 신청
	public void lectureSignup (LectureStudentDto dto);
	//수강 신청 취소
	public LectureStudentDto delete(int num);
	
	//수강 신청 리스트
	public List<LectureStudentDto> studentList(LectureStudentDto dto);

	public LectureStudentDto getData(LectureStudentDto dto);
	
	public int getSequence();
	
	
	public int getCount();
}
