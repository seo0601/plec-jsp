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
	public LectureStudentDto delete(int ref_group) {
		return session.selectOne("lectureStudent.getData", ref_group);
	}

	@Override
	public int getCount() {
		return session.selectOne("lecture.getCount");
	}


	@Override
	public List<LectureStudentDto> studentList(LectureStudentDto dto) {
		return session.selectList("lectureStudent.studentList", dto);
	}

	@Override
	public LectureStudentDto studentData(LectureStudentDto dto) {
		return session.selectOne("lectureStudent.studentData", dto);
	}


}
