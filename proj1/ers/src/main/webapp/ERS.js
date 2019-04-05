window.onload = function(){
	console.log('app loading..');
	$('#login').on('click', loginUser);
	//LoadView();
	//LoadHeader();
}


function LoadView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//here is where we  manipulate our response.. whenever we get it 
		if(xhr.readyState==4){
			console.log('response received');
			if(xhr.status==200){
				//success
				//we know that our response will be HTML
				$('#view').html(xhr.responseText);
				
				//ADD EVENT LISTENERS TO OUR HTML 
				//$('#login').on('click', loginUser);
				//$('#goToRegister').on('click', loadRegisterView);
			}
		
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}

function LoadHeader(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//here is where we  manipulate our response.. whenever we get it 
		if(xhr.readyState==4){
			console.log('response received');
			if(xhr.status==200){
				//success
				//we know that our response will be HTML
				$('#head').html(xhr.responseText);
				
				//ADD EVENT LISTENERS TO OUR HTML 
				//$('#login').on('click', loginUser);
				//$('#goToRegister').on('click', loadRegisterView);
			}
		
		}
	}
	xhr.open("GET", "Header.view");
	xhr.send();
}

//load registration view function
function loadRegisterView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.responseText){
			$('#view').html(xhr.responseText);
			$('#goToLogin').on('click', loadLoginView);
			
			//make sure that username is unique before allowing user to submit 
			$('#username').on('blur', validateUser);
			
			//create new user 
			$('#addUser').on('click', addUser);
		}
	}
	xhr.open("GET", "registration.view");
	xhr.send();
}

//for registration page - make sure username is unique
function validateUser(){
	//send request to make sure that username is unique
}

/*
 * Send POST request with user data from regisration page
 */
function addUser(){
	var user = {
			username: $('#username').val(),
			password: $('#password').val(),
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 201){//created
				//go to home page so user can log in with new credentials
			}
			else if (xhr.status > 399){
				//some sort of issue. go to error page
			}
		}
	}
	
	xhr.open("POST", "register");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
}

function validateStrings(str){
	if(str == null || str == '') return false;
	else return true;
}

function loginUser(){
	var name = $('#username').val();
	var pw = $('#password').val();
	
	if(validateStrings(name) || validateStrings(pw)){
	var user = {
			username: name, 
			password: pw
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//get response body and console.log it 
		if(xhr.readyState==4 && xhr.status==200){
			var user = JSON.parse(xhr.responseText);
			console.log(xhr.getAllResponseHeaders());
			if(user == null){
				//not logged in -- tell user about invalid credentials 
				$('#message').html('Sorry! Invalid credentials!');
			}
			else{
				//logged in . do things 
				console.log(user);
				loadHomeView(user);
			}
		}
		
	}
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
	}
	else{
		//user entered null data or otherwise invalid strings. 
		$('#message').html('Please enter valid username and password!');
	}
}


function loadHomeView(user){
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.responseText){
			$('#view').html(xhr.responseText);
			$('#name').html(user.username);
		}
	}
	xhr.open("GET", "index.view");
	xhr.send();
	
}