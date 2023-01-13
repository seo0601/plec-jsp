package com.acorn.project.qna_board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.qna_board.dto.QnaBoardDto;

@Repository
public class QnaBoardDaoImpl implements QnaBoardDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<QnaBoardDto> getList(QnaBoardDto dto) {
		/*
		 * 검색 기능은 
		 * 1. 제목+내용
		 * 2. 제목
		 * 3. 작성자
		 * 검색 3가지 기능을 제공할 예정이다. 
		 */
		return session.selectList("qnaboard.getList", dto);
	}

	@Override
	public int getCount(QnaBoardDto dto) {
		
		return session.selectOne("qnaboard.getCount", dto);
	}

	@Override
	public void insert(QnaBoardDto dto) {
		session.insert("qnaboard.insert", dto);
		
	}

	@Override
	public QnaBoardDto getData(int num) {
		
		return session.selectOne("qnaboard.getData", num);
	}
	//조회수 올리는 메소드
	@Override
	public void addViewCount(int num) {
		session.update("qnaboard.addViewCount", num);
		
	}

	@Override
	public void delete(int num) {
		session.delete("qnaboard.delete", num);
		
	}

	@Override
	public void update(QnaBoardDto dto) {
		session.update("qnaboard.update", dto);
		
	}

	@Override
	public QnaBoardDto getData(QnaBoardDto dto) {
		
		return session.selectOne("qnaboard.getData2", dto);
	}
	
	@Override
	public QnaBoardDto answered(QnaBoardDto dto) {
		
		return session.selectOne("qnaboard.answered", dto);
	}
}
