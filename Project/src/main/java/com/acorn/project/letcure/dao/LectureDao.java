package com.acorn.project.letcure.dao;

import java.util.List;

import com.acorn.project.lecture.dto.LectureDto;

public interface LectureDao {
	//프론트엔드 리스트
	public List<LectureDto> frontEndList(LectureDto dto);
	//백엔드 리스트
	public List<LectureDto> backEndList(LectureDto dto);
	//모바일 리스트
	public List<LectureDto> mobileList(LectureDto dto);
	//모든 ROW 의 개수
	public int getCount();
	//동영상 업로드
	public void insert(LectureDto dto);
	//게시글 하나의 data 가져오기
	public LectureDto getData(int num);
	//게시글 삭제
	public void delete(int num);
	//게시글 수정
	public void update(LectureDto dto);
	
}
