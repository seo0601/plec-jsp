package com.acorn.project.faq.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.faq.dto.FaqDto;

@Repository
public class FaqDaoImpl implements FaqDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(FaqDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FaqDto dto) {
		// TODO Auto-generated method stub
		
	}

}
