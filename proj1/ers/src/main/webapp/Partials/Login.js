window.onload = function(){
	console.log('app loading..');
	$('#login').on('click', loginUser);
	
}

function validateStrings(str){
	if(str == null || str == '') return false;
	else return true;
}
function loginUser(){
		var name = $('#username').val();
		var pw = $('#password').val();
		
		if(validateStrings(name) || validateStrings(pw)){
		var Users = {
				uname: name, 
				password: pw
		};
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			//get response body and console.log it 
			if(xhr.readyState==4 && xhr.status==200){
				var code = xhr.responseText;
				switch(code)
				{
				case "-1":
					$('#lblError').text("Invalid Username !");
					break;
				case "-2":
					$('#lblError').text("Invalid Password !");
					break;
				case "3":
					$('#view').load("ERequest.view",function(responsetxt,status,xhr){
						if(status=="success")
							{
							loadRequestTable();
							}
					});
					
					break;
				case "4":
					$('#view').load("MRequest.view",function(responsetxt,status,xhr){
						if(status=="success")
							{
							loadRequestTable();
							}
					});
					break;
					
				default :
					$('#lblError').text("System Error !");
					break;
				}
				
				
				
			}
			
		}
		xhr.open("POST", "login");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(Users));
		}
		else{
			//user entered null data or otherwise invalid strings. 
			$('#message').html('Please enter valid username and password!');
		}
	}

function AddtoDB()
{
	var type = $('#typeID').val();
	var desc = $('#desc').val();
	var amt = $('#amount').val();
	
	
	var ReimbReq = {
			amount: amt, 
			description: desc,
			typeID:type
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//get response body and console.log it 
		if(xhr.readyState==4 && xhr.status==200){
			$('#message').text("Request Added Successfully !!");
			 $('#desc').val("");
			 $('#amount').val("");
		}
		
	}
	xhr.open("POST", "addReq");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(ReimbReq));
	
	
}

function AddRequest()
{
	$('#view').load("AddRequest.view",function(responsetxt,status,xhr){
		
	});
}

function LoadEmployee()
{
	$('#view').load("ERequest.view",function(responsetxt,status,xhr){
		if(status=="success")
			{
			loadRequestTable();
			}
	});
}
function Signout()
{
	if(confirm("Are you sure you want to logout ?"))
		{
		$('#view').load("login.view",function(responsetxt,status,xhr){
			if(status=="success")
				{
				   window.location.reload(true);
				}
			
		});
		return true;
		}
	else
		{
		 return false;
		}
}

function Update(reqID,mode)
{
	var statusID=5;
	if(mode=="D"){statusID=6;}
	
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$('#view').load("MRequest.view",function(responsetxt,status,xhr){
				if(status=="success")
					{
					loadRequestTable();
					}
			});
			
		}
	}
	xhr.open("POST", "mlistReqs?mode="+mode+"&reqID="+reqID+"&statusID="+statusID); //passing the mode and request id in query string to the servlet
	xhr.send();
	
	
	
	
}