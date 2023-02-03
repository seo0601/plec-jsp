<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/faq/list.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<style>
	.acco-btn-new:not(.collapsed){
		color:#fff;
		font-weight:500;
		background-color:rgba(30,189,142,0.8);
	}
	.acco-btn-new:focus{
		box-shadow:0px 0px 3px 2px rgba(75,161,103,0.64);
	}
	.acco-head-box strong {
		display: inline-block;
	    width: 100%;
	    white-space: nowrap;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="sub-tit-box">
			<div class="container">
				<h3 class="sub-tit">자주묻는 질문</h3>
			</div>
		</div>
		<div class="container">
				<c:forEach var="tmp" items="${list }" >	
					<div class="accordion mb-2" id="accordionPanelsStayOpenExample">
					  <div class="accordion-item">
					    <h2 class="accordion-header" id="panelsStayOpen-headingOne">
					      <button class="accordion-button acco-btn-new collapsed "  type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapse${tmp.num }" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
					      	<div class="d-flex align-items-center acco-head-box">
						        <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-question-circle me-2" viewBox="0 0 16 16">
								  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
								  <path d="M5.255 5.786a.237.237 0 0 0 .241.247h.825c.138 0 .248-.113.266-.25.09-.656.54-1.134 1.342-1.134.686 0 1.314.343 1.314 1.168 0 .635-.374.927-.965 1.371-.673.489-1.206 1.06-1.168 1.987l.003.217a.25.25 0 0 0 .25.246h.811a.25.25 0 0 0 .25-.25v-.105c0-.718.273-.927 1.01-1.486.609-.463 1.244-.977 1.244-2.056 0-1.511-1.276-2.241-2.673-2.241-1.267 0-2.655.59-2.75 2.286zm1.557 5.763c0 .533.425.927 1.01.927.609 0 1.028-.394 1.028-.927 0-.552-.42-.94-1.029-.94-.584 0-1.009.388-1.009.94z"/>
								</svg>
					        	<strong>${tmp.question }</strong>
					        </div>
					      </button>
					    </h2>
					    <div id="panelsStayOpen-collapse${tmp.num }" class="accordion-collapse collapse" aria-labelledby="panelsStayOpen-heading">
					      <div class="accordion-body">
					        <c:if test="${sessionScope.id eq 'admin'}">
					        	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
	                           		<a href="${pageContext.request.contextPath}/faq/updateform?num=${tmp.num }" class="btn new-btn">수정</a>
	                                <a href="javascript:" onclick="deleteConfirm(${tmp.num})" class="btn btn-danger">삭제</a>
                                </div>
                             </c:if>
						  	 <div>${tmp.content }</div>
					      </div>
					    </div>
					  </div>
  					</div>
				</c:forEach>
			<c:if test="${sessionScope.id eq 'admin'}">
				<a href="${pageContext.request.contextPath}/faq/insertform">새글 작성</a>
			</c:if>
			
			<!-- 페이징 버튼 -->
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
	</div>
	<script>
		function deleteConfirm(num){
			const isDelete=confirm("이 글을 삭제 하겠습니까?");
			if(isDelete){
				location.href="delete?num="+num;
			}
		}
	</script>
   	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>