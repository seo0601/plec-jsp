package com.acorn.project.springswagger.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.service.LectureService;
import com.acorn.project.letcure.dao.LectureDao;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@Api("LectureController")
@RequestMapping("/api")
public class HelloController {
   @Autowired
   private LectureDao dao;
   
   @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses ({
            @ApiResponse(responseCode = "200", description = "성공!")
    })
    @GetMapping("/lecutre/detail")
   public LectureDto detail(int num) {
	return dao.getData(num);
   }

}