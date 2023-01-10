package com.acorn.project.qna_board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.project.qna_board.dto.QnaBoardDto;
import com.acorn.project.qna_board.service.QnaBoardService;


@Controller
public class QnaBoardController {

	@Autowired
	private QnaBoardService service;
	
	@RequestMapping("/qna_board/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		
		return "qna_board/list";
	}
	
	@RequestMapping("/qna_board/insertform")
	public String insertForm() {
		return "qna_board/insertform";
	}
	
	@RequestMapping("/qna_board/insert")
	public String insert(QnaBoardDto dto, HttpSession session) {
		//글 작성자는 세션에서 얻어낸다.
		String writer=(String)session.getAttribute("id");
		//dto는 글의 제목과 내용만 있으므로 글작성자는 직접 넣어준다.
		dto.setWriter(writer);
		service.saveContent(dto);		
		return "qna_board/insert";
	}
	
	@RequestMapping("/qna_board/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		return "qna_board/detail";
	}
		
	@RequestMapping("/qna_board/delete")
	public String delete(int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return "redirect:/qna_board/list";
	}

	@RequestMapping("/qna_board/updateform")
	public String updateForm(HttpServletRequest request) {
		service.getData(request);
		return "qna_board/updateform";
	}
	
	@RequestMapping("/qna_board/update")
	public String update(QnaBoardDto dto) {		
		service.updateContent(dto);
		return "qna_board/update";
	}
	
	//새로운 댓글 저장 요청 처리
	/*@RequestMapping("/qna_board/comment_insert")
	public String commentInsert(HttpServletRequest request, int ref_group) {
      
      service.saveComment(request);
   
      return "redirect:/qna_board/detail?num="+ref_group;
	}
	//댓글 더보기 요청 처리
	@RequestMapping("/qna_board/ajax_comment_list")
	public String commentList(HttpServletRequest request) {
      		
		//테스트를 위해 시간 지연시키기
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		service.moreCommentList(request);
      
		return "qna_board/ajax_comment_list";
	}
	/*
	
	//댓글 삭제 요청 처리
	@RequestMapping("/qna_board/comment_delete")
	@ResponseBody
	public Map<String, Object> commentDelete(HttpServletRequest request) {
      service.deleteComment(request);
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("isSuccess", true);
      // {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
      return map;
	}
	
	//댓글 수정 요청처리 (JSON 으로 응답하도록 한다)
	@RequestMapping("/qna_board/comment_update")
	@ResponseBody
	public Map<String, Object> commentUpdate(QnaBoardCommentDto dto, HttpServletRequest request){
      service.updateComment(dto);
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("isSuccess", true);
      // {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
	      return map;
		}
		
	*/
}
