package com.acorn.project.faq.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.project.faq.dao.FaqDao;
import com.acorn.project.faq.dto.FaqDto;

@Service
public class FaqServiceImpl implements FaqService{

	@Autowired
	private FaqDao faqDao;

	@Override
	public void getList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=10;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=10;
		
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum=request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		
		String question=request.getParameter("question");
		String content=request.getParameter("content");
		
		//CafeDto 객체에 startRowNum 과 endRowNum 을 담는다.
		FaqDto dto=new FaqDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		//글 목록 얻어오기 
		List<FaqDto> list=faqDao.getList(dto);
		//전체글의 갯수
		int totalRow=faqDao.getCount(dto);
		
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		//전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 전체 페이지 갯수보다 크다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; //보정해 준다.
		}
		
		dto.setQuestion(question);
		dto.setContent(content);
		
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("totalRow", totalRow);
	}
	
	@Override
	public void saveContent(FaqDto dto) {
		faqDao.insert(dto);
	}

	@Override
	public void updateContent(FaqDto dto) {
		faqDao.update(dto);
	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		faqDao.delete(num);
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		
		String question=request.getParameter("question");
		String content=request.getParameter("content");
		FaqDto dto=new FaqDto();

		dto.setNum(num);
		dto.setQuestion(question);
		dto.setContent(content);

		FaqDto resultDto = faqDao.getData(dto);

		request.setAttribute("dto", resultDto);
	}

	@Override
	public void getData(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		FaqDto dto=new FaqDto();
		dto.setNum(num);
		FaqDto resultDto = faqDao.getData(dto);
		request.setAttribute("dto", resultDto);	
	}

}
