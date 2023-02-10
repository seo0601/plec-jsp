package com.acorn.project.lecture.controller;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.acorn.project.lecture.dto.LectureReq;
import com.acorn.project.lecture.dto.LectureRes;
import com.acorn.project.lecture.service.LectureService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



@Api(value = "Lecture")
@RestController
@RequestMapping(value = "/api")
public class Lecture {
	@Autowired
    private LectureService service;
	 
	@ApiOperation(value = "lectureList")	
    @GetMapping(value = "/lecture/list")
    public Map<String,Object> list(@RequestParam(value = "pageNum", required = true)int pageNum,
							@RequestParam(value = "large_category", required = false)String large_category,
							@RequestParam(value = "small_category", required = false)String small_category){
		
		return service.LectureList(pageNum, large_category, small_category);
	}
     
    
	@GetMapping(value = "/lecture/detail")
	public Map<String, Object> detail(@PathVariable int num, @RequestParam(value = "ref_group", required = false)String ref_group) {
        return service.getDetail(num,ref_group);
    }
	
	
	@GetMapping(value = "/lecture/insert")
    public Map<String,String> insertLecture(@RequestBody LectureRes lectureRes, int num){
        return service.insert(lectureRes);
    }
	 

    @DeleteMapping(value = "/lecture/delete/{num}")
    public Map<String, String> deleteLecture(@PathVariable int num) {
    	
    	return service.deleteContent(num);
    }
    
    @PutMapping("/{num}/update")
	public Map<String, String> update(@PathVariable int num, @RequestBody LectureRes lectureRes){
		
    	LectureReq req = new LectureReq();
    	req.setNum(num);
    	req.setTeacher(lectureRes.getTeacher());
    	req.setTitle(lectureRes.getTitle());
    	req.setDescribe(lectureRes.getDescribe());
    	req.setImagePath(lectureRes.getImagePath());
    	req.setVideoPath(lectureRes.getVideoPath());
    	req.setLarge_category(lectureRes.getLarge_category());
    	req.setSmall_category(lectureRes.getSmall_category());
    	
		
		return service.updateContent(req);
	}
    
    @ApiOperation(value="강의 업데이트 전 상세", notes = "강의 업데이트 전 그 상세 데이터 내용을 가져온다.")
    @GetMapping(value = "/lecture/{num}/update")
    public Map<String, Object> getData(@PathVariable int num){

    	return service.getData(num);
    }
}