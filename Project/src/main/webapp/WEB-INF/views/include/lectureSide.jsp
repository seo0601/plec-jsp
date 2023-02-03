<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-2">
	<h5><a href="${pageContext.request.contextPath}/lecture/frontend/frontendList" class="${selectLecture == 'frontend' ? 'selectedLecture' : '' }">웹프론트엔드</a></h5>
	<a href="" class="${selectLecture == 'js' ? 'selectedLecture' : '' }">javascript</a>
	<br><a href="" class="${selectLecture == 'html' ? 'selectedLecture' : '' }">html/css</a>
	<br><a href="" class="${selectLecture == 'react' ? 'selectedLecture' : '' }">react</a>
	<br><a href="" class="${selectLecture == 'vue' ? 'selectedLecture' : '' }">vue</a>
	<br><a href="" class="${selectLecture == 'jQuery' ? 'selectedLecture' : '' }">jQuery</a>
	<br><br><h5><a href="${pageContext.request.contextPath}/lecture/backend/backendList" class="${selectLecture == 'backend' ? 'selectedLecture' : '' }">웹백엔드</a></h5>
	<a href="" class="${selectLecture == 'java' ? 'selectedLecture' : '' }">java</a>
	<br><a href="" class="${selectLecture == 'spring' ? 'selectedLecture' : '' }">spring</a>
	<br><a href="" class="${selectLecture == 'springboot' ? 'selectedLecture' : '' }">springboot</a>
	<br><br><h5><a href="${pageContext.request.contextPath}/lecture/mobile/mobileList" class="${selectLecture == 'mobile' ? 'selectedLecture' : '' }">모바일</a></h5>
	<a href="" class="${selectLecture == 'kotlin' ? 'selectedLecture' : '' }">kotlin</a>
</div>