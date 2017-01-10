$('#edit-list-form').on('submit', function(){
	clearInputFields();
})


function clearInputFields()
{
	$('#item-name').val("");
	$('#item-cost').val("");
	$('#item-note').val("");
}