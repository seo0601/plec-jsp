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
		
		<form action="${pageContext.request.contextPath}/studentLecture/list/?large_category=${Large_category }&small_category=${small_category }" method="get"> 
			      	<div>
			      		<label class="form-label" for="Large_category">대분류</label>
			      		<select class="form-control" name="Large_category" id="Large_category">
			      			<option value="1">프론트엔드</option>
			      			<option value="2">백엔드</option>
			      			<option value="3">모바일</option>
			      		</select>
			      	</div>
			      	<div>
			      		<label class="form-label" for="small_category">소분류</label>
			      		<select class="form-control" name="small_category" id="small_category">
			      			<option value="0">선택</option>
			      			<option value="1">javascript</option>
			      			<option value="2">html/css</option>
			      			<option value="3">react</option>
			      			<option value="4">vue.js</option>
			      			<option value="5">jQuery</option>
			      			<option value="6">java</option>
			      			<option value="7">spring</option>
			      			<option value="8">spring boot</option>
			      			<option value="9">kotlin</option>
			      		</select>
			      	</div>
			      	<button type="submit">검색</button>
			   	</form>
	   	<c:choose>
	   		<c:when test="${dto.large_category==1 and dto.small_category==0}"> <p>프론트엔드</p> </c:when>
			<c:when test="${dto.large_category==1 and dto.small_category==1}"> <p>자바스크립트</p> </c:when>
			<c:when test="${dto.large_category==1 and dto.small_category==3}"> <p>html/css</p> </c:when>
			<c:when test="${dto.large_category==1 and dto.small_category==4}"> <p>리액트</p> </c:when>
			<c:when test="${dto.large_category==1 and dto.small_category==5}"> <p>뷰</p> </c:when>
			<c:when test="${dto.large_category==1 and dto.small_category==6}"> <p>제이쿼리</p> </c:when>
			<c:when test="${dto.large_category==2 and dto.small_category==0}"> <p>백엔드</p> </c:when>
			<c:when test="${dto.large_category==2 and dto.small_category==7}"> <p>자바</p> </c:when>
			<c:when test="${dto.large_category==2 and dto.small_category==8}"> <p>스프링</p> </c:when>
			<c:when test="${dto.large_category==2 and dto.small_category==9}"> <p>스프링부트</p> </c:when>
			<c:when test="${dto.large_category==3 and dto.small_category==0}"> <p>모바일</p> </c:when>
			<c:when test="${dto.large_category==3 and dto.small_category==9}"> <p>코틀린</p> </c:when>
		</c:choose>
		
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
					<a class="page-link" href="${pageContext.request.contextPath}/studentLecture/list?Large_category=${Large_categroy }&small_category=${samll_category }&pageNum=${i }">${i }</a>
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