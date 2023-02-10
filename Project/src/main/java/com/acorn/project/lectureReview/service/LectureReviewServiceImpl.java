package com.acorn.project.lectureReview.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.acorn.project.lectureReview.dao.LectureReviewDao;
import com.acorn.project.lectureReview.dto.LectureReviewDto;

public class LectureReviewServiceImpl implements LectureReviewService{
	@Autowired LectureReviewDao reviewDao;

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

}
