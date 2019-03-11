//We will register the body load event to call GetValuesfromStorage to polulate all input field values 
window.onload = function() {
   let form = document.getElementById('formSignup');
   form.addEventListener('load',GetValuesfromStorage());
}
   
function Validate()
{
    let firstName = document.getElementById('txtfirstName');
    let lastName = document.getElementById('txtlastName');
    let middleName = document.getElementById('txtmiddleName');

    if(firstName.value == middleName.value)
    {
        alert("firstname and middlename cannot be the same");
        return false;
    }
    if(middleName.value == lastName.value)
    {
        alert("middlename and lastname cannot be the same");
        return false;
    }

    if(firstName.value == lastName.value)
    {
        alert("firstname and lastname cannot be the same");
        return false;
    }
    return ValidateCountry();
}

function StoreValues(e)
{
        localStorage.setItem(e.id,e.value);
}

function storeGender(e)
{
    localStorage.setItem('genderkey', e.value); 
}

function GetValuesfromStorage()
{  
    document.frmSignup.gender.value = localStorage.genderkey;  

    let keys = Object.keys(localStorage); //Gets all keys in local Storage
    let values = Object.values(localStorage); //Gets all Values in local Storage
    if(keys!=undefined && keys.length>0)
    {
       for(var i= 0; i<keys.length;i++)
       {
           if(document.getElementById(keys[i])!=null && document.getElementById(keys[i])!=undefined)
           {
              document.getElementById(keys[i]).value = values[i];
           }
       }
    }
}
function ValidateCountry(){
    var country = document.getElementById("txtcountry");
    if(country != 'USA' || country !='US' || country != 'United States' || country != 'United States Of America')
    {
        alert("User has to reside in the United States to Sign Up");
        return false;
    }
    else return true;
}

function signIn(){
    var id = document.getElementById("txtusername").value;
    var password = document.getElementById("txtpsw").value;
    if((id =='Admin' || id =='admin') && (password == 123))
    {
        window.location.href = "game_Project0.html"
    }
    else 
    {
        alert("Username and password is not valid. Please enter a correct username and password");
        return false;
        
    }
}

