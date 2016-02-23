function generateQuestions(){
	var names = $('#names').val();
	var items = $('#items').val();
	var operations = [];
    $('#operations :checked').each(function() {
    	operations.push($(this).val());
    });
    
    var range_min = $('#range_min').val();
	var range_max = $('#range_max').val();
	var numberOfQuestions = $('#numberOfQuestions').val();
	
	$.ajax(
	{
	  url:'WPGServer', 
	  type:'post',
	  data: {"names": names, "items": items,
		    operations:operations, 
		    "range_min": range_min, "range_max": range_max,
		    "numberOfQuestions": numberOfQuestions},
	  success:function(response)
	  {
	     $('#genQuestions').append(response);
	  }
	});
}