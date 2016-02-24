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

function checkAnswers(){
	
	var answers = [];
	var numberOfQuestions = $('#numberOfQuestions').val();
	for (i = 1; i <= numberOfQuestions; i++) { 
	    answers.push($('#question' + i).val());
	}
	
	$.ajax(
	{
	  url:'WPGServer', 
	  type:'get',
	  data: {answers:answers},
	  success:function(response)
	  {
	     $('#genResults').append(response);
	  }
	});
}