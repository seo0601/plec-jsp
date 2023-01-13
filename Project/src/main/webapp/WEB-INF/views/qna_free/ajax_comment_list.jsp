<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="tmp" items="${commentList }">
	<li id="reli${tmp.num }" class="page-${pageNum }">
		<dl>
           <dt>
              <c:if test="${ empty tmp.profile }">
                 <svg class="profile-image" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                   <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                   <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                 </svg>
              </c:if>
              <c:if test="${not empty tmp.profile }">
                 <img class="profile-image" src="${pageContext.request.contextPath}/users/images/${tmp.profile }"/>
              </c:if>
              <span>${tmp.writer }</span>
              
              <span>${tmp.regdate }</span>
              <a data-num="${tmp.num }" href="javascript:" class="reply-link">답글</a>
              <c:if test="${ (id ne null) and (tmp.writer eq id) }">
                 <a data-num="${tmp.num }" class="update-link" href="javascript:">수정</a>
                 
              </c:if>
           </dt>
           <dd>
              <pre id="pre${tmp.num }">${tmp.content }</pre>                  
           </dd>
        </dl>
        <form id="reForm${tmp.num }" class="animate__animated comment-form re-insert-form" action="comment_insert" method="post">
           <input type="hidden" name="ref_group" value="${num }"/>
           <textarea name="content"></textarea>
           <button type="submit">등록</button>
        </form>
     <c:if test="${tmp.writer eq id }">
        <form id="updateForm${tmp.num }" class="comment-form update-form" action="comment_update" method="post">
           <input type="hidden" name="num" value="${tmp.num }" />
           <textarea name="content">${tmp.content }</textarea>
           <button type="submit">수정</button>
        </form>
     </c:if>
	</li>   
</c:forEach> 