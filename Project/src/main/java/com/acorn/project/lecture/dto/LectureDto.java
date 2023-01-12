package com.acorn.project.lecture.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("lectureDto")
public class LectureDto {
	private int lectureNum;
	private String teacher;
	private String title;
	private String describe;
	private String videoPath;
	private String imagePath;
	private String regdate;
	private int viewCount;
	private int Large_category;
	private int small_category;
	private int startRowNum;
	private int endRowNum;
	private int prevNum; 
	private int nextNum; 
	private MultipartFile image;	
	
	public LectureDto() {}

	public LectureDto(int lectureNum, String teacher, String title, String describe, String videoPath, String imagePath,
			String regdate, int viewCount, int large_category, int small_category, int startRowNum, int endRowNum,
			int prevNum, int nextNum, MultipartFile image) {
		super();
		this.lectureNum = lectureNum;
		this.teacher = teacher;
		this.title = title;
		this.describe = describe;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
		this.regdate = regdate;
		this.viewCount = viewCount;
		Large_category = large_category;
		this.small_category = small_category;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.prevNum = prevNum;
		this.nextNum = nextNum;
		this.image = image;
	}

	public int getLectureNum() {
		return lectureNum;
	}

	public void setLectureNum(int lectureNum) {
		this.lectureNum = lectureNum;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getLarge_category() {
		return Large_category;
	}

	public void setLarge_category(int large_category) {
		Large_category = large_category;
	}

	public int getSmall_category() {
		return small_category;
	}

	public void setSmall_category(int small_category) {
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	

	
	
	
	
}
