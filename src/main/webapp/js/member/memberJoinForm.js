/**
 * memberJoinForm.html에 연결할 js 파일 
 */

$(function() {
//	alert("2")
	var type = localStorage.getItem("type");
	
	if(type == "google") {
		googleMemJoin();
	}
})
// 아이디(이메일)중복 검사
$("#id").on("keyup",function(){
	console.log($("#id"));
	$.ajax({
		url : "member/memIdChk.do",
		type:"POST",
		data :{ 
			"id": $("#id").val()
		},
		dataType : "json"
	})
	.done(function (result) {
		console.log(result)
		if(result.idCheck){
			$("#idChkResult").html("사용중인 아이디입니다");
		}
		else {$("#idChkResult").html("사용가능한 아이디입니다");}
	})
})



//회원가입 
$("#btnJoin").click(function () {
	window.localStorage.clear();
	$.ajax ({
		url: "member/memJoin.do",
		method: "post",
		data: {
			"id": $("#id").val(),
			"password": $("#pass").val(),
			"passchk": $("#passchk").val(),
			"name": $("#name").val()
		},
		dataType: "json"
	}).done(function (msg) {
		console.log(msg);
		if (msg == "Success") {
			swal("이미 가입한 아이디입니다.");
			return false;
		}
		swal("회원가입이 완료되었습니다.");
		$("#container").load("view/main/main.html");
	})
});



//구글 연동 회원가입
function googleMemJoin(){
	
//	alert("3")
	console.log(localStorage.getItem("id"))
	var id = localStorage.getItem("id");
	$("#id").val(id);
	var name = localStorage.getItem("name");
	$("#name").val(name);
	
	$.ajax ({
		url: "member/memJoin.do",
		type: "POST",
		dataType: "json",
		data: {
			"id": id,
			"name": name,
			"password": $("pass").val(),
			"passchk": $("#passchk").val()
		}
	}).done (function (msg) {
		console.log(msg);
		if (msg == "Success") {
			swal("이미 가입한 아이디입니다.");
			return false;
		}
		swal("회원가입이 완료되었습니다.");
		$("#container").load("view/main/main.html");
	})
};
