<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/qna_board/insertform.jsp</title>
<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/qna_board/qna_board_insertform.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div class="container">
	   	<form class="mt-3" action="insert" method="post" id="insertForm">
	      <div class="mb-3">
	         <label for="title" class="form=label">제목</label>
	         <input type="text" name="title" id="title" class="form-control"/>
	      </div>
	      <div class="mb-3">
	         <label for="content" class="form-label">내용</label>
	         <textarea name="content" id="content"></textarea>
	      </div>
	      <div class="d-flex justify-content-end">
	      	<button class="btn me-3" type="submit" onclick="submitContents(this)">저장</button>
		   </div>
		</form>
	</div>
	
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