package com.acorn.project.letcure.dao;

import java.util.List;

import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReq;
import com.acorn.project.lecture.dto.LectureRes;

public interface LectureDao {
	//강의 리스트
	public List<LectureDto> LectureList(LectureDto dto);
	
	//모든 ROW 의 개수
	public int getCount();
	//강의 업로드
	public void insert(LectureRes lectureRes);
	//게시글 하나의 data 가져오기
	public LectureDto getData(int num);
	//게시글 삭제
	public void delete(int num);
	
	//게시글 수정
	public void update(LectureReq lectureReq);
	
	public void addViewCount(int num);
	

}
