<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/home.jsp</title>
</head>

<body>
	<div class="container">
		<c:choose>
			<c:when test="${ empty sessionScope.id}">
				<a href="${pageContext.request.contextPath}/users/loginform">로그인</a>
				<a href="${pageContext.request.contextPath}/users/signup_form">회원가입</a>
			</c:when>
			<c:otherwise>
				<p>
					<a href="${pageContext.request.contextPath}/users/info">${sessionScope.id }</a> 로그인중... 
					<a href="${pageContext.request.contextPath}/users/logout">로그아웃</a>
				</p>
			</c:otherwise>
		</c:choose>	
		
		<ul>
			<c:if test="${sessionScope.id eq 'admin'}">
				<li><a href="${pageContext.request.contextPath }/users/list">회원 목록</a></li>
			</c:if>
			<li><a href="lecture/frontendList">프론트</a></li>
			<li><a href="lecture/backendList">백엔드</a></li>
			<li><a href="lecture/mobileList">모바일</a></li>
			<li><a href="notice/list">공지사항</a></li>
			<li><a href="faq/list">자주묻는질문</a></li>
			<li><a href="qna_board/list">1:1답변</a></li>
			<li><a href="qna_users/list">질문답변</a></li>
			<li><a href="free/list">자유게시판</a></li>
		</ul>
	</div>
	
	
</body>
</html>