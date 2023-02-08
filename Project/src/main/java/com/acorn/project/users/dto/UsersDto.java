package com.acorn.project.users.dto;

import org.apache.ibatis.type.Alias;

@Alias("usersDto")
public class UsersDto {
	private String id;
	private String pwd;
	private String email;
	private String profile;
	private String regdate;
	private String phone;
	private String birth;
	private String newPwd;
	private String isSave;
	private String imagePath;
	private String complete;
	private String large_category;
	private String small_category;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;
	private int nextNum;
	
	public UsersDto() {}

	public UsersDto(String id, String pwd, String email, String profile, String regdate, String phone, String birth,
			String newPwd, String isSave, String imagePath, String complete, String large_category,
			String small_category, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.profile = profile;
		this.regdate = regdate;
		this.phone = phone;
		this.birth = birth;
		this.newPwd = newPwd;
		this.isSave = isSave;
		this.imagePath = imagePath;
		this.complete = complete;
		this.large_category = large_category;
		this.small_category = small_category;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getIsSave() {
		return isSave;
	}

	public void setIsSave(String isSave) {
		this.isSave = isSave;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
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
