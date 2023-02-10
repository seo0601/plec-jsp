package com.acorn.project.lectureReview.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureReviewReq")
public class LectureReviewReq {
	private int num;
	private String content;
	private int star;
	
	public LectureReviewReq() {}

	public LectureReviewReq(int num, String content, int star) {
		super();
		this.num = num;
		this.content = content;
		this.star = star;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	
}
