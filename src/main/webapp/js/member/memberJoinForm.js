/**
 * memberJoinForm.html에 연결할 js 파일 
 */

// 회원가입 저장
$("#btnJoin").click(function () {
	$.ajax ({
		url: "membJoin.do",
		method: "post",
		data: {
			id: $("#id").val(),
			pass: $("#pass").val(),
			passchk: $("#passchk").val(),
			name: $("#name").val(),
			email: $("#email").val()
		} ,
		dataType: "json"
	})
});

// 아이디 중복 체크
/*$(function(){
	var checkAjaxSetTimeout;
    $('#id').keyup(function(){
        if ( $('#id').val().length > 6) {
            var id = $(this).val();
            // ajax 실행
            $.ajax({
                type : "POST",
                url : "memberJoinForm.do",
                data: {id: id},
                success : function(result) {
                    //console.log(result);
                    if (result) {
                        alert ("사용 가능한 아이디 입니다.");
                    } else {
                        alert ("사용 불가능한 아이디 입니다.");
                    }
                }
            }); // end ajax
        }
    }); // end keyup
});*/

