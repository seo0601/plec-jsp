<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/home.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
</head>

<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="visual-bg">
			<div class="container hero">
			    <div class="row">
			        <div class="col-12 col-lg-6 col-xl-5 offset-xl-1">
			            <h1>The revolution is here.</h1>
			            <p>Mauris egestas tellus non ex condimentum, ac ullamcorper sapien dictum. Nam consequat neque
			                quis sapien viverra convallis. In non tempus lorem. </p><button
			                class="btn btn-light btn-lg action-button" type="button">Learn More</button>
			        </div>
			        <div class="col-md-5 col-lg-5 offset-lg-1 offset-xl-0 d-none phone-holder">
			            <div class="iphone-mockup"><img src="assets/img/iphone.svg" class="device">
			                <div class="screen"></div>
			            </div>
			        </div>
			    </div>
		    </div>
	    </div>
	    <a href="${pageContext.request.contextPath}/studentLecture/frontend/frontendList">수강신청 프론트엔드리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/frontend/html_cssList">수강신청 html/css리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/frontend/jQueryList">수강신청 jQurey리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/frontend/jsList">수강신청 js리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/frontend/reactList">수강신청 react리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/frontend/vueList">수강신청 vue리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/backend/backendList">수강신청 백엔드리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/backend/javaList">수강신청 자바리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/backend/springList">수강신청 스프링리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/backend/springbootList">수강신청 스프링부트리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/mobile/mobileList">수강신청 모바일리스트</a>
	    <br />
	    <a href="${pageContext.request.contextPath}/studentLecture/mobile/kotlinList">수강신청 코틀린리스트</a>
	</div><!-- visual-bg -->
	
	

		</div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
>>>>>>> branch 'master' of https://github.com/Acorn202210/ItProject.git
</body>
</html>