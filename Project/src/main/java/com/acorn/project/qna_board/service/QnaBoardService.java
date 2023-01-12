package com.acorn.project.qna_board.service;

import javax.servlet.http.HttpServletRequest;

import com.acorn.project.qna_board.dto.QnaBoardAnswerDto;
import com.acorn.project.qna_board.dto.QnaBoardDto;

public interface QnaBoardService {
	public void getList(HttpServletRequest request); //목록불러오기
	public void getDetail(HttpServletRequest request);
	public void saveContent(QnaBoardDto dto); //글 저장
	public void updateContent(QnaBoardDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request); //글 수정하기 위해 정보 불러오는 기능
	
	public void saveComment(HttpServletRequest request); //댓글 저장	
	public void updateComment(QnaBoardAnswerDto dto); //댓글 수정
	public void moreCommentList(HttpServletRequest request); //댓글 더보기 기능
	
}
