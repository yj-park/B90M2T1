
var source = $("#updateForm-template").html();

var template = Handlebars.compile(source);

var data = {
		
		updateForm : [{
			no : board.no,
			title : board.title,
			memberId : board.memberId,
			content : board.content			
		}]
		
}

var html = template(data);

$("#updateForm").html(html);