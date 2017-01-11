$('#edit-list-form').submit(function(event){
	event.preventDefault();
	
	var item = {};
	item["itemName"] = $("#item-name").val();
	item["note"] = $("#item-note").val();
	item["cost"] = $("#item-cost").val();
	item["priority"] = $("#item-priority").val();
	
 	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: 'http://localhost:8080/ExpenseTracker/add-item',
		data: JSON.stringify(item),
		dataType: 'json',
		timeout: 1000000,
		success: function(data)
		{
			console.log(data);
			addNewItem(data);
		},
		error: function(data)
		{
			console.log(data);
		}
	});
	
	clearForm();
});