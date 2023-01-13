package com.acorn.project.qna_board.dao;

import java.util.List;

import com.acorn.project.qna_board.dto.QnaBoardDto;

public interface QnaBoardDao {

	//글목록
	public List<QnaBoardDto> getList(QnaBoardDto dto);
	//글의 갯수
	public int getCount(QnaBoardDto dto);
	//글 추가
	public void insert(QnaBoardDto dto);
	//글정보 얻어오기
	public QnaBoardDto getData(int num);
	//키워드를 활용한 글 정보 얻어오기(키워드에 부합하는 글 중에서 이전글, 다음글의 글번호도 얻어올 수 있도록)
	public QnaBoardDto getData(QnaBoardDto dto);
	//조회수 증가 시키기
	public void addViewCount(int num);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(QnaBoardDto dto);
	//답변완료 추가
	public QnaBoardDto answered(QnaBoardDto dto);
}
