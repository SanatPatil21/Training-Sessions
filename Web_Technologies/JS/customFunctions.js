function add(a,b){
	console.log("Addition: "+(a+b));
}


    var sub = function(a,b){
        console.log("Subtraction: "+(a-b));
    }


var mul = (a,b)=>console.log("Multiplication: "+(a*b));

var div = new Function("a","b","console.log('Division: '+(a/b))");

add(10,20);
sub(10,20);
mul(10,20);
div(10,20);
