<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/info.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<style>
/* 프로필 이미지를 작은 원형으로 만든다 */
#profileImage {
	width: 50px;
	height: 50px;
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
				<h3 class="sub-tit">마이페이지</h3>
			</div>
		</div>
		<div class="container py-5">
			<div style="width:100%; max-width:500px; margin:0 auto;">
				<div class="d-grid gap-3">
					<a href="#" class="btn new-btn">나의 강의실</a>
					<div class="mypage-table-box py-3 border-top border-bottom">
						<table style="width:100%">
							<tr class="d-block mb-3">
								<th>아이디</th>
								<td>${id }</td>
							</tr>
							<tr class="d-block mb-3">
								<th>프로필 이미지</th>
								<td><c:choose>
										<c:when test="${empty dto.profile }">
											<svg id="profileImage" xmlns="http://www.w3.org/2000/svg"
												width="16" height="16" fill="currentColor"
												class="bi bi-person-circle" viewBox="0 0 16 16">
			                 <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
			                 <path fill-rule="evenodd"
													d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
			               </svg>
										</c:when>
										<c:otherwise>
											<img id="profileImage"
												src="${pageContext.request.contextPath}/users/images/${dto.profile}" />
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr class="d-block mb-3">
								<th>이메일</th>
								<td>${dto.email }</td>
							</tr>
							<tr class="d-block mb-3">
								<th>핸드폰 번호</th>
								<td>${dto.phone}</td>
							</tr>
							<tr class="d-block mb-3">
								<th>생일</th>
								<td>${dto.birth }</td>
							</tr>
							<tr class="d-block mb-3">
								<th>가입일</th>
								<td>${dto.regdate }</td>
							</tr>
							<tr>
								<th></th>
								<td><a
									href="${pageContext.request.contextPath}/users/updateform" class="btn btn-dark" style="width:100%">개인정보
										수정</a></td>
							</tr>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/users/pwd_updateform" class="btn new-btn">비밀번호 수정하기</a>
					<a href="javascript:deleteConfirm()" class="btn btn-outline-secondary">탈퇴</a>
				</div>
			</div>
		</div><!-- //container -->
	</div>
	<script>
		function deleteConfirm() {
			const isDelete = confirm("${id} 님 탈퇴 하시겠습니까?");
			if (isDelete) {
				location.href = "${pageContext.request.contextPath}/users/delete";
			}
		}
	</script>
</body>
</html>