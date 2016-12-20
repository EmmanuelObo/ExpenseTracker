$(function(){
$("#edittor").on("submit", function(e){
	e.preventDefault();
	var json = {"id":null, "title": "Testing", "total":null, "owner":null, "items": null};
	$.ajax({
		type: "POST",
		url: "http://localhost:8189/ExpenseTracker/edit-list?",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(json),
		dataType: "json",
		success: function(result)
		{
			console.log(result);
		},
		error: function(err)
		{
			console.log(err);
		}
	});
});
});

