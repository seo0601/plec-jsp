package com.acorn.project.lecture.service;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReq;
import com.acorn.project.lecture.dto.LectureRes;
import com.acorn.project.lectureReview.dto.LectureReviewDto;
import com.acorn.project.lectureStudent.dto.LectureStudentDto;


public interface LectureService {
	//강의 리스트 가져오기
	public Map<String, Object> LectureList(int pageNum, String large_category, String small_category);
	
	//연습 이미지 업로드
	public Map<String, Object> uploadImage(LectureDto dto, HttpServletRequest request);
	
	//이미지 업로드
	public void saveImage(LectureDto dto, HttpServletRequest request);
	
	//강의 저장하기
	public Map<String,String> insert(LectureRes lectureRes);
	//강의 상세보기
	public Map<String, Object> getDetail(int num,String ref_group);
	//강의 하나의 정보 가져오기
	public Map<String, Object> getData(int num);
	//강의 수정
	public Map<String, String> updateContent(LectureReq lectureReq);
	//강의 삭제
	public Map<String, String> deleteContent(int num);
	
	
}
