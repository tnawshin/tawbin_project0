// function onSubmit()
// {
//     alert('You have submitted the form successfull!');
// }
//comments
/*dataTypes:
number, string, boolean, object, undefined, NaN
*/
//Variables
/*function func1(){
  alert("x"+x);
}
var y=func1();
alert("y "+y);*/
//var x;
//alert(typeof(x));
//x='$'; //global variables
// y=5.00;
// z="Hello World!!"
// alert(x+y+z);
// alert(z+(x+y));
//alert(typeof(λ));//Infinity/0))//x));//10/'abc');
//truthy and falsy
falsy= false,0, undefined, NaN, null, ""
alert(0 =="");

// Scope- Global, Local

//test(10);// Hoisting - function call is made even before declaration
 
/*var funcResult=function test(a)({
   console.log(a);
}// function expressions
funcResult=funcResult(funcResult(10));
*/

//console.log(typeof(function ts(){}));
/*(function test(a){
    console.log(a);
 })(10);// IIFE
*/
 // Call back function****
/*function Agreement(policyAcceptance, yes, no){
    debugger;
     if(confirm(policyAcceptance)){
         yes();
     }
     else
        no();
 }
 function ShowOk()
 {
     alert('Policy is accepted');
 }
 function ShowCancel()
 {
     alert('Policy is denied');
 }
 Agreement("Do you agree to our policy",ShowOk,ShowCancel);*/

 //default param
/* var resultfunc=function add(a,b,c=10)
 {
     return a+b+c;
 }
 console.log(resultfunc(10,3));*/
/*

//Closure
 function Outer() {
     var outerData="outerData";
     function inner() {
         alert(outerData);
     }
   // inner();
   return inner;
 }
// alert(outerData); //not accessible because of scope
var funcCall=Outer();
*/

//closure function
var add=function()  //anonymous function
{
  debugger;
  var counter=0;
  return function(){
    counter+=1;
    return counter;
  }
};
console.log(add());
console.log(add());

//Arrow function in IIFE***
(()=>alert('Hi'))();
var resultExp=(a,b)=>(a*b);
console.log(resultExp(2,3));
console.log(((a,b)=>a*b)(5,3));  //arrow functions

//charAt method
return 'cat'.charAt(1); // returns "a"

//strcmp() function for comparing strings
//similar result can be achieved using the localeCompare() method inherited by String instances
//A String object can always be converted to its primitive counterpart with the valueOf() method.

function returnValue(){
  return 'Hello World';
}
var funcItself = returnValue();  //if the () is missing after the function then it will print the entire function as output instead of 'Hello World'
alert(funcItself);


(function varvslet(){

  //let block scope - anything that is inside the {}

   //doing var function scope**
  console.log('before declaration '+index);  //var is not accesible before 
  for (var index = 0; index < 5; index++) {
    console.log('after initialization '+index);
  }
  //for local variable, var would allow access and it will increment again becoz the loop is still accesible. 
  //but if we use "let" instaed of "var" then this line would be "undefined"
  console.log('outside for loop within a function '+index); 
console.log('outside function '+index);

//------------------Arrays----------------
//'use strict' - variables has to have a data type when declaring like let or var
'use strict'
let x=[];    //empty array
x=[1,2,3,4,'Pushpinder',null, false]
for (let index = 0; index < x.length; index++) {
  console.log(x[index]);
}
x.array.forEach(function(e) {   //forEach is more efficient than for loop
  console.log(e);
});

//Type Coersion/Conversion
var i=10;j='10'
console.log(i==j)  //this is called "equality"
console.log(i===j) //this is called "strict equality"

var i=10;j='Hello'
j=Number(j);
console.log(j);

//ONLY Fasle when it is compared with empty strong or NaN******

//**********---------------Objects----------------------***********
var obj={}  //empty object
obj={
  name:'Pushpinder Kaur',   //the key/value pair is called the "JavaScript object notation" NOT JSON
  Profession: 'Full Stack Consultant',
  sayDetails:function(){
    return obj.name+' - ' +obj.Profession;  //this.name+'_'+this.profession;
  }
}
obj.height = '177'
obj.color = 'Brown'
obj['Company'] = 'Revature'
console.log(obj);
console.log(obj.name+ ' ' + obj['height'] + ' ' + obj['Company']);
console.log(obj.sayDetails()+ ' ' + obj['height'] + ' ' + obj['Company']);

var obj2={
  course: 'Java',
  Duration: '10 weeks',
  sayDetails2: obj.sayDetails   //allocating the function sayDetails from previous object to this object
}
obj2.sayDetails2();  // doesn't output anything unless changed to obj.name etc...
console.log(obj2.sayDetails2());


//constructors in ES5******
//Person is a parent object here
function Person(name, profession, city){
  this.name=name;
  this.profession=profession;
  this.city=city;
  this.sayDetails=function(){
    console.log(name+' '+profession+' '+city)
  }
}

let objPushpinder=new Person('Pushpinder', 'Full Stack Consultant', "New York");
objPushpinder.sayDetails();

//Inheritence
//Student is a child object here
function Student(name, age, city, school){
  this.school=school;
  this.age=age;
  this._proto_=new Person(name,city);  //built in property
}

let objStudent=new Student('Brandon',45,'whatever', 'CUNY');
objStudent.sayDetails();


//Class, Objects, and Inhetience in ES6 --------*************
class PersonClass{
  constructor(name,age,city){
      this.name=name;
      this.age=age;
      this.city=city;
  }
  sayDetails(){
      console.log(this.name+'-'+this.city)
  }
}

class StudentClass extends PersonClass{
  constructor(name,age,city,fingers){
      super(name,age,city);

      this.fingers=fingers;
  }
}
let student=new StudentClass('Stephen',89,'Bazinga',12);
student.sayDetails();

//DOM manupulation
//****local storage and session storage****
