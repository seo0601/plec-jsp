package com.acorn.project.qna_free.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.qna_free.dto.QnaFreeAnswerDto;


@Repository
public class QnaFreeAnswerDaoImpl implements QnaFreeAnswerDao {
	
	@Autowired
	private SqlSession session;
	
	   @Override
	   public List<QnaFreeAnswerDto> getList(QnaFreeAnswerDto dto) {
	      
	      return session.selectList("qnaFreeAnswer.getList", dto);
	   }	
	
	   @Override
	   public void insert(QnaFreeAnswerDto dto) {
	      session.insert("qnaFreeAnswer.insert", dto);
	   }
	
	   //저장될 예정인 댓글의 글번호를 얻어내서 리턴해주는 메소드
	   @Override
	   public int getSequence() {
	      
	      return session.selectOne("qnaFreeAnswer.getSequence");
	   }
	
	   @Override
	   public void update(QnaFreeAnswerDto dto) {
	      session.update("qnaFreeAnswer.update", dto);
	   }
	
	   @Override
	   public QnaFreeAnswerDto getData(int num) {
	      
	      return session.selectOne("qnaFreeAnswer.getData", num);
	   }
	
	   @Override
	   public int getCount(int ref_group) {
	      
	      return session.selectOne("qnaFreeAnswer.getCount", ref_group);
	   }
}
