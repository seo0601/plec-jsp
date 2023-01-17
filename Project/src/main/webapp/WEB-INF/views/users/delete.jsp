<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/delete.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div class="container">
		<div class="my-5 text-center">
			<div class="alert alert-info" role="alert">
				<strong>${requestScope.id }</strong> 님 탈퇴 처리 되었습니다. 행복하세요~
				<a href="${pageContext.request.contextPath}/" class="d-block fw-bold mt-2">인덱스로 가기</a>
			</div>
		</div>
	</div>
</body>
</html>