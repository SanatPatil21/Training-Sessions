// var a = 0;
//This varaible is currently globally accessible, but we want to keep it private only for this function
//Closure is a way to retain the value of a varible inside a function


//This will create the function as well as execute it
var increment = function () {
    var a = 0;
    var plus = function () {
        a = a + 1;
        console.log(a);
    }
    return plus;
}();

/* 
function incr(){
    var a =0;
    var plus = function (){
        a=a+1;
        console.log(a);
    }
    return plus;
}
*/


increment()
increment()
increment()
increment()
increment()
increment()
increment()
increment()


