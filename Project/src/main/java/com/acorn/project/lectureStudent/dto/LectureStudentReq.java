package com.acorn.project.lectureStudent.dto;

public class LectureStudentReq {
	private int num;
	private String id;
	private int ref_group;
	private String complete;
	
	public LectureStudentReq() {}

	public LectureStudentReq(int num, String id, int ref_group, String complete) {
		super();
		this.num = num;
		this.id = id;
		this.ref_group = ref_group;
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

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	
}
