$(function(){
$(".form-view-list").each(function(){
	$(this).on("submit", function(e){
	e.preventDefault();
	
	var json = {"id": $(this).find('#list-id').val(), "title": $(this).find('#list-title').val(), "total":$(this).find('#list-total').val(), "dateCreated":$(this).find('#date-created').val(), "owner":null, "items": null};
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/ExpenseTracker/view-list?",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(json),
		dataType: "json",
		success: function(result)
		{
			var items = result.items ? "something" : "Nothing";
			$('.modal-content').html(" <h1>" + result.title + "</h1> " +
					"<p> Total: " + result.total + "</p>" +
					"<p> Items: " + items + "</p>" +
					"<p> Date Created: " + result.dateCreated + "</p>" +
					"<p> Owner: " + $('#list-owner').val() + "</p>" +
					"<button>Edit</button> " +
					"<form action='view-lists' method='POST'>" +
			"<input type='hidden' value="+result.id + " name='listID'>" +
			"<input type='submit' value='Discard'>" +
			"</form>")
			
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

