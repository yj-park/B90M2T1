/**
 * memberLoginForm.html에 연결할 js 파일 
 */
// 네이버 연동 로그인

	var naver_id_login = new naver_id_login("npBkQzysxHAaqLzBAh8p", "http://bit-easybook.com:9090/mini-prj2/index.html");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("white", 2, 43);
	naver_id_login.setDomain(".bit-easybook.com");
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();

// 로그인 체크
$("#btnLogin").click(function () {
	$.ajax ({
		url: "member/memLoginChk.do",
		type: "POST",
		dataType: "json",
		data: {
			"id": $("#id").val(),
			"password": $("#password").val()
		}
	}).done(function(msg) {
		console.log(msg);
		if(msg == "Hello"){
			swal("로그인 성공!");
			
			$("#memLogin").attr("style", "display:none");
			$("#memJoin").attr("style", "display:none");
			$("#memInfo").attr("style", "display:block");
			$("#memLogout").attr("style", "display:block");
			$("#container").load("view/main/main.html");
			
			sessionStorage.setItem("type", "default");
		}
		else {
			swal("아이디 또는 비밀번호를 확인해주세요");
		}
	})
});

// 구글 연동 로그인 회원 정보 얻어오기
function onSignIn(googleUser) {
  var profile = googleUser.getBasicProfile();
  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
  console.log('Name: ' + profile.getName());
  console.log('Image URL: ' + profile.getImageUrl());
  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
  
  $.ajax ({
	  url: "member/memGoogleChk.do",
	  type: "POST",
	  dataType: "json",
	  data: {
		  "id": profile.getEmail(),
	  }
  }).done (function (result){
	  if(result.googleIdChk){
		  swal("구글 로그인 성공!");
		  $("#memLogin").attr("style", "display:none");
		  $("#memJoin").attr("style", "display:none");
		  $("#memInfo").attr("style", "display:block");
		  $("#memLogout").attr("style", "display:block");
		  $("#container").load("view/main/main.html");
	  }
	  else {
		  swal("추가 정보 입력을 위해 회원가입 페이지로 이동!");
// 		  $("#container").load("view/member/memberJoinForm.html?id="+profile.getEmail()+"&name="+profile.getName()+" );
		  $("#container").load("view/member/memberJoinForm.html");
		  localStorage.setItem("id", profile.getEmail());
		  localStorage.setItem("name", profile.getName());
		  sessionStorage.setItem("type", "google");
	  }
  })
};

// 구글 연동 로그아웃
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    console.log(auth2);
    auth2.signOut().then(function () {
    console.log('User signed out.');
    
    swal("로그아웃 성공!");
    $("#memLogin").attr("style", "display:block");
	$("#memJoin").attr("style", "display:block");
	$("#memInfo").attr("style", "display:none");
	$("#memLogout").attr("style", "display:none");
    $("#container").load("view/main/main.html");
    });
};
