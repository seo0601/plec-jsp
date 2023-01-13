<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/faq/list.jsp</title>
</head>
<body>
	<div class="container">
		<a href="${pageContext.request.contextPath}/faq/insertform">새글 작성</a>
		<h3>자주 묻는 질문</h3>
		<ul>
			<c:forEach var="tmp" items="${list }">	
					<li>${tmp.question }</li>
					<li>${tmp.content }</li>
					<li>
                     	<a href="updateform?num=${tmp.num }">수정하기</a>
                  	</li>
			</c:forEach>
		</ul>		
	</div>
</body>
</html>