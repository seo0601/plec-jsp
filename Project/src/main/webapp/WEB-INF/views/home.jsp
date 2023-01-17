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
	</div><!-- visual-bg -->
	
	
</body>
</html>