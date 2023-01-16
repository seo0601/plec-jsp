package com.acorn.project.lecture.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureStudentDto")
public class LectureStudentDto {
	private int num;
	private String id;
	private String complete;
	
	public LectureStudentDto() {}

	public LectureStudentDto(int num, String id, String complete) {
		super();
		this.num = num;
		this.id = id;
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

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
}
