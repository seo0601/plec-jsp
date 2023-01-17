<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/views/users/signup_form.jsp</title>

<jsp:include page="/WEB-INF/views/include/bootCss.jsp"></jsp:include>
<link href="${pageContext.request.contextPath }/resources/css/users.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div class="container userform">
			<main class="form-signin w-100 m-auto mt-5">
			   <h3 class="text-center mb-3 fw-normal">환영합니다</h3>
			   <form action="${pageContext.request.contextPath}/users/signup" method="post" id="myForm">
			  	  <div class="form-floating">
			         <input type="text" class="form-control" name="id" id="floatingId" placeholder="아이디"/>   
			         <label for="floatingId">아이디</label>
			         <small class="form-text text-muted">영문자 소문자로 시작하고 5글자~10글자 이내로 입력하세요</small>
					 <div class="valid-feedback">사용 가능한 아이디 입니다.</div>
					 <div class="invalid-feedback">사용할 수 없는 아이디 입니다.</div>   
			      </div>
			      <div class="form-floating">
			      	 <input type="password" class="form-control" name="pwd" id="floatingPwd" placeholder="비밀번호"/> 
			         <label for="floatingPassword">비밀번호</label>
			         <small class="form-text text-muted">특수 문자를 하나 이상 조합하세요.</small>
					 <div class="invalid-feedback">비밀 번호를 확인 하세요</div>  
			      </div>
			      <div class="form-floating">
			         <input type="password" class="form-control" name="pwd2" id="floatingPwd2" placeholder="비밀번호 확인"/>
			         <label for="floatingPassword2">비밀번호 확인</label>
			      </div>
			      <div class="form-floating">
			      	 <input type="text" class="form-control" name="phone" id="floatingPhone" placeholder="핸드폰 번호"/>  
			      	 <label for="floatingPhone">핸드폰 번호</label>
			      </div>
			      <div class="form-floating">
			         <input type="date" class="form-control" name="birth" id="floatingBirth" placeholder="생일"/>  
			         <label for="floatingBirth">생일</label>
			      </div>
			      <div class="form-floating">
			         <input type="email" class="form-control" name="email" id="floatingEmail" placeholder="이메일"/>
			         <label for="floatingEmail">이메일</label>
			         <div class="invalid-feedback">이메일 형식에 맞게 입력하세요.</div>
			      </div>
			      <button class="w-100 button btn btn-lg" type="submit">가입</button>
			  </form>
			</main>
		 </div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
   	<script>
	//유효성 여부를 저장할 변수를 만들고 초기값 대입 
	let isIdValid=false;
	let isPwdValid=false;
	let isEmailValid=false;	

	document.querySelector("#floatingEmail").addEventListener("input", function(){
		
		this.classList.remove("is-valid");
		this.classList.remove("is-invalid");
		//입력한 이메일
		const inputEmail=this.value;
		//이메일을 검증할 정규 표현식  
		const reg=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		//만일 입력한 이메일이 정규표현식 검증을 통과 하지 못했다면
		if(!reg.test(inputEmail)){
			this.classList.add("is-invalid");
			isEmailValid=false;
		}else{//통과 했다면 
			this.classList.add("is-valid");
			isEmailValid=true;
		}
	});	
	
	function checkPwd(){
		//먼저 2개의 클래스를 제거하고 
		document.querySelector("#floatingPwd").classList.remove("is-valid");
		document.querySelector("#floatingPwd").classList.remove("is-invalid");
		//입력한 두개의 비밀 번호를 읽어와서 
		const pwd=document.querySelector("#floatingPwd").value;
		const pwd2=document.querySelector("#floatingPwd2").value;
		
		//비밀번호를 검증할 정규 표현식
		const reg=/[\W]/;
		//만일 정규표현식 검증을 통과 하지 못했다면
		if(!reg.test(pwd)){
			document.querySelector("#floatingPwd").classList.add("is-invalid");
			isPwdValid=false;
			return; //함수를 여기서 끝내라 
		}
		
		//만일 비밀번호 입력란과 확인란이 다르다면
		if(pwd != pwd2){
			document.querySelector("#floatingPwd").classList.add("is-invalid");
			isPwdValid=false;
		}else{//같다면
			document.querySelector("#floatingPwd").classList.add("is-valid");
			isPwdValid=true;
		}
	}

	document.querySelector("#floatingPwd").addEventListener("input", function(){
		checkPwd();
	});
	
	document.querySelector("#floatingPwd2").addEventListener("input", function(){
		checkPwd();
	});


	// id 를 입력 할때 마다 호출되는 함수 등록 
	document.querySelector("#floatingId").addEventListener("input", function(){
		//input 요소의 참조값을 self 에 미리 담아 놓기 
		const self=this;
		//일단 2개의 클래스를 모두 제거 한다음 
		self.classList.remove("is-valid");
		self.classList.remove("is-invalid");
		
		//1. 입력한 아이디를 읽어와서
		const inputId=self.value;
		
		//아이디를 검증할 정규표현식
		const reg=/^[a-z].{4,9}$/;
		//입력한 아이디가 정규표현식과 매칭이 되는지(통과 되는지) 확인한다. 
		const isMatch=reg.test(inputId);
		//만일 매칭되지 않는다면
		if(!isMatch){
			self.classList.add("is-invalid");
			isIdValid=false;
			return; //함수를 여기서 끝내라
		}
		
		//2. 서버에 페이지 전환없이 전송을 하고 응답을 받는다.
		fetch("checkid?inputId="+inputId)
		.then(function(response){
			return response.json();
		})
		.then(function(data){
			//3. 사용가능한지 여부에 따라 아이디 입력란에 is-valid or is-invalid 클래스를 적절히 추가, 제거를 한다.
			if(data.isExist){
				self.classList.add("is-invalid");
				isIdValid=false;
			}else{
				self.classList.add("is-valid");
				isIdValid=true;
			}
		});
	});
	
	//폼에 submit 이벤트가 일어 났을때 실행할 함수 등록
	document.querySelector("#myForm").addEventListener("submit", function(event){	
		
		//아래의 코드는 아이디, 비밀번호, 이메일 유효성 검증결과를 고려해서 조건부로 실행되도록 해야 한다.
		//폼 전체의 유효성 여부
		const isFormValid = isIdValid && isPwdValid && isEmailValid;
		//만일 폼이 유효하지 않으면
		if(!isFormValid){
			event.preventDefault(); //폼 전송을 막는다.
		}
	});
	
	</script>  
</body>
</html>