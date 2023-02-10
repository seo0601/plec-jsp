package com.acorn.project.lectureStudent.dao;

import java.util.List;

import com.acorn.project.lectureStudent.dto.LectureStudentDto;
import com.acorn.project.lectureStudent.dto.LectureStudentReq;
import com.acorn.project.lectureStudent.dto.LectureStudentRes;



public interface LectureStudentDao {
	//수강 신청
	public void lectureSignup (LectureStudentRes res);
	//수강 신청 취소
	public LectureStudentDto delete(int num);
	
	//수강 신청 리스트
	public List<LectureStudentDto> studentList(LectureStudentDto dto);

	public LectureStudentDto studentData(LectureStudentDto dto);
	
	public void lectureComplete(LectureStudentReq req);
	
	public int getSequence();

	public int getCount();
}
