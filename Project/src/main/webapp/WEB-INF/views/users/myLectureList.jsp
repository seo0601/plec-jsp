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
		<br />
		<h4>수강중인 강의</h4>
		<c:forEach var="tmp" items="${list }">		   	
			<a href="">
				<img width="100px" height="100px" src="${pageContext.request.contextPath }/lecture/images/${tmp.imagePath}">
			</a>
		</c:forEach>
		<br />
		<br />
		<h4>수강완료 강의</h4>
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
</body>
</html>