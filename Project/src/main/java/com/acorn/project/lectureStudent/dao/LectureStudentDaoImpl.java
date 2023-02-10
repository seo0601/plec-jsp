package com.acorn.project.lectureStudent.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.lectureStudent.dto.LectureStudentDto;
import com.acorn.project.lectureStudent.dto.LectureStudentReq;
import com.acorn.project.lectureStudent.dto.LectureStudentRes;



@Repository
public class LectureStudentDaoImpl implements LectureStudentDao{
	
	@Autowired private SqlSession session;

	@Override
	public void lectureSignup(LectureStudentRes res) {
		session.insert("lectureStudent.lectureSignup", res);
		
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

	@Override
	public void lectureComplete(LectureStudentReq req) {
		session.update("lectureStudent.lectureComplete", req);
		
	}


}
