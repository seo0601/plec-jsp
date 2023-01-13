package com.acorn.project.qna_free.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.qna_free.dto.QnaFreeDto;

@Repository
public class QnaFreeDaoImpl implements QnaFreeDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<QnaFreeDto> getList(QnaFreeDto dto) {
		/*
		 * 검색 기능은 
		 * 1. 제목+내용
		 * 2. 제목
		 * 3. 작성자
		 * 검색 3가지 기능을 제공할 예정이다. 
		 */
		return session.selectList("qnafree.getList", dto);
	}

	@Override
	public int getCount(QnaFreeDto dto) {
		
		return session.selectOne("qnafree.getCount", dto);
	}

	@Override
	public void insert(QnaFreeDto dto) {
		session.insert("qnafree.insert", dto);
		
	}

	@Override
	public QnaFreeDto getData(int num) {
		
		return session.selectOne("qnafree.getData", num);
	}
	//조회수 올리는 메소드
	@Override
	public void addViewCount(int num) {
		session.update("qnafree.addViewCount", num);
		
	}

	@Override
	public void delete(int num) {
		session.delete("qnafree.delete", num);
		
	}

	@Override
	public void update(QnaFreeDto dto) {
		session.update("qnafree.update", dto);
		
	}

	@Override
	public QnaFreeDto getData(QnaFreeDto dto) {
		
		return session.selectOne("qnafree.getData2", dto);
	}
	
}
