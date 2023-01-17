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
	 	<table>
	         <thead>
	            <tr>
	               <th>아이디</th>               
	               <th>생년월일</th>   
	               <th>전화번호</th>
	               <th>이메일</th>
	               <th>가입일</th>
	            </tr>
	         </thead>
	         <tbody>
	         <c:forEach var="tmp" items="${list }">
	            <tr>
	               <td>${tmp.id }</td>               
	               <td>${tmp.birth }</td> 
	               <td>${tmp.phone }</td>               
	               <td>${tmp.email }</td>
	               <td>${tmp.regdate }</td> 
	            </tr>
	         </c:forEach>
	         </tbody>
       </table>
      </div>
      <nav>
			<ul class="pagination">
				
				<c:if test="${startPageNum ne 1 }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/studentLecture/mobile/mobileList?pageNum=${startPageNum-1 }">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
					<li class="page-item ${pageNum eq i ? 'active' : '' }">
						<a class="page-link" href="${pageContext.request.contextPath}/studentLecture/mobile/mobileList?pageNum=${i }">${i }</a>
					</li>
				</c:forEach>
				
				<c:if test="${endPageNum lt totalPageCount }">
					<li class="page-item">
						<a class="page-link" href="${pageContext.request.contextPath}/studentLecture/mobile/mobileList?pageNum=${endPageNum+1 }">Next</a>
					</li>
				</c:if>				
			</ul>
		</nav>
</body>
</html>