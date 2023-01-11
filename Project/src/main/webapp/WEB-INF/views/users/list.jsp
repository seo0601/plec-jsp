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
	</div>	
</body>
</html>