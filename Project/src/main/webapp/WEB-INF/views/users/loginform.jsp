<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/users/loginform.jsp</title>
</head>

<body>
	<main>
	  <form action="${pageContext.request.contextPath}/users/login" method="post">
	  	<c:choose>
            <c:when test="${ empty param.url }">
               <input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
            </c:when>
            <c:otherwise>
               <input type="hidden" name="url" value="${param.url }"/>
            </c:otherwise>
        </c:choose>
        
	    <h1 >로그인</h1>
		
	    <div>
	      <input type="text" id="floatingInput" name="id" placeholder="id" value="${savedId}">
	      <label for="floatingInput">id</label>
	    </div>
	    <div >
	      <input type="password"  id="floatingPassword" name="pwd" placeholder="Password" value="${savedPwd}">
	      <label for="floatingPassword">Password</label>
	    </div>
	
	    <div >
	      <label>
	        <input type="checkbox" value="remember-me" name=isSave value="yes" ${not empty cookie.savedId ? 'checked':'' } > 아이디 기억하기 </label>
	    </div>
	    <button  type="submit">로그인</button>
	  </form>
	</main>
</body>
</html>