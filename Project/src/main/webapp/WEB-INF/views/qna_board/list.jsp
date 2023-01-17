<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/qna_board/list.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/board.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="sub-tit-box">
			<div class="container">
				<h3 class="sub-tit">1:1문의</h3>
			</div>
		</div>
		<div class="container">
	      <div class="table-responsive table-top">
		      <table class="table table-hover align-middle">
		         <thead style="text-align: center;">
		            <tr>
		               <th width="15%">질문번호</th>               
		               <th width="auto">제목</th>   
		               <th width="15%">작성자</th>
		               <th width="15%">등록일</th>
		               <th width="15%">답변여부</th>
		            </tr>
		         </thead>
		         <tbody class="table-group-divider">
		           <c:forEach var="tmp" items="${list }" >
			            <tr style="text-align: center;">
			               <td>${tmp.num }</td>               
			               <td>
			               		<c:choose>
			               			<c:when test="${tmp.writer eq sessionScope.id || sessionScope.id eq 'admin' }">
			               				<a href="detail?num=${tmp.num }&condition=${condition}&keyword=${encodedK }">${tmp.title }</a>
			               			</c:when>
			               			<c:otherwise>	               		
			               		 		<a href="javascript:userAlert()">${tmp.title }</a>
			               			</c:otherwise>
			               		</c:choose>
			               </td> 
			               <td>    
			               		${tmp.writer }	               		
			               </td>               
			               <td>${tmp.regdate }</td>
		               		<c:choose>               		             		
				                  <c:when test="${tmp.answered eq 'yes' }">
				                     <td>답변완료</td>
				                  </c:when>
				                  <c:otherwise>  
				                     <td style="color:red">답변대기</td>    
				                  </c:otherwise>
		                     </c:choose>     
			            </tr>
		            </c:forEach>          
		         </tbody>
		      </table>
		     
		   </div>
		   <c:if test="${sessionScope.id ne 'admin' }">
	        	<div class="d-flex justify-content-end">
	        		<button class="btn btn-secondary btn-sm me-2 " type="button" onclick="location.href='${pageContext.request.contextPath }/qna_board/insertform'">새글작성</button>
	        	</div>
		   </c:if>
	      <nav aria-label="Page navigation" class="page-btn">
	         <ul class="pagination justify-content-center">
	            <%--
	               startPageNum 이 1 이 아닌 경우에만 Prev 링크를 제공한다. 
	               &condition=${condition}&keyword=${encodedK}
	             --%>
	            <c:if test="${startPageNum ne 1 }">
	               <li class="page-item">
	                  <a class="page-link new-page-link" href="list?pageNum=${startPageNum-1 }&condition=${condition}&keyword=${encodedK}">Prev</a>
	               </li>
	            </c:if>            
		            <c:forEach var="i" begin="${startPageNum }" end="${endPageNum }" varStatus="status">            
		               <li class="page-item ${pageNum eq i ? 'active' : '' }">
		                  <a class="page-link new-page-link" href="list?pageNum=${i }&condition=${condition}&keyword=${encodedK}">${i }</a>
		               </li>
		            </c:forEach>		        
	            
	            <%--
	               마지막 페이지 번호가 전체 페이지의 갯수보다 작으면 Next 링크를 제공한다. 
	             --%>
	            <c:if test="${endPageNum lt totalPageCount }">
	               <li class="page-item">
	                  <a class="page-link new-page-link" href="list?pageNum=${endPageNum+1 }&condition=${condition}&keyword=${encodedK}">Next</a>
	               </li>
	            </c:if>
	         </ul>
	      </nav>
	      
		      <!-- 검색 폼 -->
		      <form action="list" method="get">
		      	<div class="d-grid gap-2 d-md-flex justify-content-md-end table-search-box">
			         <label for="condition" class="sr-only">검색조건</label>   
			         <select name="condition" id="condition" class="form-select" >
			            <option value="title_content" ${condition eq 'title_content' ? 'selected' : '' }>제목 + 내용</option>
			            <option value="title" ${condition eq 'title' ? 'selected' : '' }>제목</option>
			            <option value="writer" ${condition eq 'writer' ? 'selected' : '' }>작성자</option>
			         </select>
			         <input type="text" name="keyword" placeholder="검색어..." value="${keyword }" class="form-control"/>
			         <button type="submit" class="table-search-btn new-btn-black btn btn-sm">검색</button>
		         </div>
		      </form>
		  
	      <c:if test="${not empty condition }">
	         <p style=" text-align: center;">
	            <strong>${totalRow }</strong> 개의 자료가 검색 되었습니다.
	            <a href="list" class="reset">리셋</a>
	         </p>
	      </c:if>
	      
	   </div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		   
   <script>
      function deleteConfirm(num){
         let isDelete=confirm("삭제 하시겠습니까?");
         if(isDelete){
            location.href="delete?num="+num;
         }
      }
   </script>
   <script>
      function userAlert(){
         alert("본인의 글만 열람할 수 있습니다.");         
      }
   </script>		

</body>
</html>