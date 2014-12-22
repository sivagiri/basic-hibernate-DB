


getDesignationTypes = function(event) {
	
    $.ajax({
        url: 'deptsfromdb.action',
        type: 'get',
        data: {selecteddepartment: event.target.value},
        success: function(response) {
            var select = $('#designation').empty();
            $.each(response, function(index, value) {
            	console.log('response', value);
                $('<option value=' + value.desig_id + '>' + value.designationname + '</option>').appendTo(select);
            });
        },
        datatype: 'json'
    });
};


function resetValues() {
	$('#designation').empty();
	$('#designation').append(new Option('Please select', '', true, true));
	$('#designation').attr("disabled", "disabled");
}


$('#departments').change(getDesignationTypes);
