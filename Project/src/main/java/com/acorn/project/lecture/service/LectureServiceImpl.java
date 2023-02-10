package com.acorn.project.lecture.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReq;
import com.acorn.project.lecture.dto.LectureRes;
import com.acorn.project.lectureReview.dao.LectureReviewDao;
import com.acorn.project.lectureReview.dto.LectureReviewDto;
import com.acorn.project.lectureStudent.dao.LectureStudentDao;
import com.acorn.project.lectureStudent.dto.LectureStudentDto;
import com.acorn.project.letcure.dao.LectureDao;


@Service
public class LectureServiceImpl implements LectureService{

	@Autowired LectureDao lectureDao;
	@Autowired LectureReviewDao reviewDao;
	@Autowired LectureStudentDao studentDao;

	
	@Value("${file.location}")
	private String fileLocation;
	
	@Override
	public Map<String, Object> LectureList(int pageNum, String large_category, String small_category) {
		
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int num = 1;
		String strPageNum = Integer.toString(pageNum);
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		LectureDto dto = new LectureDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setLarge_category(large_category);
		dto.setSmall_category(small_category);
	   
		List<LectureDto> list = lectureDao.LectureList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = lectureDao.getCount();
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
	

	@Override
	public Map<String, String> insert(LectureRes lectureRes) {
		lectureDao.insert(lectureRes);
		Map<String, String> map = new HashMap<>();
		map.put("isSuccess", "success");
		return map;
	}

	@Override
	public Map<String, Object> getDetail(int num, String ref_group) {

		lectureDao.addViewCount(num);

		LectureDto dto=new LectureDto();
		dto.setNum(num);

		LectureDto resultDto=lectureDao.getData(num);
		
		
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
				
		LectureStudentDto lsDto = new LectureStudentDto();		
		LectureStudentDto lsDto2  = studentDao.studentData(lsDto);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dto", resultDto);
		map.put("ref_group", ref_group);
		return map;
		
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
		
		
		

	}

	@Override
	public Map<String, String> updateContent(LectureReq lectureReq) {
	
		lectureDao.update(lectureReq);
		Map<String, String> map = new HashMap<String, String>();
		map.put("isSuccess","success");
		return map;
	}
	

	@Override
	public Map<String, String> deleteContent(int num) {
		lectureDao.delete(num);
		Map<String, String> map = new HashMap<String, String>();
		map.put("isSuccess","success");
				
		return map;
	}

	@Override
	public Map<String, Object> getData(int num) {
		LectureDto dto=lectureDao.getData(num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess","success");
		map.put("dto", dto);
		
		return map;	
		
	}

	

	@Override
	public Map<String, Object> uploadImage(LectureDto dto, HttpServletRequest request) {
		//업로드된 파일의 정보를 가지고 있는 MultipartFile 객체의 참조값을 얻어오기
		MultipartFile image = dto.getImage();
		//원본 파일명 -> 저장할 파일 이름 만들기위해서 사용됨
		String orgFileName = image.getOriginalFilename();
		//파일 크기
		long fileSize = image.getSize();
		
		// webapp/upload 폴더 까지의 실제 경로(서버의 파일 시스템 상에서의 경로)
		String realPath = request.getServletContext().getRealPath("/resources/upload");
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

		String imagePath = "/resources/upload/" + saveFileName;
		
		//ajax upload 를 위한 imagePath return
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("imagePath", imagePath);
		
		return map;
	}


}
