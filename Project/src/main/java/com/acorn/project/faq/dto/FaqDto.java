package com.acorn.project.faq.dto;

import org.apache.ibatis.type.Alias;

@Alias("faqDto")
public class FaqDto {
	private int num;
	private String question;
	private String content;
	private int startRowNum;
	private int endRowNum;
	private int prevNum;	//이전글의 글번호
	private int nextNum;	//다음글의 글번호
	
	public FaqDto() {}

	public FaqDto(int num, String question, String content, int startRowNum, int endRowNum, int prevNum, int nextNum) {
		super();
		this.num = num;
		this.question = question;
		this.content = content;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
