<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/users/loginform.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/login-form.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Noto+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<style>
	
</style>
</head>
<body class="text-center">
	<div class="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main class="form-signin w-100 m-auto">
		  <form action="${pageContext.request.contextPath}/users/login" method="post">
		  	<c:choose>
	            <c:when test="${ empty param.url }">
	               <input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
	            </c:when>
	            <c:otherwise>
	               <input type="hidden" name="url" value="${param.url }"/>
	            </c:otherwise>
	        </c:choose>
		    <h1 class="mb-3 fw-normal main">login</h1>
		    <div class="form-floating">
		      <input type="text" class="form-control" id="floatingInput" name="id" placeholder="id" value="${savedId}">
		      <label for="floatingInput">id</label>
		    </div>
		    <div class="form-floating">
		      <input type="password" class="form-control" id="floatingPassword" name="pwd" placeholder="Password" value="${savedPwd}">
		      <label for="floatingPassword">Password</label>
		    </div>
		
		    <div class="checkbox mb-3">
		      <label>
		            <input type="checkbox" value="remember-me" name=isSave value="yes" ${not empty cookie.savedId ? 'checked':'' } }> Remember me
		      </label>
		    </div>
		    <button class="w-100 btn btn-lg btn" type="submit">로그인</button>
		  </form>
		</main>
	</div>
</body>
</html>