package com.acorn.project.lecture.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReviewDto;
import com.acorn.project.lecture.dto.LectureStudentDto;
import com.acorn.project.letcure.dao.LectureDao;
import com.acorn.project.letcure.dao.LectureReviewDao;
import com.acorn.project.letcure.dao.LectureStudentDao;

@Service
public class LectureServiceImpl implements LectureService{

	@Autowired LectureDao lectureDao;
	@Autowired LectureReviewDao reviewDao;
	@Autowired LectureStudentDao studentDao;

	
	@Value("${file.location}")
	private String fileLocation;
	
	@Override
	public void backEndList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.backEndList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}
	
	@Override
	public void javaList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.javaList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void springList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.springList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void springbootList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.springbootList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void frontEndList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=8;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=5;
	   
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		//startRowNum 과 endRowNum  을 GalleryDto 객체에 담고
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		//GalleryDao 객체를 이용해서 회원 목록을 얻어온다.
		List<LectureDto> list = lectureDao.frontEndList(dto);
	   
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		//전체 row 의 갯수
		int totalRow = lectureDao.getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount; //보정해 준다. 
		}
		
		//request 영역에 담아주기
		request.setAttribute("list", list);	//gallery list
		request.setAttribute("startPageNum", startPageNum);	//시작 페이지 번호
		request.setAttribute("endPageNum", endPageNum);	//끝 페이지 번호
		request.setAttribute("pageNum", pageNum);	//현재 페이지 번호
		request.setAttribute("totalPageCount", totalPageCount);	//모든 페이지 count
		
	}
	
	@Override
	public void jsList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.jsList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void html_cssList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.html_cssList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void reactList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.reactList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void vueList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.vueList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void jQueryList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.jQueryList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void mobileList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=8;
		//하단 페이지를 몇개씩 표시할 것인지
		final int PAGE_DISPLAY_COUNT=5;
	   
		//보여줄 페이지의 번호를 일단 1이라고 초기값 지정
		int pageNum=1;
		//페이지 번호가 파라미터로 전달되는지 읽어와 본다.
		String strPageNum = request.getParameter("pageNum");
		//만일 페이지 번호가 파라미터로 넘어 온다면
		if(strPageNum != null){
			//숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		//startRowNum 과 endRowNum  을 GalleryDto 객체에 담고
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		//GalleryDao 객체를 이용해서 회원 목록을 얻어온다.
		List<LectureDto> list = lectureDao.mobileList(dto);
	   
		//하단 시작 페이지 번호 
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		//하단 끝 페이지 번호
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		//전체 row 의 갯수
		int totalRow = lectureDao.getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		//끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount; //보정해 준다. 
		}
		
		//request 영역에 담아주기
		request.setAttribute("list", list);	//gallery list
		request.setAttribute("startPageNum", startPageNum);	//시작 페이지 번호
		request.setAttribute("endPageNum", endPageNum);	//끝 페이지 번호
		request.setAttribute("pageNum", pageNum);	//현재 페이지 번호
		request.setAttribute("totalPageCount", totalPageCount);	//모든 페이지 count
		
	}

	@Override
	public void kotlinList(HttpServletRequest request) {
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
	   
		List<LectureDto> list = lectureDao.kotlinList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		
	}

	@Override
	public void insert(LectureDto dto, HttpServletRequest request) {
		dto.setWriter((String)request.getSession().getAttribute("id"));
		lectureDao.insert(dto);
		
	}

	@Override
	public void getDetail(HttpServletRequest request) {
		//자세히 보여줄 글번호를 읽어온다. 
		int num=Integer.parseInt(request.getParameter("num"));
		String id = (String)request.getSession().getAttribute("id");
		//조회수 올리기
		lectureDao.addViewCount(num);
		
		/*
			[ 검색 키워드에 관련된 처리 ]
			-검색 키워드가 파라미터로 넘어올수도 있고 안넘어 올수도 있다.		
		*/
		
		String keyword=request.getParameter("keyword");
		String condition=request.getParameter("condition");
		//만일 키워드가 넘어오지 않는다면 
		if(keyword==null){
			//키워드와 검색 조건에 빈 문자열을 넣어준다. 
			//클라이언트 웹브라우저에 출력할때 "null" 을 출력되지 않게 하기 위해서  
			keyword="";
			condition=""; 
		}
		//LectureDto 객체를 생성해서 
		LectureDto dto=new LectureDto();
		//자세히 보여줄 글번호를 넣어준다. 
		dto.setNum(num);

		//글하나의 정보를 얻어온다.
		LectureDto resultDto=lectureDao.getData(num);
		
		//특수기호를 인코딩한 키워드를 미리 준비한다. 
		String encodedK=URLEncoder.encode(keyword);
		
		/*
			[ 댓글 페이징 처리에 관련된 로직 ]
		*/
		//한 페이지에 몇개씩 표시할 것인지
		final int PAGE_ROW_COUNT=10;
	
		//detail.jsp 페이지에서는 항상 1페이지의 댓글 내용만 출력한다. 
		int pageNum=1;
	
		//보여줄 페이지의 시작 ROWNUM
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지의 끝 ROWNUM
		int endRowNum=pageNum*PAGE_ROW_COUNT;
	
		//원글의 글번호를 이용해서 해당글에 달린 댓글 목록을 얻어온다.
		LectureReviewDto commentDto=new LectureReviewDto();
		commentDto.setRef_group(num);
		//1페이지에 해당하는 startRowNum 과 endRowNum 을 dto 에 담아서  
		commentDto.setStartRowNum(startRowNum);
		commentDto.setEndRowNum(endRowNum);
		
		//1페이지에 해당하는 댓글 목록만 select 되도록 한다. 
		List<LectureReviewDto> commentList=reviewDao.getList(commentDto);
		
		//원글의 글번호를 이용해서 댓글 전체의 갯수를 얻어낸다.
		int totalRow=reviewDao.getCount(num);
		//댓글 전체 페이지의 갯수
		int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
				
		int ref_group = Integer.parseInt(request.getParameter("num"));
		LectureStudentDto lsDto = new LectureStudentDto();
		lsDto.setId(id);
		lsDto.setRef_group(ref_group);
		
		LectureStudentDto lsDto2  = studentDao.studentData(lsDto);
		
		//request scope 에 글 하나의 정보 담기
		request.setAttribute("dto", resultDto);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("encodedK", encodedK);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("commentList", commentList);
		request.setAttribute("totalPageCount", totalPageCount);
		request.setAttribute("lsDto2", lsDto2);
		
	}

	@Override
	public void saveImage(LectureDto dto, HttpServletRequest request) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값을 얻어오기
		MultipartFile image = dto.getImage();
		//원본 파일명 -> 저장할 파일 이름 만들기위해서 사용됨
		String orgFileName = image.getOriginalFilename();
		//파일 크기 -> 다운로드가 없으므로, 여기서는 필요 없다.
		long fileSize = image.getSize();
		
		// 파일을 저장할 서버에서의 절대 경로
		String realPath = fileLocation;
		//db 에 저장할 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if(!upload.exists()) {
			//만약 디렉토리가 존재하지X
			upload.mkdir();//폴더 생성
		}
		//저장할 파일의 이름을 구성한다. -> 우리가 직접 구성해줘야한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		
		try {
			//upload 폴더에 파일을 저장한다.
			image.transferTo(new File(filePath + saveFileName));
			System.out.println();	//임시 출력
		}catch(Exception e) {
			e.printStackTrace();
		}
		String id = (String)request.getSession().getAttribute("id");
		dto.setWriter(id);
	
		dto.setImagePath(saveFileName);
		
		
		lectureDao.insert(dto);

	}

	@Override
	public void updateContent(LectureDto dto, HttpServletRequest request) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값을 얻어오기
		MultipartFile image = dto.getImage();
		//원본 파일명 -> 저장할 파일 이름 만들기위해서 사용됨
		String orgFileName = image.getOriginalFilename();
		
		
		// 파일을 저장할 서버에서의 절대 경로
		String realPath = fileLocation;
		//db 에 저장할 저장할 파일의 상세 경로
		String filePath = realPath + File.separator;
		//디렉토리를 만들 파일 객체 생성
		File upload = new File(filePath);
		if(!upload.exists()) {
			//만약 디렉토리가 존재하지X
			upload.mkdir();//폴더 생성
		}
		//저장할 파일의 이름을 구성한다. -> 우리가 직접 구성해줘야한다.
		String saveFileName = System.currentTimeMillis() + orgFileName;
		
		try {
			//upload 폴더에 파일을 저장한다.
			image.transferTo(new File(filePath + saveFileName));
			System.out.println();	//임시 출력
		}catch(Exception e) {
			e.printStackTrace();
		}
		String id = (String)request.getSession().getAttribute("id");
		dto.setWriter(id);	
		
		dto.setImagePath(saveFileName);
		lectureDao.update(dto);
		
	}
	

	@Override
	public void deleteContent(int num, HttpServletRequest request) {
		lectureDao.delete(num);
		
	}

	@Override
	public void getData(HttpServletRequest request) {

		int num=Integer.parseInt(request.getParameter("num"));

		LectureDto dto=lectureDao.getData(num);
		
		request.setAttribute("dto", dto);	
		
	}

	@Override
	public void saveReview(HttpServletRequest request) {
		//폼 전송되는 파라미터 추출 
		int ref_group=Integer.parseInt(request.getParameter("ref_group")); //원글의 글번호
		String target_id=request.getParameter("target_id"); //댓글 대상자의 아이디
		String content=request.getParameter("content"); //댓글의 내용 
		int star = Integer.parseInt(request.getParameter("star"));
		/*
		 *  원글의 댓글은 comment_group 번호가 전송이 안되고
		 *  댓글의 댓글은 comment_group 번호가 전송이 된다.
		 *  따라서 null 여부를 조사하면 원글의 댓글인지 댓글의 댓글인지 판단할수 있다. 
		 */
		String comment_group=request.getParameter("comment_group");

		//댓글 작성자는 session 영역에서 얻어내기
		String writer=(String)request.getSession().getAttribute("id");
		//댓글의 시퀀스 번호 미리 얻어내기
		int seq=reviewDao.getSequence();
		//저장할 댓글의 정보를 dto 에 담기
		LectureReviewDto dto=new LectureReviewDto();
		dto.setNum(seq);
		dto.setWriter(writer);
		dto.setTarget_id(target_id);
		dto.setContent(content);
		dto.setRef_group(ref_group);
		dto.setStar(star);
		//원글의 댓글인경우
		if(comment_group == null){
			//댓글의 글번호를 comment_group 번호로 사용한다.
			dto.setComment_group(seq);
		}else{
			//전송된 comment_group 번호를 숫자로 바꾸서 dto 에 넣어준다. 
			dto.setComment_group(Integer.parseInt(comment_group));
		}
		//댓글 정보를 DB 에 저장하기
		reviewDao.insert(dto);	
		
	}

	@Override
	public void deleteReview(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("num"));
		LectureReviewDto dto=reviewDao.getData(num);
	    String id=(String)request.getSession().getAttribute("id");

	      
	    reviewDao.delete(num);
		
	}

	@Override
	public void updateReview(LectureReviewDto dto) {
		reviewDao.update(dto);
		
	}

	@Override
	public void moreReviewList(HttpServletRequest request) {
		  //로그인된 아이디
	      String id=(String)request.getSession().getAttribute("id");
	      //ajax 요청 파라미터로 넘어오는 댓글의 페이지 번호를 읽어낸다
	      int pageNum=Integer.parseInt(request.getParameter("pageNum"));
	      //ajax 요청 파라미터로 넘어오는 원글의 글 번호를 읽어낸다
	      int num=Integer.parseInt(request.getParameter("num"));
	      /*
	         [ 댓글 페이징 처리에 관련된 로직 ]
	      */
	      //한 페이지에 몇개씩 표시할 것인지
	      final int PAGE_ROW_COUNT=10;
	
	      //보여줄 페이지의 시작 ROWNUM
	      int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
	      //보여줄 페이지의 끝 ROWNUM
	      int endRowNum=pageNum*PAGE_ROW_COUNT;
	
	      //원글의 글번호를 이용해서 해당글에 달린 댓글 목록을 얻어온다.
	      LectureReviewDto commentDto=new LectureReviewDto();
	      commentDto.setRef_group(num);
	      //1페이지에 해당하는 startRowNum 과 endRowNum 을 dto 에 담아서  
	      commentDto.setStartRowNum(startRowNum);
	      commentDto.setEndRowNum(endRowNum);
	
	      //pageNum에 해당하는 댓글 목록만 select 되도록 한다. 
	      List<LectureReviewDto> commentList=reviewDao.getList(commentDto);
	      //원글의 글번호를 이용해서 댓글 전체의 갯수를 얻어낸다.
	      int totalRow=reviewDao.getCount(num);
	      //댓글 전체 페이지의 갯수
	      int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
	
	      //view page 에 필요한 값 request 에 담아주기
	      request.setAttribute("commentList", commentList);
	      request.setAttribute("num", num); //원글의 글번호
	      request.setAttribute("pageNum", pageNum); //댓글의 페이지 번호	
		
	}

	//수강신청
	@Override
	public void lectureSignup(LectureStudentDto dto, HttpServletRequest request) {
		String id  = (String)request.getSession().getAttribute("id");
		int seq=reviewDao.getSequence();
		dto.setNum(seq);
		dto.setId(id);
		studentDao.lectureSignup(dto);
		request.setAttribute("num", dto.getNum());		
	}

	


	@Override
	public void studentList(HttpServletRequest request) {
		int Large_category=Integer.parseInt(request.getParameter("Large_category"));
		int small_category=Integer.parseInt(request.getParameter("small_category"));
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureStudentDto dto = new LectureStudentDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setLarge_category(Large_category);
		dto.setSmall_category(small_category);
	   
		List<LectureStudentDto> list = studentDao.studentList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = studentDao.getCount();
		int totalPageCount = (int)Math.ceil(totalRow / (double)PAGE_ROW_COUNT);
		if(endPageNum > totalPageCount){
			endPageNum = totalPageCount;  
		}
		
		request.setAttribute("dto", dto);	
		request.setAttribute("list", list);	
		request.setAttribute("startPageNum", startPageNum);	
		request.setAttribute("endPageNum", endPageNum);	
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPageCount", totalPageCount);	
		request.setAttribute("Large_category", Large_category);
		request.setAttribute("small_category", small_category);
		
	}

	

}
