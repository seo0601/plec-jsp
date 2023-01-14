<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/list.jsp</title>
</head>
<body>
	<div class="container">
		<h3>회원 목록</h3>
		<table>
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>핸드폰 번호</th>
					<th>생일</th>
					<th>가입일</th>
					<th>회원 삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }">
					<tr>
						<td>${tmp.id }</td>		
						<td>${tmp.birth }</td>				
						<td>${tmp.phone }</td>
						<td>${tmp.regdate }</td>
						<td>
							<a href="users_delete?id=${tmp.id }">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav>
			<ul class="pagination">
				<%--
					startPageNum 이 1 이 아닌 경우에만 Prev 링크를 제공한다. 
					&condition=${condition}&keyword=${encodedK}
				 --%>
				<c:if test="${startPageNum ne 1 }">
					<li class="page-item">
						<a class="page-link" href="list?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedK}">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<li class="page-item ${pageNum eq i ? 'active' : '' }">
						<a class="page-link" href="list?pageNum=${i }&condition=${condition}&keyword=${encodedK}">${i }</a>
					</li>
				</c:forEach>
				<%--
					마지막 페이지 번호가 전체 페이지의 갯수보다 작으면 Next 링크를 제공한다. 
				 --%>
				<c:if test="${endPageNum lt totalPageCount }">
					<li class="page-item">
						<a class="page-link" href="list?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedK}">Next</a>
					</li>
				</c:if>				
			</ul>
		</nav>
		<!-- 검색 폼 -->
		<form action="list" method="get">
			<label for="condition">검색조건</label>	
			<select name="condition" id="condition">
				<option value="id" ${condition eq 'id' ? 'selected' : '' }>아이디</option>
				<option value="birth" ${condition eq 'birth' ? 'selected' : '' }>생일</option>
				<option value="phone" ${condition eq 'phone' ? 'selected' : '' }>핸드폰</option>
				<option value="email" ${condition eq 'email' ? 'selected' : '' }>이메일</option>
				<option value="regdate" ${condition eq 'regdate' ? 'selected' : '' }>가입일</option>
			</select>
			<input type="text" name="keyword" placeholder="검색어..." value="${keyword }"/>
			<button type="submit">검색</button>
		</form>
		<c:if test="${not empty condition }">
			<p>
				<strong>${totalRow }</strong> 개의 자료가 검색 되었습니다.
				<a href="list">리셋</a>
			</p>
		</c:if>
	</div>	
</body>
</html>