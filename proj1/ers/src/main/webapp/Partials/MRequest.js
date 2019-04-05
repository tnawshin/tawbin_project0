function loadRequestTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.responseText){
			var responsej = JSON.parse(xhr.responseText);
			//$('#goToLogin').on('click', loadLoginView);
			
			var table = $('#requestTbl2').DataTable( {
		        data: responsej,
		        columns: [
		            { data: "type",title:"Type" },
		            { data: "description",title:"Desc" },
		            { data: "subDate",title:"Date Created" },
		            { data: "amount",title:"Amount" },
		            { data: "status" ,title:"Status"},
		            { data: "author",title:"Author" },
		            {data: "reqID",  "render": function (data) {
                        return "<a class='btn btn-default btn-sm' onclick=Update(" + data + ",'A')>Approve</a><a class='btn btn-danger btn-sm 'style='margin-left:5px' onclick=Update(" + data +",'D')><i class='fa fa-trash'></i> Deny </a>"

                    }}
		            
		        ],
		        buttons: [
		            {
		                extend: 'selectedSingle',
		                text: 'Log selected data',
		                action: function ( e, dt, button, config ) {
		                    console.log( dt.row( { selected: true } ).data() );
		                }
		            }
		        ]
		    } );
			
		}
	}
	xhr.open("POST", "mlistReqs");
	xhr.send();
}



