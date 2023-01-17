<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/qna_board/detail.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=Noto+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/qna_board/qna_board_detail.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div class="container">
	  <div class="d-flex justify-content-end mt-3">
	  	  <%-- 만일 이전글(더 옛날글)의 글번호가 0 가 아니라면(이전글이 존재 한다면) --%>
	      <c:if test="${dto.prevNum ne 0}">
	         <button class="btn btn-secondary btn-sm me-2" type="button" onclick="location.href='detail?num=${dto.prevNum }&condition=${condition}&keyword=${encodedK}'">이전글</button>
	      </c:if>
	      
	      <%-- 만일 다음글(더 최신글)의 글번호가 0 가 아니라면(다음글이 존재 한다면) --%>
	      <c:if test="${dto.nextNum ne 0 }">
	        <button class="btn btn-secondary btn-sm me-2" type="button" onclick="location.href='detail?num=${dto.nextNum }&condition=${condition}&keyword=${encodedK}'">다음글</button>
	      </c:if>
	  </div>
      
      <%-- 만일 검색 키워드가 있다면 --%>
      <c:if test="${not empty keyword }">
         <p>
            <strong>${condition }</strong> 조건 
            <strong>${keyword }</strong> 검색어로 검색된 내용 자세히 보기
         </p>
      </c:if>
      <h1 class="mb-3">${dto.title }</h1>
      <table>
         <tr>
            <th>글번호 </th>
            <td>${dto.num }</td>
         </tr>
         <tr>
            <th>작성자 </th>
            <td>${dto.writer }</td>
         </tr>
         <tr>
            <th>조회수 </th>
            <td>${dto.viewCount }</td>   
         </tr>
         <tr>
            <th>작성일 </th>
            <td>${dto.regdate }</td>
         </tr>
      </table>
      <div class="mainContent mt-3">${dto.content }</div>
             
      <c:if test="${sessionScope.id eq dto.writer }">
      	 <div class="d-flex justify-content-end mt-3">
      	 	<button class="btn btn-sm me-2 button" type="button" onclick="location.href='updateform?num=${dto.num }'">수정</button>
         	<button class="btn btn-sm me-2 btn-danger" type="button" onclick="deleteConfirm()">삭제</button>
      	 </div>
         <script>
            function deleteConfirm(){
               const isDelete=confirm("이 글을 삭제 하겠습니까?");
               if(isDelete){
                  location.href="delete?num=${dto.num}";
               }
            }
         </script>
      </c:if>
      <c:if test="${sessionScope.id eq 'admin' && empty commentList}">
      <p class="mt-4">댓글을 입력해주세요</p>
	      <!-- 원글에 댓글을 작성할 폼 -->
	      <form class="comment-form insert-form" action="comment_insert" method="post">
	         <!-- 원글의 글번호가 댓글의 ref_group 번호가 된다. -->
	         <input type="hidden" name="ref_group" value="${dto.num }"/>
	         
	         <textarea name="content" class="me-3"></textarea>
	         <button class="button btn" type="submit">등록</button>
	      </form>
      </c:if>
      
      <!-- 댓글 목록 -->
      <div class="comments mt-3">      
      
         <ul>
            <c:forEach var="tmp" items="${commentList }">
               <li id="reli${tmp.num }">
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
                          
                          <c:if test="${ (id ne null) and (tmp.writer eq id) }">
                             <a data-num="${tmp.num }" class="update-link" href="javascript:">수정</a>                             
                          </c:if>
                       </dt>
                       <dd>
                          <pre id="pre${tmp.num }">${tmp.content }</pre>                  
                       </dd>
                    </dl>
               		<c:if test="${tmp.writer eq id }">
                      <form id="updateForm${tmp.num }" class="comment-form update-form" action="comment_update" method="post">
                         <input type="hidden" name="num" value="${tmp.num }" />
                         <textarea name="content">${tmp.content }</textarea>
                         <button type="submit">수정</button>
                      </form>
                	</c:if>
               </li>  
            </c:forEach>
         </ul>
      </div>      
      <div class="loader">
         <svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" fill="currentColor" class="bi bi-arrow-clockwise" viewBox="0 0 16 16">
              <path fill-rule="evenodd" d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z"/>
              <path d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z"/>
         </svg>
      </div>      
	</div>
   
	<script src="${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
	<script>
      /*
         detail
          페이지 로딩 시점에 만들어진 1 페이지에 해당하는 
         댓글에 이벤트 리스너 등록 하기 
      */
      addUpdateFormListener(".update-form");
      addUpdateListener(".update-link");
      /* addDeleteListener(".delete-link"); */
      addReplyListener(".reply-link");
      
      
      //댓글의 현재 페이지 번호를 관리할 변수를 만들고 초기값 1 대입하기
      let currentPage=1;
      //마지막 페이지는 totalPageCount 이다.
      <%-- 댓글의 개수가 0일때 오류를 방지하기 위해 --%>
      let lastPage=${ totalPageCount eq 0 ? 1 : totalPageCount};
      
      //추가로 댓글을 요청하고 그 작업이 끝났는지 여부를 관리할 변수 
      let isLoading=false; //현재 로딩중인지 여부 
      
      /*
         window.scrollY => 위쪽으로 스크롤된 길이
         window.innerHeight => 웹브라우저의 창의 높이
         document.body.offsetHeight => body 의 높이 (문서객체가 차지하는 높이)
      */
      window.addEventListener("scroll", function(){
         //바닥 까지 스크롤 했는지 여부 
         const isBottom = 
            window.innerHeight + window.scrollY  >= document.body.offsetHeight;
         //현재 페이지가 마지막 페이지인지 여부 알아내기
         let isLast = currentPage == lastPage;   
         //현재 바닥까지 스크롤 했고 로딩중이 아니고 현재 페이지가 마지막이 아니라면
         if(isBottom && !isLoading && !isLast){
            //로딩바 띄우기
            document.querySelector(".loader").style.display="block";
            
            //로딩 작업중이라고 표시
            isLoading=true;
            
            //현재 댓글 페이지를 1 증가 시키고 
            currentPage++;
            
            /*
               해당 페이지의 내용을 ajax 요청을 통해서 받아온다.
               "pageNum=xxx&num=xxx" 형식으로 GET 방식 파라미터를 전달한다. 
            */
            ajaxPromise("ajax_comment_list","get",
                  "pageNum="+currentPage+"&num=${dto.num}")
            .then(function(response){
               //json 이 아닌 html 문자열을 응답받았기 때문에  return response.text() 해준다.
               return response.text();
            })
            .then(function(data){
               //data 는 html 형식의 문자열이다. 
               console.log(data);
               // beforebegin | afterbegin | beforeend | afterend
               document.querySelector(".comments ul")
                  .insertAdjacentHTML("beforeend", data);
               //로딩이 끝났다고 표시한다.
               isLoading=false;
               //새로 추가된 댓글 li 요소 안에 있는 a 요소를 찾아서 이벤트 리스너 등록 하기 
               addUpdateListener(".page-"+currentPage+" .update-link");
               //addDeleteListener(".page-"+currentPage+" .delete-link");
               addReplyListener(".page-"+currentPage+" .reply-link");
               //새로 추가된 댓글 li 요소 안에 있는 댓글 수정폼에 이벤트 리스너 등록하기
               addUpdateFormListener(".page-"+currentPage+" .update-form");
               
               //로딩바 숨기기
               document.querySelector(".loader").style.display="none";
            });
         }
      });
      
      //인자로 전달되는 선택자를 이용해서 이벤트 리스너를 등록하는 함수 
      function addUpdateListener(sel){
         //댓글 수정 링크의 참조값을 배열에 담아오기 
         // sel 은  ".page-xxx  .update-link" 형식의 내용이다 
         let updateLinks=document.querySelectorAll(sel);
         for(let i=0; i<updateLinks.length; i++){
            updateLinks[i].addEventListener("click", function(){
               //click 이벤트가 일어난 바로 그 요소의 data-num 속성의 value 값을 읽어온다. 
               const num=this.getAttribute("data-num"); //댓글의 글번호
               document.querySelector("#updateForm"+num).style.display="block";
               
            });
         }
      }
      <%-- 
      function addDeleteListener(sel){
         //댓글 삭제 링크의 참조값을 배열에 담아오기 
         let deleteLinks=document.querySelectorAll(sel);
         for(let i=0; i<deleteLinks.length; i++){
            deleteLinks[i].addEventListener("click", function(){
               //click 이벤트가 일어난 바로 그 요소의 data-num 속성의 value 값을 읽어온다. 
               const num=this.getAttribute("data-num"); //댓글의 글번호
               const isDelete=confirm("댓글을 삭제 하시겠습니까?");
               if(isDelete){
                  // gura_util.js 에 있는 함수들 이용해서 ajax 요청
                  ajaxPromise("comment_delete", "post", "num="+num)
                  .then(function(response){
                     return response.json();
                  })
                  .then(function(data){
                     //만일 삭제 성공이면 
                     if(data.isSuccess){
                        //댓글이 있는 곳에 삭제된 댓글입니다를 출력해 준다. 
                        document.querySelector("#reli"+num).innerText="삭제된 댓글입니다.";
                     }
                  });
               }
            });
         }
      } --%>
      function addReplyListener(sel){
         //댓글 링크의 참조값을 배열에 담아오기 
         let replyLinks=document.querySelectorAll(sel);
         //반복문 돌면서 모든 링크에 이벤트 리스너 함수 등록하기
         for(let i=0; i<replyLinks.length; i++){
            replyLinks[i].addEventListener("click", function(){
               
               if(!isLogin){
                  const isMove=confirm("로그인이 필요 합니다. 로그인 페이지로 이동 하시겠습니까?");
                  if(isMove){
                     location.href=
                        "${pageContext.request.contextPath}/users/loginform?url=${pageContext.request.contextPath}/qna_board/detail?num=${dto.num}";
                  }
                  return;
               }
               
               //click 이벤트가 일어난 바로 그 요소의 data-num 속성의 value 값을 읽어온다. 
               const num=this.getAttribute("data-num"); //댓글의 글번호
               
               const form=document.querySelector("#reForm"+num);
               
               //현재 문자열을 읽어온다 ( "답글" or "취소" )
               let current = this.innerText;
               
               if(current == "답글"){
                  //번호를 이용해서 댓글의 댓글폼을 선택해서 보이게 한다. 
                  form.style.display="block";
                  form.classList.add("animate__fadeInLeft");
                  this.innerText="취소";   
                  form.addEventListener("animationend", function(){
                     form.classList.remove("animate__fadeInLeft");
                  }, {once:true});
               }else if(current == "취소"){
                  form.classList.add("animate__fadeOut");
                  this.innerText="답글";
                  form.addEventListener("animationend", function(){
                     form.classList.remove("animate__fadeOut");
                     form.style.display="none";
                  },{once:true});
               }
            });
         }
      }
      
      
      function addUpdateFormListener(sel){
         //댓글 수정 폼의 참조값을 배열에 담아오기
         let updateForms=document.querySelectorAll(sel);
         for(let i=0; i<updateForms.length; i++){
            //폼에 submit 이벤트가 일어 났을때 호출되는 함수 등록 
            updateForms[i].addEventListener("submit", function(e){
               //submit 이벤트가 일어난 form 의 참조값을 form 이라는 변수에 담기 
               const form=this;
               //폼 제출을 막은 다음 
               e.preventDefault();
               //이벤트가 일어난 폼을 ajax 전송하도록 한다.
               ajaxFormPromise(form)
               .then(function(response){
                  return response.json();
               })
               .then(function(data){
                  if(data.isSuccess){
                     /*
                        document.querySelector() 는 html 문서 전체에서 특정 요소의 
                        참조값을 찾는 기능
                        
                        특정문서의 참조값.querySelector() 는 해당 문서 객체의 자손 요소 중에서
                        특정 요소의 참조값을 찾는 기능
                     */
                     const num=form.querySelector("input[name=num]").value;
                     const content=form.querySelector("textarea[name=content]").value;
                     //수정폼에 입력한 value 값을 pre 요소에도 출력하기 
                     document.querySelector("#pre"+num).innerText=content;
                     form.style.display="none";
                  }
               });
            });
         }
      }
   </script>	
</body>
</html>