$(function(){
$(".form-view-list").each(function(){
	$(this).on("submit", function(e){
	e.preventDefault();
	var json = {"id": $('#list-id').val(), "title": "Testing", "total":null, "owner":null, "items": null};
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/ExpenseTracker/view-list?",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(json),
		dataType: "json",
		success: function(result)
		{
			$("#view-list-modal").modal('show');
		},
		error: function(err)
		{
			console.log(err);
		}
	});
	});
});
});

