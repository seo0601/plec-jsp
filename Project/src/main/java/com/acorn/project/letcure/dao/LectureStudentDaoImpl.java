package com.acorn.project.letcure.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.lecture.dto.LectureStudentDto;

@Repository
public class LectureStudentDaoImpl implements LectureStudentDao{
	
	@Autowired private SqlSession session;

	@Override
	public void lectureSignup(LectureStudentDto dto) {
		session.insert("lectureStudent.lectureSignup", dto);
		
	}

	@Override
	public int getSequence() {
		return session.selectOne("lectureStudent.getSequence");
	}

	@Override
	public LectureStudentDto getData(int ref_group) {
		return session.selectOne("lectureStudent.getData", ref_group);
	}

	@Override
	public int getCount() {
		return session.selectOne("lecture.getCount");
	}

	@Override
	public List<LectureStudentDto> frontEndList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.frontendList", dto);
	}

	@Override
	public List<LectureStudentDto> jsList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.jsList", dto);
	}

	@Override
	public List<LectureStudentDto> html_cssList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.htmlsssList", dto);
	}

	@Override
	public List<LectureStudentDto> reactList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.reactList", dto);
	}

	@Override
	public List<LectureStudentDto> vueList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.vueList", dto);
	}

	@Override
	public List<LectureStudentDto> jQueryList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.jQueryList", dto);
	}

	@Override
	public List<LectureStudentDto> backEndList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.backendList", dto);
	}

	@Override
	public List<LectureStudentDto> javaList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.javaList", dto);
	}

	@Override
	public List<LectureStudentDto> springList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.springList", dto);
	}

	@Override
	public List<LectureStudentDto> springbootList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.springbootList", dto);
	}

	@Override
	public List<LectureStudentDto> mobileList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.moblieList", dto);
	}

	@Override
	public List<LectureStudentDto> kotlinList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.kotlinList", dto);
	}

}
