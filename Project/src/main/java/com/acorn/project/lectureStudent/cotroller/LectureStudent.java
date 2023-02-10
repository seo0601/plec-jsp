package com.acorn.project.lectureStudent.cotroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.project.lectureStudent.dto.LectureStudentReq;
import com.acorn.project.lectureStudent.dto.LectureStudentRes;
import com.acorn.project.lectureStudent.service.LectureStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "LectureStudent")
@RestController
@RequestMapping(value = "/api")
public class LectureStudent {
	@Autowired LectureStudentService service;
	
	@ApiOperation(value = "lectureStudentList")	
    @GetMapping(value = "/lectureStudent/studentlist")
    public Map<String,Object> list(@RequestParam(value = "pageNum", required = true)int pageNum,
							@RequestParam(value = "large_category", required = false)String large_category,
							@RequestParam(value = "small_category", required = false)String small_category){
		
		return service.studentList(pageNum, large_category, small_category);
	}
	@GetMapping(value = "/lectureStudent/lectureSignup")
    public Map<String,String> LectureSignup(@RequestBody LectureStudentRes res, int num){
        return service.lectureSignup(res);
    }
	
	@ApiOperation(value="강의 완료", notes = "강의 완료되었는지 ")
	@PutMapping("/lectureStudent/lectureComplete")
	public Map<String, String> update(@RequestBody LectureStudentRes res){
		
		LectureStudentReq req = new LectureStudentReq();
		req.setId(res.getId());
		req.setRef_group(res.getRef_group());
		req.setComplete(res.getComplete());
		
		return service.lectureComplete(req);
	}
}
