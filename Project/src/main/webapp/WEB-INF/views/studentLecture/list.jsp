<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/studentLecture/list.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div>
			<div class="sub-tit-box">
				<div class="container">
					<h3 class="sub-tit">회원 목록</h3>
				</div>
			</div>
			<div class="container">
				<div class="mb-4">
					<a href="${pageContext.request.contextPath}/users/list">전체회원목록</a>
					<a href="${pageContext.request.contextPath}/studentLecture/list?Large_category=1&small_category=1" class="fw-bold">강의별
						회원목록</a> 
				</div>
				
				<div class="mb-3">
					<h2 class="fw-bold">
					<c:choose>
						<c:when test="${dto.large_category==1 and dto.small_category==0}">
							프론트엔드
						</c:when>
						<c:when test="${dto.large_category==1 and dto.small_category==1}">
							자바스크립트
						</c:when>
						<c:when test="${dto.large_category==1 and dto.small_category==2}">
							html/css
						</c:when>
						<c:when test="${dto.large_category==1 and dto.small_category==3}">
							리액트
						</c:when>
						<c:when test="${dto.large_category==1 and dto.small_category==4}">
							뷰
						</c:when>
						<c:when test="${dto.large_category==1 and dto.small_category==5}">
							제이쿼리
						</c:when>
						<c:when test="${dto.large_category==2 and dto.small_category==0}">
							백엔드
						</c:when>
						<c:when test="${dto.large_category==2 and dto.small_category==6}">
							자바
						</c:when>
						<c:when test="${dto.large_category==2 and dto.small_category==7}">
							스프링
						</c:when>
						<c:when test="${dto.large_category==2 and dto.small_category==8}">
							스프링부트
						</c:when>
						<c:when test="${dto.large_category==3 and dto.small_category==0}">
							모바일
						</c:when>
						<c:when test="${dto.large_category==3 and dto.small_category==9}">
							코틀린
						</c:when>
					
					</c:choose>
				</h2>
				</div>
				
				
				<form
					action="${pageContext.request.contextPath}/studentLecture/list/?large_category=${Large_category }&small_category=${small_category }"
					method="get" class="mb-3">
					<div class="d-grid gap-2 d-md-flex ">
						<div>
							<label class="form-label sr-only" for="Large_category">대분류</label> 
							<select
								class="form-select" name="Large_category" id="Large_category">
								<option value="0">대분류</option>
								<option value="1">프론트엔드</option>
								<option value="2">백엔드</option>
								<option value="3">모바일</option>
							</select>
						</div>
						<div>
							<label class="form-label sr-only" for="small_category">소분류</label> 
							<select
								class="form-select" name="small_category" id="small_category">
								<option value="0">소분류</option>
								<option value="1">javascript</option>
								<option value="2">html/css</option>
								<option value="3">react</option>
								<option value="4">vue.js</option>
								<option value="5">jQuery</option>
								<option value="6">java</option>
								<option value="7">spring</option>
								<option value="8">spring boot</option>
								<option value="9">kotlin</option>
							</select>
						</div>
						<button type="submit" class="btn new-btn">검색</button>
					</div>
					
				</form>
				

				<div class="table-responsive table-top">
					<table class="table table-hover align-middle">
						<thead>
							<tr style="text-align: center;">
								<th width="10%">아이디</th>
								<th width="20%">생일</th>
								<th width="20%">이메일</th>
								<th width="20%">핸드폰 번호</th>
								<th width="20%">가입일</th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<c:forEach var="tmp" items="${list }">
								<tr style="text-align: center;">
									<td>${tmp.id }</td>
									<td>${tmp.birth }</td>
									<td>${tmp.email }</td>
									<td>${tmp.phone }</td>
									<td>${tmp.regdate }</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<nav aria-label="Page navigation" class="page-btn">
				<ul class="pagination justify-content-center">

					<c:if test="${startPageNum ne 1 }">
						<li class="page-item"><a class="page-link new-page-link"
							href="${pageContext.request.contextPath}/studentLecture/mobile/mobileList?pageNum=${startPageNum-1 }">Prev</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
						<li class="page-item ${pageNum eq i ? 'active' : '' }"><a
							class="page-link new-page-link"
							href="${pageContext.request.contextPath}/studentLecture/list?Large_category=${Large_categroy }&small_category=${samll_category }&pageNum=${i }">${i }</a>
						</li>
					</c:forEach>

					<c:if test="${endPageNum lt totalPageCount }">
						<li class="page-item"><a class="page-link new-page-link"
							href="${pageContext.request.contextPath}/studentLecture/mobile/mobileList?pageNum=${endPageNum+1 }">Next</a>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>