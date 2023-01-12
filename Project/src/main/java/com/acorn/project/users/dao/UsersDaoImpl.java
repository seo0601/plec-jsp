package com.acorn.project.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.project.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;
	@Override
	public boolean isExist(String inputId) {
		UsersDto dto=session.selectOne("users.getData", inputId);
		boolean isExist = dto==null ? false : true;
		return isExist;
	}
	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto=session.selectOne("users.getData", id);
		return dto;
	}
	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}
	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}
	@Override
	public List<UsersDto> getList(UsersDto dto) {
		return session.selectList("users.getList", dto);
	}
	@Override
	public int getCount(UsersDto dto) {
		return session.selectOne("users.getCount", dto);
	}

}