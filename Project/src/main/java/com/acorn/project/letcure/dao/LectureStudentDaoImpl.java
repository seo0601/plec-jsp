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
	public List<LectureStudentDto> getList(LectureStudentDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void lectureSignup(LectureStudentDto dto) {
		session.insert("lectureStudent.lectureSignup", dto);
		
	}

}
