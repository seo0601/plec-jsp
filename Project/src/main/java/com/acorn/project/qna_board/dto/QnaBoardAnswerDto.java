package com.acorn.project.qna_board.dto;

import org.apache.ibatis.type.Alias;

@Alias("qnaBoardAnswerDto")
public class QnaBoardAnswerDto {	
	private int num;
	private String writer;
	private String content;	
	private int ref_group;	
	private String regdate;
	private String profile;
	private int startRowNum;
	private int endRowNum;
	
	public QnaBoardAnswerDto () {}

	public QnaBoardAnswerDto(int num, String writer, String content, int ref_group, String regdate,
			String profile, int startRowNum, int endRowNum) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.ref_group = ref_group;		
		this.regdate = regdate;
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

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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
	};

	
}
