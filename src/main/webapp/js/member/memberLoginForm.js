/**
 * memberLoginForm.html에 연결할 js 파일 
 */

// 로그인 체크
$("#btnLogin").click(function () {
	$.ajax ({
		url: "memLoginChk.do",
		type: "POST",
		dataType: "json",
		data: {
			id: $("#id").val(),
			password: $("#password").val(),
		}
	}).done(function(result) {
		console.log(result);
		if(result.loginChk){
			
//			$("a > #login").addClass("hidden");
//			$("a > #join").addClass("hidden");
			
			alert("로그인 성공!");
			
			
		}
		else {
			alert("아이디 또는 비밀번호를 확인해주세요");
		}
	})
});

/*function goLoginForm(){
	$("div.w3-content").load("WEB-INF/view/member/memberLoginForm.html");
}*/