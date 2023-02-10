package com.acorn.project.lectureReview.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn.project.lectureReview.dto.LectureReviewDto;

public interface LectureReviewService {
	
	//후기 저장
	public void saveReview(HttpServletRequest request); 
	//후기 삭제
	public void deleteReview(HttpServletRequest request);
	//후기 수정
	public void updateReview(LectureReviewDto dto); 
	
}
