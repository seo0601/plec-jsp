package com.acorn.project.qna_free.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.project.qna_free.dto.QnaFreeAnswerDto;
import com.acorn.project.qna_free.dto.QnaFreeDto;
import com.acorn.project.qna_free.service.QnaFreeService;

@Controller
public class QnaFreeController {

	@Autowired
	private QnaFreeService service;
	
	@RequestMapping("/qna_free/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		
		return "qna_free/list";
	}
	
	@RequestMapping("/qna_free/insertform")
	public String insertForm() {
		return "qna_free/insertform";
	}
	
	@RequestMapping("/qna_free/insert")
	public String insert(QnaFreeDto dto, HttpSession session) {
		//글 작성자는 세션에서 얻어낸다.
		String writer=(String)session.getAttribute("id");
		//dto는 글의 제목과 내용만 있으므로 글작성자는 직접 넣어준다.
		dto.setWriter(writer);
		service.saveContent(dto);		
		return "qna_free/insert";
	}
	
	@RequestMapping("/qna_free/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		return "qna_free/detail";
	}
		
	@RequestMapping("/qna_free/delete")
	public String delete(int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return "redirect:/qna_free/list";
	}

	@RequestMapping("/qna_free/updateform")
	public String updateForm(HttpServletRequest request) {
		service.getData(request);
		return "qna_free/updateform";
	}
	
	@RequestMapping("/qna_free/update")
	public String update(QnaFreeDto dto) {		
		service.updateContent(dto);
		return "qna_free/update";
	}
	
	//새로운 댓글 저장 요청 처리
	@RequestMapping("/qna_free/comment_insert")
	public String commentInsert(HttpServletRequest request, int ref_group) {
      
      service.saveComment(request);
   
      return "redirect:/qna_free/detail?num="+ref_group;
	}
	//댓글 더보기 요청 처리
	@RequestMapping("/qna_free/ajax_comment_list")
	public String commentList(HttpServletRequest request) {
      		
		//테스트를 위해 시간 지연시키기
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		service.moreCommentList(request);
      
		return "qna_free/ajax_comment_list";
	}
	
	//댓글 수정 요청처리 (JSON 으로 응답하도록 한다)
	@RequestMapping("/qna_free/comment_update")
	@ResponseBody
	public Map<String, Object> commentUpdate(QnaFreeAnswerDto dto, HttpServletRequest request){
		service.updateComment(dto);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("isSuccess", true);
		// {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
	    return map;
	}
		
	
}
