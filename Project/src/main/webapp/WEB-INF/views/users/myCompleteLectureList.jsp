<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>나의 강의실</h1>
		<a href="${pageContext.request.contextPath}/users/myLectureList">수강 중인 강의</a>
		<a href="${pageContext.request.contextPath}/users/myCompleteLectureList">수강 완료 강의</a>
		<br />
		<h4>수강 완료 강의</h4>
		<c:forEach var="tmp" items="${list }">	
			<c:choose>    
				<c:when test="${tmp.complete eq 'yes' }">	   	
					<a href="">
						<img width="100px" height="100px" src="${pageContext.request.contextPath }/lecture/images/${tmp.imagePath}">
					</a>
				</c:when>
			</c:choose>    
		</c:forEach>
	</div>
	
	<nav aria-label="Page navigation" class="page-btn">
		<ul class="pagination justify-content-center">
			<%--
				startPageNum 이 1 이 아닌 경우에만 Prev 링크를 제공한다. 
				&condition=${condition}&keyword=${encodedK}
			 --%>
			<c:if test="${startPageNum ne 1 }">
				<li class="page-item">
					<a class="page-link new-page-link" href="myCompleteLectureList?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedK}">
						<span aria-hidden="true"></span>
					</a>
				</li>
			</c:if>
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<li class="page-item ${pageNum eq i ? 'active' : '' }">
					<a class="page-link new-page-link" href="myCompleteLectureList?pageNum=${i }&condition=${condition}&keyword=${encodedK}">${i }</a>
				</li>
			</c:forEach>
			<%--
				마지막 페이지 번호가 전체 페이지의 갯수보다 작으면 Next 링크를 제공한다. 
			 --%>
			<c:if test="${endPageNum lt totalPageCount }">
				<li class="page-item">
					<a class="page-link new-page-link" href="myCompleteLectureList?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedK}">
						<span aria-hidden="true"></span>
					</a>
				</li>
			</c:if>				
		</ul>
	</nav>
</body>
</html>