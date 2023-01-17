package com.acorn.project.letcure.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.lecture.dto.LectureReviewDto;

@Repository
public class LectureReviewDaoImpl implements LectureReviewDao{
	
	@Autowired
	private SqlSession session;
	

	@Override
	public List<LectureReviewDto> getList(LectureReviewDto dto) {
		return session.selectList("lectureReview.getList", dto);
	}

	@Override
	public void delete(int num) {
	      session.update("lectureReview.delete", num);
		
	}

	@Override
	public void insert(LectureReviewDto dto) {
		session.insert("lectureReview.insert", dto);
		
	}

	@Override
	public int getSequence() {
		return session.selectOne("lectureReview.getSequence");
	}

	@Override
	public void update(LectureReviewDto dto) {
		session.update("lectureReview.update", dto);
		
	}

	@Override
	public LectureReviewDto getData(int num) {
		return session.selectOne("lectureReview.getData", num);
	}

	@Override
	public int getCount(int num) {
		return session.selectOne("lectureReview.getCount", num);
	}

}
