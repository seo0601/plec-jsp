package com.acorn.project.letcure.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.lecture.dto.LectureDto;

@Repository
public class LectureDaoImpl implements LectureDao{

	@Autowired private SqlSession session;
	
	@Override
	public List<LectureDto> frontEndList(LectureDto dto) {
		return session.selectList("lecture.frontEndList", dto);
	}
	
	@Override
	public List<LectureDto> jsList(LectureDto dto) {
		return session.selectList("lecture.jsList", dto);
	}

	@Override
	public List<LectureDto> html_cssList(LectureDto dto) {
		return session.selectList("lecture.html_cssList", dto);
	}

	@Override
	public List<LectureDto> reactList(LectureDto dto) {
		return session.selectList("lecture.reactList", dto);
	}

	@Override
	public List<LectureDto> vueList(LectureDto dto) {
		return session.selectList("lecture.vueList", dto);
	}

	@Override
	public List<LectureDto> jQueryList(LectureDto dto) {
		return session.selectList("lecture.jQueryList", dto);
	}

	@Override
	public List<LectureDto> backEndList(LectureDto dto) {
		return session.selectList("lecture.backEndList", dto);
	}
	
	@Override
	public List<LectureDto> javaList(LectureDto dto) {
		return session.selectList("lecture.javaList", dto);
	}

	@Override
	public List<LectureDto> springList(LectureDto dto) {
		return session.selectList("lecture.springList", dto);
	}

	@Override
	public List<LectureDto> springbootList(LectureDto dto) {
		return session.selectList("lecture.springbootList", dto);
	}

	@Override
	public List<LectureDto> mobileList(LectureDto dto) {
		return session.selectList("lecture.mobileList", dto);
	}
	
	@Override
	public List<LectureDto> kotlinList(LectureDto dto) {
		return session.selectList("lecture.kotlinList", dto);
	}

	@Override
	public int getCount() {
		return session.selectOne("lecture.getCount");
	}

	@Override
	public void insert(LectureDto dto) {
		session.insert("lecture.insert", dto);
		
	}

	@Override
	public LectureDto getData(int num) {
		return session.selectOne("lecture.getData", num);
	}

	@Override
	public void delete(int num) {
		session.delete("lecture.delete", num);
		
	}

	@Override
	public void update(LectureDto dto) {
		session.update("lecture.update", dto);
		
	}


}
