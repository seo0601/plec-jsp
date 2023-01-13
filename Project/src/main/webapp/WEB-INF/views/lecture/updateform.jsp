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
		<h3>글 수정 폼입니다.</h3>
		<form action="${pageContext.request.contextPath}/lecture/update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="lecturNum" value="${dto.lectureNum }" />
			<div>
			  <label for="image">썸네일</label>
			  <input type="file" id="formFile" name="image" accept=".jpg, .jpeg, .png, .JPG, .JPEG" >
			</div>
			<div>
				<label for="title">강의 제목</label>
				<input type="text" name="title" id="title" value="${dto.title}" />
			</div>
			<div>
				<label for="teacher">강사</label>				
				<input type="text" name="teacher" id="teacher" value="${dto.teacher}" />				
			</div>
			<div>
				<label for="describe">강의 내용</label>				
				<textarea name="describe" id="describe">${dto.describe }</textarea>				
			</div>
			<div>
		         	<label for="videoPath">강의 영상</label>
		         	<input type="text" name="videoPath" id="videoPath" value="${dto.videoPath}" />
		    </div>
		    <div>
		     	<label for="Large_category">대분류</label>
		     	<select name="Large_category" id="Large_category">
		      			<option value="1">프론트엔드</option>
		      			<option value="2">백엔드</option>
		      			<option value="3">모바일</option>
		      	</select>
		    </div>
		    <div>
		      	<label for="small_category">소분류</label>
		      		<select name="small_category" id="small_category">
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
			<button type="submit" onclick="submitContents(this)">수정확인</button>
			<button type="reset">취소</button>
		</form>
	</div>	
</body>
</html>