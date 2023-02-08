<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-md-2">
	<h5><a href="${pageContext.request.contextPath}/lecture/list?large_category=front" class="${selectLecture == 'frontend' ? 'selectedLecture' : '' }">웹프론트엔드</a></h5>
	<a href="${pageContext.request.contextPath}/lecture/list?large_category=front&small_category=js" class="${selectLecture == 'js' ? 'selectedLecture' : '' }">javascript</a>
	<br><a href="${pageContext.request.contextPath}/lecture/list?large_category=front&small_category=html_css" class="${selectLecture == 'html' ? 'selectedLecture' : '' }">html/css</a>
	<br><a href="${pageContext.request.contextPath}/lecture/list?large_category=front&small_category=react" class="${selectLecture == 'react' ? 'selectedLecture' : '' }">react</a>
	<br><a href="${pageContext.request.contextPath}/lecture/list?large_category=front&small_category=vue" class="${selectLecture == 'vue' ? 'selectedLecture' : '' }">vue</a>
	<br><a href="${pageContext.request.contextPath}/lecture/list?large_category=front&small_category=jquery" class="${selectLecture == 'jQuery' ? 'selectedLecture' : '' }">jQuery</a>
	<br><br><h5><a href="${pageContext.request.contextPath}/lecture/list?large_category=backend" class="${selectLecture == 'backend' ? 'selectedLecture' : '' }">웹백엔드</a></h5>
	<a href="${pageContext.request.contextPath}/lecture/list?large_category=backend&small_category=java" class="${selectLecture == 'java' ? 'selectedLecture' : '' }">java</a>
	<br><a href="${pageContext.request.contextPath}/lecture/list?large_category=backend&small_category=spring" class="${selectLecture == 'spring' ? 'selectedLecture' : '' }">spring</a>
	<br><a href="${pageContext.request.contextPath}/lecture/list?large_category=backend&small_category=springboot" class="${selectLecture == 'springboot' ? 'selectedLecture' : '' }">springboot</a>
	<br><br><h5><a href="${pageContext.request.contextPath}/lecture/list?large_category=mobile" class="${selectLecture == 'mobile' ? 'selectedLecture' : '' }">모바일</a></h5>
	<a href="${pageContext.request.contextPath}/lecture/list?large_category=mobile&small_category=kotlin" class="${selectLecture == 'kotlin' ? 'selectedLecture' : '' }">kotlin</a>
</div>