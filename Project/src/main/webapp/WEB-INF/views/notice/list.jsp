<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/list.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div>
		<div class="sub-tit-box">
			<div class="container">
				<h3 class="sub-tit">공지사항</h3>
			</div>
		</div>
		<div class="container">
			<div class="table-responsive table-top">
				<table class="table table-hover align-middle">
					<thead>
						<tr style="text-align: center;">
							<th width="15%">글번호</th>
							<th width="auto">제목</th>
							<th width="15%">조회수</th>
							<th width="25%">작성일</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:forEach var="tmp" items="${list }">
							<tr style="text-align: center;">
								<td>${tmp.num }</td>
								<td>
									<a href="detail?num=${tmp.num }&condition=${condition}&keyword=${encodedK}">${tmp.title }</a>
								</td>
								<td>${tmp.viewCount }</td>
								<td>${tmp.regdate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<c:if test="${sessionScope.id eq 'admin'}">
	
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<a href="${pageContext.request.contextPath }/notice/insertform" class="new-btn btn ">글쓰기</a>
				</div>
				
			</c:if>
			<nav aria-label="Page navigation" class="page-btn">
				<ul class="pagination justify-content-center">
					<c:if test="${startPageNum ne 1 }">
						<li class="page-item">
							<a class="page-link new-page-link" href="list?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedK}">
								<span aria-hidden="true"><</span>
							</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
						<li class="page-item ${pageNum eq i ? 'active' : '' }">
							<a class="page-link new-page-link" href="list?pageNum=${i }&condition=${condition}&keyword=${encodedK}">${i }</a>
						</li>
					</c:forEach>
					
					<c:if test="${endPageNum lt totalPageCount }">
						<li class="page-item">
							<a class="page-link new-page-link" href="list?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedK}">
								<span aria-hidden="true">></span>
							</a>
						</li>
					</c:if>				
				</ul>
			</nav>
					
			<form action="list" method="get">
				<div class="d-grid gap-2 d-md-flex justify-content-md-end table-search-box">
					<label for="condition" class="sr-only">검색조건</label>	
					<select name="condition" id="condition" class="form-select" aria-label="Default select">
						<option value="title_content" ${condition eq 'title_content' ? 'selected' : '' }>제목 + 내용</option>
						<option value="title" ${condition eq 'title' ? 'selected' : '' }>제목</option>
					</select>
					<input type="text" name="keyword" placeholder="검색어..." value="${keyword }" class="form-control"/>
					<button type="submit" class="table-search-btn new-btn-black btn">검색</button>
				</div>
			</form>
			<c:if test="${not empty condition }">
			<p style=" text-align: center;">
				<strong>${totalRow }</strong> 개의 자료가 검색 되었습니다.
				<a href="list" style="text-decoration: underline;">리셋</a>
			</p>
		</c:if>
		</div>
	</div>	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>