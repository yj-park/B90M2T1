
/** 전체목록과 관련된 함수 **/
function pageList(pageNo) {
	if (pageNo === undefined) {
		pageNo = 1;
	//console.log(pageNo); // 1 출력
	}
	$.ajax({
		url: "/mini2-team1/myPage/bookList.do",
		dataType: "json",
		data: {pageNo:pageNo}
	})
	.done(makePageList);
}

function makePageList(result) {
	$("#count").text(result.pageResult.count);
	
	var html = "";
	
	for (var i = 0; i < result.list.length; i++) {
		var book = result.list[i];
	
		html += '<tr>';
//		html += '	<td>' + book.bookNo + '</td>';
		html += '	<td>' + book.bookDate + '</td>';
		html += '	<td>' + book.bookStartTime + '</td>';
		html += '	<td>' + book.bookEndTime + '</td>';
		html += '	<td>' + book.roomName + '</td>';
		html += '	<td>' + book.memberId + '</td>';
		html += '	<td>' + book.headCnt + '</td>';
		html += '	<td>예약&nbsp;<button onclick=bookDelete(' + book.no + ');>x</button></td>';
		html += '</tr>';
	}
	
	if (!result.list.length) {
		html += '<tr><td colspan="7">예약정보가 없습니다.</td></tr>';
	}
	
	$("#pageTable").html(html);
	
	makePageLink(result.pageResult);
}

/** 페이징과 관련된 함수 **/
function makePageLink(data) {
	var html = "";
	if (data.count != 0) {
		var clz = "";
		if (data.prev == false) {
			clz = "disabled";
		}
		html += '<li class="' + clz + '">';
		
		var fn = "";
		
		if (data.prev == true) {
			fn = "javascript:pageList(" + (data.beginPage - 1) + ");";
		}
		html += '<a href="' + fn + '" aria-label="Previous">';
		html += '<span aria-hidden="true">&laquo;</span>';
		html += '</a>';
	    html += '</li>';
		
	    for (var i = data.beginPage; i <= data.endPage; i++) {
	    	if (i == data.pageNo) {
			    html += '<li class="active"><a href="#1">' + i + '</a></li>';
	    	}
	    	else {
	    		html += '<li><a href="javascript:pageList(' + i + ');">' + i + '</a></li>';
	    	}
	    }
	    
		clz = "";
		if (data.next == false) {
			clz = "disabled";
		}
		html += '<li class="' + clz + '">';
		
		fn = "";
		
		if (data.next == true) {
			fn = "javascript:pageList(" + (data.endPage + 1) + ");";
		}
		html += '<a href="' + fn + '" aria-label="Next">';
		html += '<span aria-hidden="true">&raquo;</span>';
		html += '</a>';
	    html += '</li>';
	}
	
	$("nav > ul.pagination").html(html);
}

function bookDelete(no) {
	console.log(no);
	$.ajax({
		url: "/mini2-team1/myPage/bookDelete.do",
		data: {"no" : no}
	})
	.done(function() {
		alert("예약이 취소되었습니다.");
//		$("#container").load("view/member/list.html");
		pageList();
	});
	
}


pageList();



