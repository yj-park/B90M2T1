/**
 * bookForm.html에 연결할 js 파일 
 */	
/*날짜선택달력 생성*/
function calendar() {
	    $("#datePicker").datepicker({
	    	closeText: '닫기',
			prevText: '이전달',
			nextText: '다음달',
			currentText: '오늘',
			monthNames: ['1월','2월','3월','4월','5월','6월',
			'7월','8월','9월','10월','11월','12월'],
			monthNamesShort: ['1월','2월','3월','4월','5월','6월',
			'7월','8월','9월','10월','11월','12월'],
			dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'],
			dayNamesShort: ['일','월','화','수','목','금','토'],
			dayNamesMin: ['일','월','화','수','목','금','토'],
			weekHeader: 'Wk',
			dateFormat: 'yymmdd',
			firstDay: 0,
			isRTL: false,
			showMonthAfterYear: true,
			showOtherMonths: true,
			yearSuffix: '년',
			minDate: new Date(),
			yearRange: 'c-99:c+99',
			onSelect: function (dateText) {
				EvtChangeMonthYear(dateText)
			}
	    
	    });
	}

	function EvtChangeMonthYear(dateText) {
		console.log($("#datePicker").val());

	}


/* 셀렉트박스 옵션값 넣기  */
		function makeSelect() {
			var first = 10;
			var last = 24;
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
		
		// 예약시간 체크하기
		$("#timeChk").click(function () {
			if($("#rForm > [name=startTime]").val() >= $("#rForm > [name=endTime]").val()) {
				swal("시작시간과 종료시간을  확인해 주세요");
				return false;
			}
			$.ajax({
				url : "book/timeCheck.do",
				data : {
						"bookDate" :  $("#datePicker").val(),
						"bookStartTime" : $("#rForm > [name=startTime]").val(), 
						"bookEndTime" : $("#rForm > [name=endTime]").val(),
						},
				dataType : "json"
			})
			.done(function (result) {
				if(result.length === 0) {
					$("#centerArea > #timeSheet").html("");
					swal("모든방 예약이 가능합니다.");
					
				}
				else {
					console.dir(result);
					var html = "";
					for(i = 0; i < result.length; i++) {
						html += "<p>" + result[i].roomName + "룸 : " + result[i].bookStartTime + "시 - " + result[i].bookEndTime + "시 </p>";
					}
					swal("선택한 시간의 예약현황을 확인해 주세요.");
					$("#centerArea > #timeSheet").html(html);
				}
			})
		}); 
		
		
		/*form submit 이벤트발생시  */
		$("#rForm").submit(function () {
			getUserInfo();
			if($("#rForm > [name=startTime]").val() >= $("#rForm > [name=endTime]").val()) {
				swal("예약종료시간을 확인해 주세요");
				return false;
			}
			if($("#rForm > [name=memberId]").val() == ""){
				swal("예약자 아이디를 입력해 주세요");
				return false;
			}
			if($("#rForm > [name=memberMobileNo]").val() == "") {
				swal("예약자 전화번호를 입력해 주세요");
				return false;
			}
			if($("input:checked").val() == null) {
				swal("방을 선택해 주세요");
				return false; 
			}
			
			$.ajax({
				url: "book/book.do",
				type: "POST",
				data: {	
						"bookDate" : $("#datePicker").val(),
						"bookStartTime" : $("#rForm > [name=startTime]").val(),
						"bookEndTime" : $("#rForm > [name=endTime]").val(),
						"memberId" : $("#rForm > [name=memberId]").val(),
						"mobileNo" : $("#rForm > [name=memberMobileNo]").val(),
						"roomName" : $("input:checked").val(),
						"headCnt" : $("#rForm > [name=headCnt]").val()
				},
				dataType : "json"
			})
			.done(function(result) {
				if(result.msg) {
					swal("예약되었습니다.");
				}
				else swal("예약에 실패했습니다.시간을 확인해 주세요");
			});
			return false;
		});
		
		
		/* 방 라디오버튼 클릭시 이미지 보여주기 */
		$("input[type=radio]").on("click", function () { 
			var room = $(this).val();
			$.ajax({
				url: "book/roomInfo.do",
				data: {"roomName": room},
				dataType: "json"
				})
			.done(function(result) {
				$("#roomImg").attr("src", result.imgSavePath);
				$("#roomInfo").html("<hr><h3>스터디룸 : " + result.name + "룸 / 정원 : " + result.maxHeadCnt + "</h3>");
			});
		});
		
		
		/* 예약정보이미지 가져오기 */
		function structInfo(room) {
			$.ajax({
				url: "book/roomInfo.do",
				data: {"roomName": room},
				dataType: "json"
				})
			.done(function(result) {
				console.log(result.imgSavePath);
				$("#roomReservationInfo").attr("src", result.imgSavePath);
			});
		}
		function getUserInfo() {
			$.ajax ({
				url : "book/getUserInfo.do",
				dataType : "json"
				
			})
			.done(function (result) {
				if(result.msg) {
					$("#rForm > [name=memberId]").val(result.member.id);
				}
				else {
					$("#rForm > [name=memberId]").val("");
					swal("예약을 위해 로그인해 주세요!");
					return false;
				}
			}); 
		}
		calendar();
		makeSelect();
		structInfo("r");
		getUserInfo();
		// 페이지 로딩시 방구조 이미지  ajax 호출
//		structInfo("roomstruct");
