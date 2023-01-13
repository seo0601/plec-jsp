<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/qna_board/list.jsp</title>
</head>
<body>
	<div class="container">
      <c:if test="${sessionScope.id ne 'admin' }">
      	<a href="${pageContext.request.contextPath }/qna_board/insertform">새글 작성</a>
      </c:if>
      <h3>1:1문의</h3>
      <table>
         <thead>
            <tr>
               <th>질문번호</th>               
               <th>제목</th>   
               <th>작성자</th>
               <th>등록일</th>
               <th>답변여부</th>
            </tr>
         </thead>
         <tbody>
         <c:forEach var="tmp" items="${list }">
            <tr>
               <td>${tmp.num }</td>               
               <td>
               	<a href="detail?num=${tmp.num }&condition=${condition}&keyword=${encodedK }">${tmp.title }</a>
               </td> 
               <td>${tmp.writer }</td>               
               <td>${tmp.regdate }</td>
               <td>
               		<c:choose>               		             		
		                  <c:when test="${tmp.answered eq 'yes' }">
		                     답변완료
		                  </c:when>
		                  <c:otherwise>  
		                     답변대기    
		                  </c:otherwise>
                     </c:choose>              
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
      <c:if test="${sessionScope.id eq 'admin' }">
	      <!-- 검색 폼 -->
	      <form action="list" method="get">
	         <label for="condition">검색조건</label>   
	         <select name="condition" id="condition">
	            <option value="title_content" ${condition eq 'title_content' ? 'selected' : '' }>제목 + 내용</option>
	            <option value="title" ${condition eq 'title' ? 'selected' : '' }>제목</option>
	            <option value="writer" ${condition eq 'writer' ? 'selected' : '' }>작성자</option>
	         </select>
	         <input type="text" name="keyword" placeholder="검색어..." value="${keyword }"/>
	         <button type="submit">검색</button>
	      </form>
	  </c:if>
      <c:if test="${not empty condition }">
         <p>
            <strong>${totalRow }</strong> 개의 자료가 검색 되었습니다.
            <a href="list">리셋</a>
         </p>
      </c:if>
      
   </div>
   <script>
      function deleteConfirm(num){
         let isDelete=confirm("삭제 하시겠습니까?");
         if(isDelete){
            location.href="delete?num="+num;
         }
      }
   </script>		

</body>
</html>