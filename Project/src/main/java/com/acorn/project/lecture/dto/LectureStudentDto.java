package com.acorn.project.lecture.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureStudentDto")
public class LectureStudentDto {
	private int num;
	private String id;
	private int lectureSign;
	private String complete;
	
	public LectureStudentDto() {}

	public LectureStudentDto(int num, String id, int lectureSign, String complete) {
		super();
		this.num = num;
		this.id = id;
		this.lectureSign = lectureSign;
		this.complete = complete;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLectureSign() {
		return lectureSign;
	}

	public void setLectureSign(int lectureSign) {
		this.lectureSign = lectureSign;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	

	
	
	
}
