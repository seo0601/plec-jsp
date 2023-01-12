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
		return null;
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
			dao.update(dto);
			session.removeAttribute("id");
		}
		mView.addObject("isSuccess", isValid);
		mView.addObject("id", id);	
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
		UsersDto dto=new UsersDto();
		
		List<UsersDto> list= dao.getList(dto);	
		
		request.setAttribute("list", list);
		
		}
	
	//회원 강제 삭제
	@Override
	public void forceDelete(String id, HttpServletRequest request) {
		dao.delete(id);
		
	}
	

}