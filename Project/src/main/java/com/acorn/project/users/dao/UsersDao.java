package com.acorn.project.users.dao;

import java.util.List;

import com.acorn.project.users.dto.UsersDto;

public interface UsersDao {
	//아이디 존재 여부 리턴
	public boolean isExist(String inputId);
	public int getCount(UsersDto dto);
	//가입하는 회원 정보를 DB 에 저장하는 메소드
	public void insert(UsersDto dto);
	//아이디에 해당하는 정보 리턴 메소드
	public UsersDto getData(String id);
	//개인정보 수정 메소드
	public void update(UsersDto dto);
	//비밀번호 수정 메소드
	public void updatePwd(UsersDto dto);
	//회원정보 삭제 메소드
	public void delete(String id);
	//전체 회원 정보 메소드
	public List<UsersDto> getList(UsersDto dto);
	
}
