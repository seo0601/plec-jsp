package com.acorn.project.qna_board.dao;

import java.util.List;

import com.acorn.project.qna_board.dto.QnaBoardAnswerDto;

public interface QnaBoardAnswerDao {
	//댓글 목록 얻어오기
	public List<QnaBoardAnswerDto> getList(QnaBoardAnswerDto dto);	
	//댓글 추가
	public void insert(QnaBoardAnswerDto dto);
	//추가할 댓글의 글번호를 리턴하는 메소드
	public int getSequence();
	//댓글 수정
	public void update(QnaBoardAnswerDto dto);
	//댓글 하나의 정보를 리턴하는 메소드
	public QnaBoardAnswerDto getData(int num);
	//댓글의 갯수를 리턴하는 메소드
	public int getCount(int ref_group);
}
