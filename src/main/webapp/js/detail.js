
var source = $("#detail-template").html();

var template = Handlebars.compile(source);

var data = {
		
		detail : [
		   { no : board.no,
		     title : board.title,
		     memberId : board.memberId,
		     content : board.content,
		     regDate : board.regDate
		   }
		]
}

var html = template(data);

$("#detail").html(html);


