package com.acorn.project.lecture.dto;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("lectureReq")
public class LectureReq {
	private int num;
	private String writer;
    private String teacher;
    private String title;
    private String describe;
    private String imagePath; 
    private String videoPath;
    private String large_category;
    private String small_category; 
    private MultipartFile image;
    private int viewCount;
    
    public LectureReq() {}

	public LectureReq(int num, String writer, String teacher, String title, String describe, String imagePath,
			String videoPath, String large_category, String small_category, MultipartFile image, int viewCount) {
		super();
		this.num = num;
		this.writer = writer;
		this.teacher = teacher;
		this.title = title;
		this.describe = describe;
		this.imagePath = imagePath;
		this.videoPath = videoPath;
		this.large_category = large_category;
		this.small_category = small_category;
		this.image = image;
		this.viewCount = viewCount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
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

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	
	
	
    
    
}
