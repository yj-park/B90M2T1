
/** 전체목록과 관련된 함수 **/
function pageList(pageNo) {
	if (pageNo === undefined) {
		pageNo = 1;
	}
	$.ajax({
		url: "/mini2-team1/board/list.do",
		dataType: "json",
		data: {pageNo:pageNo}
	})
	.done(makePageList);
}

function makePageList(result) {
	$("#count").text(result.pageResult.count);
	
	var html = "";
	
	for (var i = 0; i < result.list.length; i++) {
		var board = result.list[i];
	
		html += '<tr>';
		html += '	<td>' + board.no + '</td>';
		html += '	<td><a href="javascript:detail('+board.no+');">' + board.title + '</a></td>';
		html += '	<td>' + board.memberId + '</td>';
		
		var date = new Date(board.regDate);
		var time = date.getFullYear() + "-" 
		         + (date.getMonth() + 1) + "-" 
		         + date.getDate() + " "
		         + date.getHours() + ":"
		         + date.getMinutes() + ":"
		         + date.getSeconds();
		html += '<td>' + time + '</td>';  
		html += '<td>' + board.viewCnt + '<td>';
		html += '</tr>';
		
	}
	
	if (!result.list.length) {
		html += '<tr><td colspan="4">게시물이 존재하지 않습니다.</td></tr>';
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

// 세부사항과 관련된 함수들
function detail(no) {
	console.log("디테일 no = " + no);
	pageDetail(no);
}

function pageDetail(no){
	console.log("ajax no = " + no);
	$.ajax({
		url: "/mini2-team1/board/detail.do",
		dataType: "json",
		data : {no : no}
	})
	.done(function(result) {
		console.log(result);
		board = result.boardVO
		console.log(board);
		$("div#container").load("view/board/detail.html");
		
	});
}

// 글쓰기와 관련된 함수들
function writeInfo() {
	$("div#container").load("view/board/writeForm.html");
	
}

function abc() {
	
	var fd = new FormData();
	fd.append("title", $("[name=title]").val());
	fd.append("memberId", $("[name=memberId]").val());
	fd.append("content", $("[name=content").val());
	fd.append("attachFile", $("[name=attachFile]")[0].files[0]);
	
	$.ajax({
		url: "/mini2-team1/board/write.do",
		data: fd,
		type: "POST",
		processData: false,
		contentType: false
	})
	.done(function() {
		alert("게시물이 등록되었습니다.");
		$("#container").load("view/board/list.html");
		pageList();
	})
}

// 게시판삭제와 관련된 함수
function deletePage(delNo) {
	
	$.ajax({
		url: "/mini2-team1/board/delete.do",
		data: {"no" : delNo}
	})
	.done(function() {
		alert("게시물이 삭제되었습니다.");
		$("#container").load("view/board/list.html");
		pageList();
	});
}

/** 게시판 수정과 관련된 함수 **/
function updateFormPage(modNo) {
	
	$.ajax({
		url: "/mini2-team1/board/updateForm.do",
		data: {"no" : modNo},
		dataType: "json",
	})
	.done(function(result) {
		board = result.board
		$("#container").load("view/board/updateForm.html");
	});
}

function pageUpdate() {
	
	var no = $("[name=no]").val();
	var title = $("[name=title]").val();
	var memberId = $("[name=memberId]").val();
	var content = $("[name=content").val();
	
	$.ajax({
		url: "/mini2-team1/board/update.do",
		data: {
			"no" : no,
			"title" : title,
			"memberId" : memberId,
			"content" : content
		} 		
	})
	.done(function() {
		alert("수정되었습니다.");
		$("#container").load("view/board/list.html");
	})
}

pageList();



