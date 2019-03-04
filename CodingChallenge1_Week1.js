function game(){
    let number = document.getElementById('txtnumber').value;

    if(number>0 && number<=1000)
    {
        if(number %3==0 && number%5==0)
        {
            console.log("Fizz Buzz");
            alert("Fizz Buzz");
        }
        else{
            if(number %3==0)
            {
                console.log("Fizz");
                alert("Fizz");
            }
            else{
                if(number%5==0)
                {
                    console.log("Buzz");
                    alert("Buzz");
                }
            }
        }
    }
    else{
        
            console.log("The answer is a string");
            alert("String");
              
    }
}
