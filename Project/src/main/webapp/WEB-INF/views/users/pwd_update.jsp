<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/pwd_update.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
<div class="container">
	<div class="my-5 text-center">
	   <c:choose>
	      <c:when test="${isSuccess }">
	      	 <div class="alert alert-info" role="alert">
		           <strong>${id }</strong> 님 비밀번호를 수정하고 로그 아웃되었습니다.
		           <a href="${pageContext.request.contextPath}/users/loginform" class="d-block fw-bold mt-2">다시 로그인 하러 가기</a>
	       	 </div>
	      </c:when>
	      <c:otherwise>
	      	 <div class="alert alert-danger" role="alert">
		          이전 비밀번호가 일치하지 않습니다.
		          <a href="${pageContext.request.contextPath}/users/pwd_updateform" class="d-block fw-bold mt-2">다시 시도</a>
	         </div>
	      </c:otherwise>
	   </c:choose>
	</div>
</div>
</body>
</html>