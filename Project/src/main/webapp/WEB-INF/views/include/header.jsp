<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main_nav.css" />
<div class="header-blue">
	<nav class="navbar navbar-dark navbar-expand-md navigation-clean-search" style="background-color:#fff">
        <div class="container"><a class="navbar-brand" href="${pageContext.request.contextPath}/">logo</a><button class="navbar-toggler"
                data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle
                    navigation</span><span class="navbar-toggler-icon ham-btn"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                   
                    <li class="dropdown">
                    <a class="dropdown-toggle nav-link dropdown-toggle new-nav-link" data-toggle="dropdown" aria-expanded="false" href="#">강의 </a>
                        <div class="dropdown-menu" role="menu">
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/lecture/frontend/frontendList">웹프론트엔드</a>
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/lecture/backend/backendList">웹백엔드</a>
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/lecture/mobile/mobileList">모바일</a>
                        </div>
                    </li>
                    <!--<li class="nav-item" role="presentation"><a class="nav-link active" href="#">Link</a></li>-->
                    <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle new-nav-link"
                        data-toggle="dropdown" aria-expanded="false" href="#">고객센터 </a>
                        <div class="dropdown-menu" role="menu">
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/notice/list">공지사항</a>
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/faq/list">자주묻는질문</a>
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/qna_board/list">1:1 문의</a>
                        </div>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle nav-link dropdown-toggle new-nav-link"
                        data-toggle="dropdown" aria-expanded="false" href="#">커뮤니티</a>
                        <div class="dropdown-menu" role="menu">
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/qna_users/list">질문답변</a>
                            <a class="dropdown-item" role="presentation" href="${pageContext.request.contextPath}/qna_free/list">자유게시판</a>
                        </div>
                    </li>
                </ul>
                <!-- //검색 
                <form class="form-inline mr-auto" target="_self">
                    <div class="form-group"><label for="search-field"><i class="fa fa-search"></i></label>
                        <input class="form-control search-field" type="search" name="search" id="search-field">
                    </div>
                </form> -->

				<div style="margin-left:auto">
	                <c:choose>
	                    <c:when test="${ empty sessionScope.id}">
	                        <span class="navbar-text"><a href="${pageContext.request.contextPath}/users/loginform" class="login">로그인</a></span>
	                        <a href="${pageContext.request.contextPath}/users/signup_form" class="btn btn-light action-button" role="button" >회원가입</a>
	                    </c:when>
	                    <c:otherwise>
	                        <p>
								<c:choose>
									<c:when test="${sessionScope.id eq 'admin'}">
										<a href="${pageContext.request.contextPath }/users/list" class="login" style="vertical-align: middle;">회원 목록</a>
									</c:when>
									<c:otherwise>
										<span class="navbar-text"><a href="${pageContext.request.contextPath}/users/info" class="login" style="vertical-align: middle;">${sessionScope.id }</a> 로그인중... </span>
									</c:otherwise>
								</c:choose>
	                            <a href="${pageContext.request.contextPath}/users/logout" class="btn btn-light action-button" role="button" >로그아웃</a>
	                        </p>
	                    </c:otherwise>
	                </c:choose>	
                </div>
            </div>
        </div>
    </nav>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</div>