<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/lecture/upload_form.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/users.css" rel="stylesheet">

</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="container userform">
		   	<main class="form-signin w-100 m-auto mt-5">
	   			<h3 class="text-center mb-3 fw-normal">강의 등록 페이지 </h3>
	   			<p class="text-center mb-3 fw-normal">강의 등록 페이지입니다.</p>
			   	<form action="${pageContext.request.contextPath}/lecture/upload" method="post" enctype="multipart/form-data">
			      	<div class="mb-3">
					  <label for="image" class="form-label">썸네일</label>
					  <input class="form-control" type="file" id="formFile" name="image" accept=".jpg, .jpeg, .png, .JPG, .JPEG" >
					</div>
					<div class="mb-3">
			         	<label class="form-label" for="title">강의 제목</label>
			         	<input class="form-control" type="text" name="title" id="title"/>
			      	</div>
			      	<div class="mb-3">
			         	<label class="form-label" for="teacher">강사</label>
			         	<input class="form-control" type="text" name="teacher" id="teacher"/>
			      	</div>
			      	<div class="mb-3">
			         	<label class="form-label" for="describe">강의 내용</label>
			         	<textarea name="describe" id="content"></textarea>
			      	</div>
			      	<div class="mb-3">
			         	<label class="form-label" for="videoPath">강의 영상</label>
			         	<input class="form-control" type="text" name="videoPath" id="videoPath" placeholder="링크 입력"/>
			      	</div>
			      	<div class="mb-3">
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
			      	<button class="w-100 button btn btn-lg mt-3" type="submit">업로드</button>
			   	</form>
			   </main>
		   	</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
 <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	
	<!-- SmartEditor 에서 필요한 javascript -->
	<script src="${pageContext.request.contextPath }/resources/SmartEditor/js/HuskyEZCreator.js"></script>
	
	<script>
	   var oEditors = [];
	   
	   //추가 글꼴 목록
	   //var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];
	   
	   nhn.husky.EZCreator.createInIFrame({
	      oAppRef: oEditors,
	      elPlaceHolder: "content",
	      sSkinURI: "${pageContext.request.contextPath}/resources/SmartEditor/SmartEditor2Skin.html",   
	      htParams : {
	         bUseToolbar : true,            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	         bUseVerticalResizer : true,      // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	         bUseModeChanger : true,         // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	         //aAdditionalFontList : aAdditionalFontSet,      // 추가 글꼴 목록
	         fOnBeforeUnload : function(){
	            //alert("완료!");
	         }
	      }, //boolean
	      fOnAppLoad : function(){
	         //예제 코드
	         //oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
	      },
	      fCreator: "createSEditor2"
	   });
	   
	   function pasteHTML() {
	      var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
	      oEditors.getById["content"].exec("PASTE_HTML", [sHTML]);
	   }
	   
	   function showHTML() {
	      var sHTML = oEditors.getById["content"].getIR();
	      alert(sHTML);
	   }
	
	   
	   function setDefaultFont() {
	      var sDefaultFont = '궁서';
	      var nFontSize = 24;
	      oEditors.getById["content"].setDefaultFont(sDefaultFont, nFontSize);
	   }
	   
	   //폼에 submit 이벤트가 일어났을때 실행할 함수 등록
	   document.querySelector("#insertForm")
	      .addEventListener("submit", function(e){
	         //에디터에 입력한 내용이 textarea 의 value 값이 될수 있도록 변환한다. 
	         oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	         //textarea 이외에 입력한 내용을 여기서 검증하고 
	         const title=document.querySelector("#title").value;
	         
	         //만일 폼 제출을 막고 싶으면  
	         //e.preventDefault();
	         //을 수행하게 해서 폼 제출을 막아준다.
	         if(title.length < 5){
	            alert("제목을 5글자 이상 입력하세요!");
	            e.preventDefault();
	         }
	         
	      });
	</script>
</body>
</html>