package com.acorn.project.notice.service;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.project.notice.dao.NoticeDao;
import com.acorn.project.notice.dto.NoticeDto;


@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public void getList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=5;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=5;
		
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
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		if(keyword==null){
			keyword="";
			condition=""; 
		}

		String encodedK=URLEncoder.encode(keyword);
			
		NoticeDto dto=new NoticeDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		if(!keyword.equals("")){
			if(condition.equals("title_content")){
				
				dto.setTitle(keyword);
				dto.setContent(keyword);
			}else if(condition.equals("title")){ 
				dto.setTitle(keyword);
			}
		}
		
		List<NoticeDto> list=noticeDao.getList(dto);
		
		int totalRow=noticeDao.getCount(dto);
		
		
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		

		
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		
		if(endPageNum > totalPageCount){
			endPageNum=totalPageCount; 
		}
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("list", list);
		request.setAttribute("totalRow", totalRow);
		
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		noticeDao.addViewCount(num);
	
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		
		if(keyword==null){
			
			keyword="";
			condition=""; 
		}
		
		NoticeDto dto=new NoticeDto();
		
		dto.setNum(num);
		
		if(!keyword.equals("")){
			if(condition.equals("title_content")){
				
				dto.setTitle(keyword);
				dto.setContent(keyword);			
			}else if(condition.equals("title")){ 
				dto.setTitle(keyword);	
			}
		}
		
		NoticeDto resultDto=noticeDao.getData(dto);

		String encodedK=URLEncoder.encode(keyword);
		
		final int PAGE_ROW_COUNT=10;

		int pageNum=1;

		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;

		int endRowNum=pageNum*PAGE_ROW_COUNT;

		request.setAttribute("dto", resultDto);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		
		
	}

	@Override
	public void saveContent(NoticeDto dto) {
		noticeDao.insert(dto);
		
	}

	@Override
	public void updateContent(NoticeDto dto) {
		noticeDao.update(dto);
		
	}

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		noticeDao.delete(num);
		
	}

	@Override
	public void getData(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		NoticeDto dto = noticeDao.getData(num);
		request.setAttribute("dto", dto);
		
	}

}
