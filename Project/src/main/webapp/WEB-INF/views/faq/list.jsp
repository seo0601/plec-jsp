<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/faq/list.jsp</title>
</head>
<body>
	<div class="container">
		<h3>자주 묻는 질문</h3>
		<table>
			<c:forEach var="tmp" items="${list }">	
					<thead>
						<tr>
							<th>${tmp.question }</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>${tmp.content }</th>
							<th>
								<c:if test="${sessionScope.id eq 'admin'}">
                                    <a href="${pageContext.request.contextPath}/faq/updateform?num=${tmp.num }">수정</a>
                                    <a href="javascript:" onclick="deleteConfirm(${tmp.num})">삭제</a>
                              	</c:if>

		                  	</th>
                  		</tr>
                  	</tbody>
			</c:forEach>
		</table>
		<c:if test="${sessionScope.id eq 'admin'}">
			<a href="${pageContext.request.contextPath}/faq/insertform">새글 작성</a>
		</c:if>
		<nav>
			<ul>
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
	</div>
	<script>

		function deleteConfirm(num){
			const isDelete=confirm("이 글을 삭제 하겠습니까?");
			if(isDelete){
				location.href="delete?num="+num;
			}
		}
	</script>

</body>
</html>