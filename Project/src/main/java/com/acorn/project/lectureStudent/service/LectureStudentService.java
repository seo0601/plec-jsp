package com.acorn.project.lectureStudent.service;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReq;
import com.acorn.project.lecture.dto.LectureRes;
import com.acorn.project.lectureStudent.dto.LectureStudentDto;
import com.acorn.project.lectureStudent.dto.LectureStudentReq;
import com.acorn.project.lectureStudent.dto.LectureStudentRes;



public interface LectureStudentService {
	//강의 신청
	public Map<String, String> lectureSignup(LectureStudentRes res);
	
	//강의 신청 리스트
	public Map<String, Object> studentList(int pageNum, String large_category, String small_category);
	
	
	public Map<String, String> lectureComplete(LectureStudentReq req);
}
