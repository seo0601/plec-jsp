package com.acorn.project.users.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.project.users.dao.UsersDao;
import com.acorn.project.users.dto.UsersDto;


@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;
	
	@Value("${file.location}")
	private String fileLocation;
	
	@Override
	public Map<String, Object> isExistId(String inputId) {
		UsersDto dto = dao.getData(inputId);
		Map<String, Object> isExist = new HashMap<>();
		
		if(dto==null) {
			isExist.put("isExist", false);
		}else {
			isExist.put("isExist", true);
		}
		return isExist;
	}
	//회원 한명의 정보 추가하는 메소드
	@Override
	public void addUser(UsersDto dto) {
		String pwd=dto.getPwd();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPwd=encoder.encode(pwd);
		dto.setPwd(encodedPwd);
		dao.insert(dto);
	}
	//로그인 처리를 하는 메소드
	@Override
	public void loginProcess(UsersDto dto, HttpSession session, HttpServletResponse response) {
		boolean isValid=false;
		UsersDto resultDto=dao.getData(dto.getId());
		if(resultDto != null) {
			isValid = BCrypt.checkpw(dto.getPwd(), resultDto.getPwd());
		}
		//if 유효한 정보? 
		if(isValid) {
			session.setAttribute("id", resultDto.getId());			
		}
		//로그인 정보를 저장=> 쿠키로 응답
		String isSave=dto.getIsSave();
		if(isSave == null){//체크박스 체크 x
			//저장된 쿠키 삭제 
			Cookie idCook=new Cookie("savedId", dto.getId());
			idCook.setMaxAge(0);//삭제하기 위해 0 으로 설정 
			response.addCookie(idCook);
			Cookie pwdCook=new Cookie("savedPwd", dto.getNewPwd());
			pwdCook.setMaxAge(0);
			response.addCookie(pwdCook);
		}else{//체크박스 체크o
			//아이디와 비밀번호를 쿠키에 저장
			Cookie idCook=new Cookie("savedId", dto.getId());
			idCook.setMaxAge(60*60*24);//하루동안 유지
			response.addCookie(idCook);
			Cookie pwdCook=new Cookie("savedPwd", dto.getPwd());
			pwdCook.setMaxAge(60*60*24);
			response.addCookie(pwdCook);
		}
	}

	@Override
	public void getInfo(HttpSession session, ModelAndView mView) { 
		String id=(String)session.getAttribute("id");
		UsersDto dto=dao.getData(id);
		mView.addObject("dto", dto);
	}

	
	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {		
		String orgFileName=mFile.getOriginalFilename();
		String saveFileName=System.currentTimeMillis()+orgFileName;

		String realPath=fileLocation;
		File upload=new File(realPath);
		if(!upload.exists()) {
			upload.mkdir(); 
		}
		try {
			String savePath=realPath+File.separator+saveFileName;
			mFile.transferTo(new File(savePath));
		}catch(Exception e) {
			e.printStackTrace();
		}		
		// json 문자열을 출력하기 위한 Map 객체 생성하고 정보 담기 
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("imagePath", saveFileName);
		
		return map;
	}

	@Override
	public void updateUser(UsersDto dto, HttpSession session, ModelAndView mView) {
		String id=(String)session.getAttribute("id");
		dto.setId(id);
		if(dto.getProfile().equals("empty")) {
			dto.setProfile(null);
		}
		dao.update(dto);
	}

	@Override
	public void deleteUser(HttpSession session, ModelAndView mView) {
		String id=(String)session.getAttribute("id");
		dao.delete(id);
		session.removeAttribute("id");
		mView.addObject("id", id);
		
	}
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

		//특수기호를 인코딩한 키워드를 미리 준비한다. 
		String encodedK=URLEncoder.encode(keyword);
			
		//CafeDto 객체에 startRowNum 과 endRowNum 을 담는다.
		UsersDto dto=new UsersDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);

		//만일 검색 키워드가 넘어온다면 
		if(!keyword.equals("")){
			//검색 조건이 무엇이냐에 따라 분기 하기
			if(condition.equals("id")){
				//검색 키워드를 CafeDto 에 담아서 전달한다.
				dto.setId(keyword);	
			}else if(condition.equals("birth")) {
				dto.setBirth(keyword);
			}else if(condition.equals("phone")) {
				dto.setPhone(keyword);
			}else if(condition.equals("email")) {
				dto.setEmail(keyword);
			}else if(condition.equals("regdate")) {
				dto.setRegdate(keyword);
			}
			// 다른 검색 조건을 추가 하고 싶다면 아래에 else if() 를 계속 추가 하면 된다.
		}
		
		//글 목록 얻어오기 
		List<UsersDto> list=dao.getList(dto);
		//전체글의 갯수
		int totalRow=dao.getCount();
		
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
		//view page 에서 필요한 값을 request 에 담아준다. 
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
		
		
	
	//회원 강제 삭제
	@Override
	public void forceDelete(String id, HttpServletRequest request) {
		dao.delete(id);
		
	}
	@Override
	public void updateUserPwd(HttpSession session, UsersDto dto, ModelAndView mView) {
		String id=(String)session.getAttribute("id");
		UsersDto resultDto=dao.getData(id);
		String encodedPwd=resultDto.getPwd();
		String inputPwd=dto.getPwd();
		boolean isValid=BCrypt.checkpw(inputPwd, encodedPwd);
		//if 일치?
		if(isValid) {
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			String encodedNewPwd=encoder.encode(dto.getNewPwd());
			dto.setNewPwd(encodedNewPwd);
			dto.setId(id);
			dao.updatePwd(dto);
			session.removeAttribute("id");
		}
		mView.addObject("isSuccess", isValid);
		mView.addObject("id", id);		
		
	}
	@Override
	public void myLectureList(HttpServletRequest request) {
		String id  = (String)request.getSession().getAttribute("id");
		final int PAGE_ROW_COUNT=8;
		final int PAGE_DISPLAY_COUNT=5;
	   
		int pageNum=1;
		String strPageNum = request.getParameter("pageNum");
		if(strPageNum != null){
			pageNum=Integer.parseInt(strPageNum);
		}
	   
		int startRowNum = 1 + (pageNum-1) * PAGE_ROW_COUNT;
		int endRowNum = pageNum * PAGE_ROW_COUNT;
	   
		UsersDto dto = new UsersDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		dto.setId(id);
		
		List<UsersDto> list = dao.myLectureList(dto);
	   
		int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT) * PAGE_DISPLAY_COUNT;
		int endPageNum = startPageNum + PAGE_DISPLAY_COUNT - 1;
	   
		int totalRow = dao.getCount();
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
		
	}
	

}