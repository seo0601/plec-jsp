package com.acorn.project.lecture.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureStudentDto")
public class LectureStudentDto {
	private int num;
	private String id;
	private int ref_group;
	private String complete;
	private String email;
	private String phone;
	private String birth;
	private String regdate;
	private String large_category;
	private String small_category;
	private int startRowNum;
	private int endRowNum;
	private int prevNum; 
	private int nextNum; 
	
	public LectureStudentDto() {}

	public LectureStudentDto(int num, String id, int ref_group, String complete, String email, String phone,
			String birth, String regdate, String large_category, String small_category, int startRowNum, int endRowNum,
			int prevNum, int nextNum) {
		super();
		this.num = num;
		this.id = id;
		this.ref_group = ref_group;
		this.complete = complete;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.regdate = regdate;
		this.large_category = large_category;
		this.small_category = small_category;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getLarge_category() {
		return large_category;
	}

	public void setLarge_category(String large_category) {
		this.large_category = large_category;
	}

	public String getSmall_category() {
		return small_category;
	}

	public void setSmall_category(String small_category) {
		this.small_category = small_category;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getPrevNum() {
		return prevNum;
	}

	public void setPrevNum(int prevNum) {
		this.prevNum = prevNum;
	}

	public int getNextNum() {
		return nextNum;
	}

	public void setNextNum(int nextNum) {
		this.nextNum = nextNum;
	}

	
	
	
	
}
