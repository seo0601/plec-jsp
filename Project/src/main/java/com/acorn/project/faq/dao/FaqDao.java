package com.acorn.project.faq.dao;

import com.acorn.project.faq.dto.FaqDto;

public interface FaqDao {
	//글 추가
	public void insert(FaqDto dto);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(FaqDto dto);
}
