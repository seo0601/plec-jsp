package com.acorn.project.qna_free.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn.project.qna_free.dto.QnaFreeAnswerDto;
import com.acorn.project.qna_free.dto.QnaFreeDto;

public interface QnaFreeService {
	public void getList(HttpServletRequest request); //목록불러오기
	public void getDetail(HttpServletRequest request);
	public void saveContent(QnaFreeDto dto); //글 저장
	public void updateContent(QnaFreeDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request); //글 수정하기 위해 정보 불러오는 기능
	
	public void saveComment(HttpServletRequest request); //댓글 저장	
	public void deleteComment(HttpServletRequest request); //댓글 삭제
	public void updateComment(QnaFreeAnswerDto dto); //댓글 수정
	public void moreCommentList(HttpServletRequest request); //댓글 더보기 기능
}
