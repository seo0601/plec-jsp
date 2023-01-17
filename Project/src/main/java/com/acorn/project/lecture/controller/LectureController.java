package com.acorn.project.lecture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.acorn.project.lecture.dto.LectureDto;
import com.acorn.project.lecture.dto.LectureReviewDto;
import com.acorn.project.lecture.dto.LectureStudentDto;
import com.acorn.project.lecture.service.LectureService;



@Controller
public class LectureController {

	@Autowired private LectureService service;
	
	@Value("${file.location}")
	private String fileLocation;
	
	@GetMapping(
			value="/lecture/images/{imageName}",
			produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE}
		)
	@ResponseBody
	public byte[] galleryImage(@PathVariable("imageName") String imageName) throws IOException {
		
		String absolutePath=fileLocation+File.separator+imageName;
		//파일에서 읽어들일 InputStream
		InputStream is=new FileInputStream(absolutePath);
		//이미지 데이터(byte)를 읽어서 배열에 담아서 클라이언트에게 응답한다.
		return IOUtils.toByteArray(is);
	}	

	//프론트엔드 리스트
	@RequestMapping(value = "/lecture/frontend/frontendList")
	public String frontEndList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.frontEndList(request);
		
		return "lecture/frontend/frontendList";
	}
		
	//javascript 리스트
	@RequestMapping(value = "/lecture/frontend/jsList")
	public String jsList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.jsList(request);
		
		return "lecture/frontend/jsList";
	}
	
	//html_css 리스트
	@RequestMapping(value = "/lecture/frontend/html_cssList")
	public String html_cssList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.html_cssList(request);
		
		return "lecture/frontend/html_cssList";
	}
	
	//react 리스트
	@RequestMapping(value = "/lecture/frontend/reactList")
	public String reactList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.reactList(request);
		
		return "lecture/frontend/reactList";
	}
	
	//vue 리스트
	@RequestMapping(value = "/lecture/frontend/vueList")
	public String vueList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.vueList(request);
		
		return "lecture/frontend/vueList";
	}
	
	//jQuery 리스트
	@RequestMapping(value = "/lecture/frontend/jQueryList")
	public String jQueryList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.jQueryList(request);
		
		return "lecture/frontend/jQueryList";
	}
	
	//백엔드 리스트
	@RequestMapping(value = "/lecture/backend/backendList")
	public String backEndList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.backEndList(request);
		
		return "lecture/backend/backendList";
	}
	//java 리스트
	@RequestMapping(value = "/lecture/backend/javaList")
	public String javaList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.javaList(request);
		
		return "lecture/backend/javaList";
	}
	//spring 리스트
	@RequestMapping(value = "/lecture/backend/springList")
	public String springList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.springList(request);
		
		return "lecture/backend/springList";
	}
	//spring boot 리스트
	@RequestMapping(value = "/lecture/backend/springbootList")
	public String springbootList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.springbootList(request);
		
		return "lecture/backend/springbootList";
	}
		
	//모바일 리스트
	@RequestMapping(value = "/lecture/mobile/mobileList")
	public String mobileList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.mobileList(request);
		
		return "lecture/mobile/mobileList";
	}
	
	//kotlin 리스트
	@RequestMapping(value = "/lecture/mobile/kotlinList")
	public String kotlinList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.kotlinList(request);
		
		return "lecture/mobile/kotlinList";
	}
	
	@RequestMapping(value = "/lecture/upload_form")
	public String uploadForm() {
		
		return "lecture/upload_form";
	}
	
	@RequestMapping(value = "/lecture/upload")
	public String upload(LectureDto dto, HttpServletRequest request) {
		service.saveImage(dto, request);
		
		return "lecture/upload";
	}
	
	@RequestMapping("/lecture/insert")
	public String insert(LectureDto dto, HttpServletRequest request) {
		service.insert(dto, request);
		
		return "lecture/upload";
	}
	
	@RequestMapping("/lecture/detail")
	public String detail(HttpServletRequest request) {
		
		service.getDetail(request);
		
		return "lecture/detail";
	}
	
	@RequestMapping(value = "/lecture/lecture_view", method = RequestMethod.GET)
	public String request(HttpServletRequest request) {
		service.getDetail(request);
		return "lecture/lecture_view";
	}
	
	
	
	@RequestMapping("/lecture/delete")
	public String delete(int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return "redirect:/";
	}

	@RequestMapping("/lecture/updateform")
	public String updateForm(HttpServletRequest request) {
		service.getData(request);
		return "lecture/updateform";
	}
	
	@RequestMapping("/lecture/update")
	public String update(LectureDto dto,HttpServletRequest request) {		
		service.updateContent(dto,request);
		return "lecture/update";
	}
	
	//수강 신청 처리
	@RequestMapping("/lecture/lectureSignup")
	public String lectureSignup(LectureStudentDto dto, HttpServletRequest request) {
		service.lectureSignup(dto, request);
		return "lecture/lectureSignup";
	}
	
	
	//새로운 댓글 저장 요청 처리
	@RequestMapping("/lecture/lectureReview_insert")
	public String commentInsert(HttpServletRequest request, int ref_group) {
      
      service.saveReview(request);
   
      return "redirect:/lecture/detail?num="+ref_group;
	}
	
	//댓글 더보기 요청 처리
	@RequestMapping("/lecture/ajax_review_list")
	public String commentList(HttpServletRequest request) {
      		
		//테스트를 위해 시간 지연시키기
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		service.moreReviewList(request);
      
		return "lecture/ajax_review_list";
	}
	
	//댓글 삭제 요청 처리
	@RequestMapping("/lecture/lectureReview_delete")
	@ResponseBody
	public Map<String, Object> commentDelete(HttpServletRequest request) {
      service.deleteReview(request);
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("isSuccess", true);
      // {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
      return map;
	}
	//댓글 수정 요청처리 (JSON 으로 응답하도록 한다)
	@RequestMapping("/lecture/lectureReview_update")
	@ResponseBody
	public Map<String, Object> commentUpdate(LectureReviewDto dto, HttpServletRequest request){
      service.updateReview(dto);
      Map<String, Object> map=new HashMap<String, Object>();
      map.put("isSuccess", true);
      // {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
	      return map;
		}
	//수강 신청 프론트엔드 리스트
	@RequestMapping(value = "/studentLecture/frontend/frontendList")
	public String lecturefrontEndList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureFrontEndList(request);
		
		return "/studentLecture/frontend/frontendList";
	}
	
	
	//수강 신청 js 리스트
	@RequestMapping(value = "/studentLecture/frontend/jsList")
	public String lecturejsList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureJsList(request);
		
		return "/studentLecture/frontend/jsList";
	}
	//수강 신청 html_css 리스트
	@RequestMapping(value = "/studentLecture/frontend/html_cssList")
	public String lecturehtml_cssList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureHtml_cssList(request);
		
		return "/studentLecture/frontend/html_cssList";
	}
	//수강 신청 react 리스트
	@RequestMapping(value = "/studentLecture/frontend/reactList")
	public String lectureReactList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureReactList(request);
		
		return "/studentLecture/frontend/reactList";
	}
	//수강 신청 vue 리스트
	@RequestMapping(value = "/studentLecture/frontend/vueList")
	public String lectureVueList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureVueList(request);
		
		return "/studentLecture/frontend/vueList";
	}
	//수강 신청 제이쿼리 리스트
	@RequestMapping(value = "/studentLecture/frontend/jQueryList")
	public String lecturejQueryList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lecturejQueryList(request);
		
		return "/studentLecture/frontend/jQueryList";
	}
	
	
	//수강 신청 백엔드 리스트
	@RequestMapping(value = "/studentLecture/backend/backendList")
	public String lectureBackEndList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureBackEndList(request);
		
		return "studentLecture/backend/backendList";
	}
	//수강 신청 자바 리스트
	@RequestMapping(value = "/studentLecture/backend/javaList")
	public String lectureJavaList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureJavaList(request);
		
		return "studentLecture/backend/javaList";
	}
	//수강 신청 스프링 리스트
	@RequestMapping(value = "/studentLecture/backend/springList")
	public String lectureSpringList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureSpringList(request);
		
		return "studentLecture/backend/springList";
	}
	//수강 신청 스프링 부트 리스트
	@RequestMapping(value = "/studentLecture/backend/springbootList")
	public String lectureSpringBootList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureSpringbootList(request);
		
		return "studentLecture/backend/springbootList";
	}
	//수강 신청 모바일 리스트
	@RequestMapping(value = "/studentLecture/moblie/moblieList")
	public String lectureMobileList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureMobileList(request);
		
		return "studentLecture/moblie/moblieList";
	}
	//수강 신청 코틀린 리스트
	@RequestMapping(value = "/studentLecture/moblie/kotlinList")
	public String lectureKotlinList(HttpServletRequest request) {
		//view 페이지에 사용될 데이터는 request 영역에 담는다.
		service.lectureKotlinList(request);
		
		return "studentLecture/moblie/kotlinList";
	}

}
