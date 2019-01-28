script type="text/javascript">

var defaultActiveLettersTableBody = ">";
var defaultInactiveLettersTableBody = ">";

$( document ).ready( function() {
	if( document.getElementById("activeLettersBody") !== null )
		defaultActiveLettersTableBody = defaultActiveLettersTableBody + document.getElementById ("activeLettersBody").innerHTML;	
	if( document.getElementById("inactiveLettersBody") !== null)
		defaultInactiveLettersTableBody = defaultInactiveLettersTableBody + document.getElementById ("inactiveLettersBody").innerHTML;
});

       $(document).on('keyup','#searchID',function() {
             //   $("#noResults").hide();
             
             if( $("#searchID").val().length != 0) {
            	$("#activeLettersPagination").hide(); 
                $("#activeLettersBody").html("");
                var tbody = ">";
  
                $.ajax({
                       type : "GET",
                       url : '/letterwriter/searchLetters?queryString=' + $("#searchID").val(),
                       success : function(data) {
                              if (data.length > 0) {
                                     $.each(data, function(index, value) {
                                            tbody = tbody + "<tr><td>"
                                                          + value.letterVersionId + "</td>"
                                                          + "<td>" + value.letterName + "</td>"
                                                          + "<td>" + value.letterId+""+value.deptAutoIncrement +"</td>"
                                                          + "<td>" + value.level + "</td>"
                                                          + "<td>" + value.letterAuthor + "</td>"
                                                          + "<td>" + value.letterDescription+ "</td>"
														  + "<td align='left' class='dateInUSA'>" +formatDate(value.letterUpdatedDate) +"</td>"
                                                          + "<td><input type='radio' name='letterIsActive' title='Click to make Inactive' id='"+value.activeLetterId+"' onclick='getActiveValue("+ value.activeLetterId +")'></td>"
                                                          + "<td> <a href='downloadActivePdf?ltrIdValue="+value.letterVersionId+" target='_blank'>Preview</a></td>"      
                                                          +"</tr>"
                                     });
                                     $("#activeLettersBody").html(tbody);
                              } else {
                            		 $("#activeLettersBody").html("<tr><td colspan='9' align='center'> <b> No letter contains '" + $("#searchID").val() + "' string in it's Name, Description, DepartmentID </td></tr>" );
                                   //  $("#noResults").removeClass('hidden');
                                   //  $("#noResults").show();

                              }

                       }
                }); 
                } else {
                	$("#activeLettersBody").html(defaultActiveLettersTableBody);
                	$("#activeLettersPagination").show();
                }
             

           });
       
       $(document).on('keyup','#searchInactiveID',function() {
          // $("#noResults").hide();
          
          if( $("#searchInactiveID").val().length != 0){
        		$("#inactiveLettersPagination").hide();  
           		$("#inactiveLettersBody").html("");
           		var tbody = ">";

           $.ajax({
                  type : "GET",
                  url : '/letterwriter/searchInactiveLetters?queryString=' + $("#searchInactiveID").val(),
                  success : function(data) {
                         if (data.length > 0) {
                                $.each(data, function(index, value) {
                                       tbody = tbody + "<tr><td>"
                                                     + value.inactiveVersionId + "</td>"
                                                     + "<td>" + value.letterName + "</td>"
                                                     + "<td>" + value.letterUpdatedId+""+value.deptAutoIncrement +"</td>"
                                                     + "<td>" + value.level + "</td>"
                                                     + "<td>" + value.letterAuthor + "</td>"
                                                     + "<td>" + value.letterDescription+ "</td>"
                                                     + "<td  align='left' class='dateInUSAFmt'>" + formatDate(value.letterUpdatedDate) + "</td>"
                                                     + "<td> <a href='downloadInactivePdf?ltrIdValue="+value.inactiveVersionId+" target='_blank'>Preview</a></td>"      
                                                     +"</tr>"
                                });
                                $("#inactiveLettersBody").html(tbody);
                         } else {
                        	 $("#inactiveLettersBody").html("<tr><td colspan='9' align='center'> <b> No letter contains '" + $("#searchInactiveID").val() + "' string in it's Name, Description, DepartmentID </td></tr>" );
              //                  $("#noResults").removeClass('hidden');
              //                 $("#noResults").show();

                         }

                  }
           });
          } else {
        	  $("#inactiveLettersBody").html(defaultInactiveLettersTableBody);
        	  $("#inactiveLettersPagination").show();
          }

      });
       
       function formatDate(date) {
    	    var d = new Date(date),
    	        month = '' + (d.getMonth() + 1),
    	        day = '' + d.getDate(),
    	        year = d.getFullYear();
    	  
    	    return month+"/"+day+"/"+year+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
    	}
       
	</script>
