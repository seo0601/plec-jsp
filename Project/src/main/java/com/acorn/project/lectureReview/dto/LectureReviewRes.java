package com.acorn.project.lectureReview.dto;

import org.apache.ibatis.type.Alias;

@Alias("lectureReviewRes")
public class LectureReviewRes {
	private String content;
	private int star;
	
	public LectureReviewRes() {}

	public LectureReviewRes(String content, int star) {
		super();
		this.content = content;
		this.star = star;
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
