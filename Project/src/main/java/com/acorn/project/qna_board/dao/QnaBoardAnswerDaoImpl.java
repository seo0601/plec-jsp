package com.acorn.project.qna_board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.qna_board.dao.QnaBoardAnswerDao;
import com.acorn.project.qna_board.dto.QnaBoardAnswerDto;


@Repository
public class QnaBoardAnswerDaoImpl implements QnaBoardAnswerDao {
	
	@Autowired
	private SqlSession session;
	
	   @Override
	   public List<QnaBoardAnswerDto> getList(QnaBoardAnswerDto dto) {
	      
	      return session.selectList("qnaBoardAnswer.getList", dto);
	   }	
	
	   @Override
	   public void insert(QnaBoardAnswerDto dto) {
	      session.insert("qnaBoardAnswer.insert", dto);
	   }
	
	   //저장될 예정인 댓글의 글번호를 얻어내서 리턴해주는 메소드
	   @Override
	   public int getSequence() {
	      
	      return session.selectOne("qnaBoardAnswer.getSequence");
	   }
	
	   @Override
	   public void update(QnaBoardAnswerDto dto) {
	      session.update("qnaBoardAnswer.update", dto);
	   }
	
	   @Override
	   public QnaBoardAnswerDto getData(int num) {
	      
	      return session.selectOne("qnaBoardAnswer.getData", num);
	   }
	
	   @Override
	   public int getCount(int ref_group) {
	      
	      return session.selectOne("qnaBoardAnswer.getCount", ref_group);
	   }
}
