package com.acorn.project.lecture.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureReviewDto")
public class LectureReviewDto {
	private int num;
	private String writer;
	private String content;
	private String regdate;
	private int starRating;
	private String profile;
	private int startRowNum;
	private int endRowNum;
 

    
    public LectureReviewDto() {}



	public LectureReviewDto(int num, String writer, String content, String regdate, int starRating, String profile,
			int startRowNum, int endRowNum) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.regdate = regdate;
		this.starRating = starRating;
		this.profile = profile;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
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



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getRegdate() {
		return regdate;
	}



	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}



	public int getStarRating() {
		return starRating;
	}



	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
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


    
}
