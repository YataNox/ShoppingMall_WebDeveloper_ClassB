function loginCheck(){
	if(document.loginFrm.id.value==""){
		alert("아이디를 입력하세요.");
		document.loginFrm.id.focus();
		return false;
	}
	if(document.loginFrm.pwd.value==""){
		alert("비밀번호를 입력하세요.");
		document.loginFrm.pwd.focus();
		return false;
	}
	return true;
}

function go_next(){
	// 자바스크립트에서 jsp페이지 내의 radio버튼을 바라볼 때, 같은 name의 radio가 여러개라면
	// name 값에 의한 배열로 인식되어 사용됩니다.
	// 동의함 버튼 : okon[0], 동의안함 버튼 : okon[1]
	if(document.contractFrm.okon[1].checked == true){
		alert("약관에 동의하셔야 회원 가입이 가능합니다.");
	}
	else{
		// 스크립트 명령으로 폼의 액션 설정하고 submit 실행
		document.contractFrm.action = "shop.do?command=joinForm";
		document.contractFrm.submit();
	}
	
}