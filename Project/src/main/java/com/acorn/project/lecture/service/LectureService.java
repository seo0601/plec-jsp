package com.acorn.project.lecture.service;



import javax.servlet.http.HttpServletRequest;



import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReviewDto;
import com.acorn.project.lecture.dto.LectureStudentDto;


public interface LectureService {
	
	//강의 리스트 가져오기
	public void LectureList(HttpServletRequest request);
	
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
	

	//강의 신청 리스트
	public void studentList(HttpServletRequest request);
	public void lectureComplete(LectureStudentDto dto, HttpServletRequest request);
	//후기 저장
	public void saveReview(HttpServletRequest request); 
	//후기 삭제
	public void deleteReview(HttpServletRequest request);
	//후기 수정
	public void updateReview(LectureReviewDto dto); 
	public void moreReviewList(HttpServletRequest request); //리뷰 더보기 기능
}
