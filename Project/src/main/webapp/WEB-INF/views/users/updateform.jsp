<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/updateform.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<style>

	#imageForm{
		display: none;
	}
	#profileImage{
		width: 150px;
		height: 150px;
		border: 1px solid #cecece;
		border-radius: 50%;
	}

</style>
</head>

<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div>
		<div class="sub-tit-box">
			<div class="container">
				<h3 class="sub-tit">개인정보 수정</h3>
			</div>
		</div>
		<div class="container py-5">
			<div style="width:100%; max-width:500px; margin:0 auto;">
				<div class=""><!-- d-grid gap-3 -->
					<div class="mypage-table-box py-3 border-top border-bottom">
						<div style="width:100%">
							<div class="d-flex align-items-center flex-column text-center">
								<a id="profileLink" href="javascript:">
									<c:choose>
										<c:when test="${ empty dto.profile }">
											<svg xmlns="http://www.w3.org/2000/svg" width="150" height="150" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
											  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
											  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
											</svg>
										</c:when>
										<c:otherwise>
											<img id="profileImage" src="${pageContext.request.contextPath }/users/images/${ dto.profile}">
										</c:otherwise>
									</c:choose>
								</a>
								<span class="d-block mt-2 fw-bold">${dto.id }님</span>
							</div>
							<form action="${pageContext.request.contextPath}/users/update" method="post">		
								<input type="hidden" name="profile" 
									value="${ empty dto.profile ? 'empty' : dto.profile }"/>		
								<!-- <div class="mb-3">
									<label for="id" class=" form-label">아이디</label>
									<input type="text" id="id" value="${dto.id }" class="form-control" disabled/>
								</div> -->
								<div class="mb-3">
									<label for="email" class="form-label">이메일</label>
									<input type="text" id="email" name="email" value="${dto.email }" class="form-control"/>
								</div>
					      		<div class="mb-3">
									<label for="phone"class="form-label">핸드폰 번호</label>
									<input type="text" id="phone" name="phone" value="${dto.phone }"  class="form-control"/>
								</div>
								<div class="mb-3">
									<label for="birth"class="form-label">생일</label>
									<input type="text" id="birth" name="birth" value="${dto.birth }" class="form-control"/>
								</div>
								<button type="submit" class="btn btn-dark" style="width:100%">수정확인</button>
								<button type="reset" class="btn btn-outline-secondary mt-2" style="width:100%">취소</button>
							</form>	
							
							<form id="imageForm" action="${pageContext.request.contextPath}/users/profile_upload" method="post" enctype="multipart/form-data">
								프로필 사진
								<input type="file" id="image" name="image" accept=".jpg, .png, .gif"/>
								<button type="submit">업로드</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div><!-- //container -->
	</div>

	<script src="${pageContext.request.contextPath }/resources/js/gura_util.js"></script>
	<script>
		document.querySelector("#profileLink").addEventListener("click", function(){
			document.querySelector("#image").click();
		});	
		
		document.querySelector("#image").addEventListener("change", function(){
			const form=document.querySelector("#imageForm");
			ajaxFormPromise(form)
			.then(function(response){
				return response.json();
			})
			.then(function(data){
				console.log(data);
				document.querySelector("input[name=profile]").value=data.imagePath;
				let img=`<img id="profileImage" 
					src="${pageContext.request.contextPath }/users/images/\${data.imagePath}">`;
				document.querySelector("#profileLink").innerHTML=img;
			});
		});		
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