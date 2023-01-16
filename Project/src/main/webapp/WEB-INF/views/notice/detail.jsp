<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/notice/detail.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		
		<%-- 만일 이전글(더 옛날글)의 글번호가 0 가 아니라면(이전글이 존재 한다면) --%>
        <div class="gap-2 d-md-flex justify-content-md-end">
            <c:if test="${dto.prevNum ne 0}">
                <a href="detail?num=${dto.prevNum }&condition=${condition}&keyword=${encodedK}" class="btn me-md-2 btn-secondary">이전글</a>
            </c:if>
            
            <%-- 만일 다음글(더 최신글)의 글번호가 0 가 아니라면(다음글이 존재 한다면) --%>
            <c:if test="${dto.nextNum ne 0 }">
                <a href="detail?num=${dto.nextNum }&condition=${condition}&keyword=${encodedK}"  class="btn btn-secondary">다음글</a>
            </c:if>
        </div>
            
		<%-- 만일 검색 키워드가 있다면 --%>
		<c:if test="${not empty keyword }">
			<p class="mt-2">
				<strong>${condition }</strong> 조건 
				<strong>${keyword }</strong> 검색어로 검색된 내용입니다.
			</p>
		</c:if>
		<h3 class="sr-only">글 상세 보기</h3>
		<table>
			<!-- <tr>
				<th>글번호</th>
				<td>${dto.num }</td>
			</tr> -->
			<tr>
				<th class="sr-only">제목</th>
				<td><h2 class="fw-bold ">${dto.title }</h2></td>
			</tr>
			<!-- <tr>
				<th class="sr-only">조회수</th>
				<td>${dto.viewCount }</td>	
			</tr> -->
            <tr>
				<th class="sr-only">작성자</th>
				<td class="fw-bold fs-6">by ${dto.viewCount }</td>	 <!--작성자 추가해야함.-->
			</tr>
			<tr>
				<th class="sr-only">작성일</th>
				<td>${dto.regdate }</td>
			</tr>
			<tr>
				<td colspan="2" >
					<div class="py-4">${dto.content }</div>
				</td>
			</tr>	
		</table>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-3">
            <c:if test="${sessionScope.id eq 'admin'}">	
                <div class="d-grid gap-2 d-md-flex ">
                    <a href="updateform?num=${dto.num }" class="btn new-btn">수정</a>
                    <a href="javascript:" onclick="deleteConfirm()" class="btn btn-danger">삭제</a>
                    <script>
                        function deleteConfirm(){
                            const isDelete=confirm("이 글을 삭제 하겠습니까?");
                            if(isDelete){
                                location.href="delete?num=${dto.num}";
                            }
                        }
                    </script>
                </div>
            </c:if>	
            <a href="list.jsp" class="btn btn-secondary">목록</a>
        </div>
	</div>

</body>
</html>






