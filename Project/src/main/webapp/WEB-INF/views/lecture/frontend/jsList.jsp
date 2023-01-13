<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<a href="${pageContext.request.contextPath }/lecture/upload_form">새 글 작성</a>

		<h3>javascript</h3>
		<div>
		<c:forEach var="tmp" items="${list }">
			<div>
		   		<div>
				   	  <a href="${pageContext.request.contextPath}/lecture/detail?num=${tmp.lectureNum}">
						<div>
							<img style="width:100px; height:100px;" src="${pageContext.request.contextPath }/lecture/images/${tmp.imagePath}">
						</div>
					  </a>
					  <div>					   
				    	<p>${tmp.describe}</p>
				  	  </div>
			  	</div>
			</div>
		</c:forEach>
 	    </div>
		<nav>
			<ul class="pagination">
				
				<c:if test="${startPageNum ne 1 }">
					<li class="page-item">
						<a class="page-link" href="list?pageNum=${startPageNum-1 }">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<li class="page-item ${pageNum eq i ? 'active' : '' }">
						<a class="page-link" href="list?pageNum=${i }">${i }</a>
					</li>
				</c:forEach>
				
				<c:if test="${endPageNum lt totalPageCount }">
					<li class="page-item">
						<a class="page-link" href="list?pageNum=${endPageNum+1 }">Next</a>
					</li>
				</c:if>				
			</ul>
		</nav>
	</div>	
</body>
</html>