//We will register the body load event to call GetValuesfromStorage to polulate all input field values 
window.onload = function () {
    let form = document.getElementById('formSignup');
    if(form)
    form.addEventListener('load', GetValuesfromStorage());
}

function Validate() {
    let firstName = document.getElementById('txtfirstName').value;
    let lastName = document.getElementById('txtlastName').value;
    let middleName = document.getElementById('txtmiddleName').value;
    var country = document.getElementById("txtcountry").value;

//validate the properties
    if (firstName == lastName) {
        alert("firstname and lastname cannot be the same");
        return false;
    }
    else if (!(country == 'USA' || country == 'US' || country == 'United States' || country == 'United States Of America') ){
        alert("User has to reside in the United States to Sign Up");
        return false;
    }
    else
    {
        alert("Thank you for signing up with Revature!");
        return true;
    }
}

function StoreValues(e) {
    localStorage.setItem(e.id, e.value);
}

function storeGender(e) {
    localStorage.setItem('genderkey', e.value);
}

function GetValuesfromStorage() {
    document.frmSignup.gender.value = localStorage.genderkey;

    let keys = Object.keys(localStorage); //Gets all keys in local Storage
    let values = Object.values(localStorage); //Gets all Values in local Storage
    if (keys != undefined && keys.length > 0) {
        for (var i = 0; i < keys.length; i++) {
            if (document.getElementById(keys[i]) != null && document.getElementById(keys[i]) != undefined) {
                document.getElementById(keys[i]).value = values[i];
            }
        }
    }
}
function ValidateCountry() {
    

}
function validateContact()
{
    let firstName = document.getElementById('txtfName');
    let lastName = document.getElementById('txtlName');
    let txtemail = document.getElementById('txtemail');
    let txtquery = document.getElementById('query');

    if (firstName.value == lastName.value) {
        alert("firstname and lastname cannot be the same");
        return false;
    }
    else if(txtemail.value == "" || txtquery.value=="" || txtfName.value == "" || txtlName.value == "")
    {
        alert("Please fill out all the required fields");
        return false;
    }
    else 
    {
        alert("Thank you for submitting your query. We will contact you within next 24 hours.");
        window.location.href = "project0.html"
    }
    return true;
}

function signIn() {
    var id = document.getElementById("txtusername").value;
    var password = document.getElementById("txtpsw").value;
    if ((id == 'Admin' || id == 'admin') && (password == 123)) {
        alert("Successful Sign In! Taking you to the game page");
        window.location.href = "game_Project0.html"
    }
    else {
        alert("Username and password is not valid. Please enter a correct username and password");
        return false;

    }
}

