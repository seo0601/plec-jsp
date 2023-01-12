<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:choose>
      <c:when test="${isSuccess }">
         <p>
            <strong>${id }</strong> 님 개인정보 수정하고 로그 아웃되었습니다.
            <a href="${pageContext.request.contextPath}/users/loginform">다시 로그인 하러 가기</a>
         </p>
      </c:when>
      <c:otherwise>
         <p>
            개인 정보 수정에 실패했습니다.
            <a href="${pageContext.request.contextPath}/users/updateform">다시 시도</a>
         </p>
      </c:otherwise>
   </c:choose>
	</div>
</body>
</html>