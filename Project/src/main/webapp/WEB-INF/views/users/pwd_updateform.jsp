<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/pwd_updateform.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div>
		<div class="sub-tit-box">
			<div class="container">
				<h3 class="sub-tit">비밀번호 수정</h3>
			</div>
		</div>
		<div class="container py-5">
			<div style="width:100%; max-width:500px; margin:0 auto;">
				<div>
					<div style="width:100%">
						 <form action="${pageContext.request.contextPath}/users/pwd_update" method="post" id="myForm">
						      <div class="mb-3">
						         <label for="pwd"class="form-label">기존 비밀 번호</label>
						         <input type="password" name="pwd" id="pwd" class="form-control"/>
						      </div>
						      <div class="mb-3">
						         <label for="newPwd"class="form-label">새 비밀번호</label>
						         <input type="password" name="newPwd" id="newPwd" class="form-control"/>
						      </div>
						      <div class="mb-3">
						         <label for="newPwd2"class="form-label">새 비밀번호 확인</label>
						         <input type="password" id="newPwd2" class="form-control"/>
						      </div>
						      <button type="submit" class="btn btn-dark" style="width:100%">수정하기</button>
						      <button type="reset" class="btn btn-outline-secondary mt-2" style="width:100%">리셋</button>
						</form>
					</div>
				</div>
			</div>
		</div><!-- //container -->
	</div>
<script>
   document.querySelector("#myForm").addEventListener("submit", function(e){
      let pwd1=document.querySelector("#newPwd").value;
      let pwd2=document.querySelector("#newPwd2").value;
      //일치 확인
      if(pwd1 != pwd2){
         alert("비밀번호를 확인 하세요!");
         e.preventDefault();
      }
   });
</script>
</body>
</html>

