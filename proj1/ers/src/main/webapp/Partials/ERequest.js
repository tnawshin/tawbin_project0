 
$(document).ready(function() {
	//loadRequestTable();
	var txt = $('#hW').text();
	$('#hW').text(txt + " "+getUrlParameter('username'));
} );

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

function loadRequestTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.responseText){
			var responsej = JSON.parse(xhr.responseText);
			
			$('#requestTbl1').DataTable( {
		        data: responsej,
		        columns: [
		            { data: "type",title:"Type" },
		            { data: "description",title:"Desc" },
		            { data: "subDate",title:"Date Created" },
		            { data: "amount",title:"Amount" },
		            { data: "status" ,title:"Status"},
		            { data: "resolver",title:"Approver" }
		            
		        ]
		    } );
		}
	}
	xhr.open("POST", "elistReqs");
	xhr.send();
}



