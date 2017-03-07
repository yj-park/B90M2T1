/**
 * bookForm.html에 연결할 js 파일 
 */	

/* 셀렉트박스 옵션값 넣기  */
		var first = 10;
		var last = 24;
		function makeSelect() {
			var startHtml = "";
			var endHtml = "";
			for(i = first; i <= last; i++) {
				if(i < 23) {
					if(i < first + 2) {
						if(i == 10) {
							startHtml += "<option value='" + i + "' selected >"+ i +" </option>";
							continue;
						}
						startHtml += "<option value='" + i + "' >"+ i +" </option>";
					} 
					else {
						if(i == 12) {
							endHtml += "<option value='" + i + "' selected >"+ i +" </option>";
							startHtml += "<option value='" + i + "' >"+ i +" </option>";
							continue;
						}
						startHtml += "<option value='" + i + "' >"+ i +" </option>";
						endHtml += "<option value='" + i + "' >"+ i +" </option>";
					}
						
				}
				else {
					endHtml += "<option value='" + i + "' >"+ i +" </option>";
				}
			}
			$("#startTime").html(startHtml);
			$("#endTime").html(endHtml);
		};
		
		/*form submit 이벤트발생시  */
		$("#rForm").submit(function () {
			var rf = $("#rForm");
			console.log($("#rForm > [name=memberId]").val());
			if($("#rForm > [name=startTime]").val() >= $("#rForm > [name=endTime]").val()) {
				alert("예약종료시간을 확인해 주세요");
				return false;
			}
			if($("#rForm > [name=memberId]").val() == ""){
				alert("예약자 아이디를 입력해 주세요");
				return false;
			}
			if($("#rForm > [name=memberMobileNo]").val() == "") {
				alert("예약자 전화번호를 입력해 주세요");
				return false;
			}
			if($("input:checked").val() == null) {
				alert("방을 선택해 주세요");
				return false; 
			}
			alert("예약체크 완료");
			
			$.ajax({
				url: "book.do",
				data: {
						"bookStartTime" : $("#rForm > [name=startTime]").val(),
						"bookEndTime" : $("#rForm > [name=endTime]").val(),
						"memberId" : $("#rForm > [name=memberId]").val(),
						"mobileNo" : $("#rForm > [name=memberMobileNo]").val(),
						"roomName" : $("input:checked").val()
				},
				dataType : "text"
			})
			.done(function(result) {
				alert(result);
			})
			return false;
		});

		/* 방 라디오버튼 클릭시 이미지 보여주기 */
		$("input[type=radio]").on("click", function () { 
			console.log("라디오버튼클릭됨")
			var room = $(this).val();
			$.ajax({
				url: "book/roomInfo.do",
				data: {"roomName": room},
				dataType: "text"
				})
			.done(function(result) {
				$("#roomSpecInfo").attr("src", result.imgSavePath);
			});
			
		});
		
		
		/* 예약정보이미지 가져오기 */
		function structInfo(room) {
			$.ajax({
				url: "book/roomInfo.do",
				data: {"roomName": room},
				dataType: "text"
				})
			.done(function(result) {
				console.log(result.imgSavePath);
				$("#roomReservationInfo").attr("src", result.imgSavePath);
			});
		}
		
		// 페이지 로딩시 방구조 이미지  ajax 호출
//		structInfo("roomstruct");