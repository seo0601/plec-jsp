<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/lecture/backend/backendList.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/lecture.css" rel="stylesheet">

</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="sub-tit-box">
			<div class="container">
				<h3 class="sub-tit">BackEnd</h3>
			</div>
		</div>
		<div class="container">
			<div class="d-flex justify-content-end">
	        		<button class="btn btn-sm me-2 mb-3 button" type="button" onclick="location.href='${pageContext.request.contextPath }/lecture/upload_form'">새글작성</button>
	        </div>
			<div class="row">
			<c:forEach var="tmp" items="${list }">
				<div class="col-6 col-md-4 col-lg-3">
			   		<div class="card mb-3">
					   	  <a href="${pageContext.request.contextPath}/lecture/detail?num=${tmp.num}">
							<div class="img-wrapper">
								<img src="${pageContext.request.contextPath }/lecture/images/${tmp.imagePath}">
							</div>
						  </a>
						  <div class="card-body">					   
					    	<p>${tmp.describe}</p>
					  	  </div>
				  	</div>
				</div>
			</c:forEach>
	 	    </div>
			<nav aria-label="Page navigation" class="page-btn">
				<ul class="pagination justify-content-center">
					
					<c:if test="${startPageNum ne 1 }">
						<li class="page-item">
							<a class="page-link new-page-link" href="${pageContext.request.contextPath}/lecture/frontend/frontendList?pageNum=${startPageNum-1 }">Prev</a>
						</li>
					</c:if>
					<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
						<li class="page-item ${pageNum eq i ? 'active' : '' }">
							<a class="page-link new-page-link" href="${pageContext.request.contextPath}/lecture/frontend/frontendList?pageNum=${i }">${i }</a>
						</li>
					</c:forEach>
					
					<c:if test="${endPageNum lt totalPageCount }">
						<li class="page-item">
							<a class="page-link new-page-link" href="${pageContext.request.contextPath}/lecture/frontend/frontendList?pageNum=${endPageNum+1 }">Next</a>
						</li>
					</c:if>				
				</ul>
			</nav>
		</div>	
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	
</body>
</html>