package com.acorn.project.qna_free.dao;

import java.util.List;

import com.acorn.project.qna_free.dto.QnaFreeAnswerDto;

public interface QnaFreeAnswerDao {
	//댓글 목록 얻어오기
	public List<QnaFreeAnswerDto> getList(QnaFreeAnswerDto dto);	
	//댓글 추가
	public void insert(QnaFreeAnswerDto dto);
	//추가할 댓글의 글번호를 리턴하는 메소드
	public int getSequence();
	//댓글 수정
	public void update(QnaFreeAnswerDto dto);
	//댓글 하나의 정보를 리턴하는 메소드
	public QnaFreeAnswerDto getData(int num);
	//댓글의 갯수를 리턴하는 메소드
	public int getCount(int ref_group);
}
