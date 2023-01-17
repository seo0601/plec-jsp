<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/login.jsp</title>
</head>
<body>
      <c:choose>
         <c:when test="${not empty sessionScope.id }">
            <script>
               alert("${sessionScope.id}님 로그인되었습니다.");
               location.href="${requestScope.url}";
            </script>
         </c:when>
         <c:otherwise>
            <p>
               <script>
                  alert("아이디 혹은 비밀 번호가 틀립니다.");
                  location.href="loginform?url=${requestScope.encodedUrl }";
               </script>
            </p>
         </c:otherwise>
      </c:choose>
</body>
</html>