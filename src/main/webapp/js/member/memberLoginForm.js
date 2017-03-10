/**
 * memberLoginForm.html에 연결할 js 파일 
 */
	//로그인 체크
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
		//		var type = sessionStorage.getItem("type");
				
				
//	 			var session = document.getElementById("mem").value;
//	 			console.log(session);
//	 			console.log("mem");
				swal("로그인 성공!");
				$("#memLogin").attr("style", "display:none");
				$("#memJoin").attr("style", "display:none");
				$("#memInfo").attr("style", "display:block");
				$("#memLogout").attr("style", "display:block");
				$("#container").load("view/main/main.html");
				
				sessionStorage.setItem("type", "default");
				console.log(sessionStorage.getItem("type"));
				
				// console.log(sessionStorage.getItem(type));
				/* localStorage.setItem("type", "default");
				console.log(localStorage.getItem(type));
				console.log(localStorage.getItem("type")); */
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
			  sessionStorage.setItem("type", "google");
			  sessionStorage.setItem("id", profile.getEmail());
			  sessionStorage.setItem("name", profile.getName());
			  
			  googleSetSession();
			  $("#memLogin").attr("style", "display:none");
			  $("#memJoin").attr("style", "display:none");
			  $("#memInfo").attr("style", "display:block");
			  $("#memLogout").attr("style", "display:block");
			  $("#container").load("view/main/main.html");
			  console.log(sessionStorage.getItem("type"));
		  }
		  else {
			  swal("추가 정보 입력을 위해 회원가입 페이지로 이동!");
//	 		  $("#container").load("view/member/memberJoinForm.html?id="+profile.getEmail()+"&name="+profile.getName()+" );
			  sessionStorage.setItem("type", "google");
			  $("#container").load("view/member/memberJoinForm.html");
			  localStorage.setItem("id", profile.getEmail());
			  localStorage.setItem("name", profile.getName());
		  }
	  })
	};

	//	구글로그인세션올리기
	function googleSetSession() {
		 $.ajax ({
				url: "member/memLoginChk.do",
				type: "POST",
				dataType: "json",
				data: {
					"id": sessionStorage.getItem("id")
					}	
		  })
		  $("#memLogin").attr("style", "display:none");
		  $("#memJoin").attr("style", "display:none");
		  $("#memInfo").attr("style", "display:block");
		  $("#memLogout").attr("style", "display:block");
		  $("#container").load("view/main/main.html");
		  console.log("구글세션등록");
	}

	
	
	
	// 구글 연동 로그아웃
	function signOut() {
		var type = sessionStorage.getItem("type");
		console.log(type);
		if(type == "default") {
			$.ajax ({
				url: "member/memLogout.do",
				type: "POST",
				dataType: "json"
			}).done (function (result) {
				swal(result.msg);
				$("#memLogin").attr("style", "display:block");
				$("#memJoin").attr("style", "display:block");
				$("#memInfo").attr("style", "display:none");
				$("#memLogout").attr("style", "display:none");
			    $("#container").load("view/main/main.html");
			    });
		}else {
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
		}
	    
	};