package com.acorn.project.lectureStudent.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.acorn.project.lectureStudent.dao.LectureStudentDao;
import com.acorn.project.lectureStudent.dto.LectureStudentDto;
import com.acorn.project.lectureStudent.dto.LectureStudentReq;
import com.acorn.project.lectureStudent.dto.LectureStudentRes;



@Service
public class LectureStudentServiceImpl implements LectureStudentService{

	@Autowired LectureStudentDao studentDao;

	@Override
	public Map<String, String> lectureSignup(LectureStudentRes res) {
		studentDao.lectureSignup(res);

		Map<String, String> map = new HashMap<String, String>();
		map.put("isSuccess","success");
				
		return map;
	
		
	}
	
	@Override
	public Map<String, String> lectureComplete(LectureStudentReq req) {
		studentDao.lectureComplete(req);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("isSuccess","success");
				
		return map;
		
	}

	@Override
	public Map<String, Object> studentList(int pageNum, String large_category, String small_category) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int num=1;
		String strPageNum = Integer.toString(pageNum);
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureStudentDto dto = new LectureStudentDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setLarge_category(large_category);
		dto.setSmall_category(small_category);
	   
		List<LectureStudentDto> list = studentDao.studentList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = studentDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("large_category", large_category);
		map.put("small_category", small_category);
		map.put("pageNum", pageNum);
		map.put("startPageNum", startPageNum);
		map.put("endPageNum", endPageNum);
		map.put("totalPageCount", totalPageCount);
		map.put("totalRow", totalRow);
		map.put("list", list);
		return map;
	}


	
	


}
