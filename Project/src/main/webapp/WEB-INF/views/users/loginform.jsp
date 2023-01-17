<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/users/loginform.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/users.css" rel="stylesheet">
<style>
	
</style>
</head>
<body class="text-center">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="container userform">
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
			      <input type="text" class="form-control" id="floatingId" name="id" placeholder="id" value="${savedId}">
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
			    <button class="w-100 button btn-lg btn" type="submit">로그인</button>
			  </form>
			</main>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>