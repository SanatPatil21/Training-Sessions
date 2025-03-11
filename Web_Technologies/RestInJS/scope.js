//Global variables are not initialized until they are assigned a value


function abc(){
    a=10;
    //Local scope-> Only accessible inside function
    var b = 20;
    //Block Scope
    let c = 10;
    console.log("From inside abc() - a: " + a);
    console.log("From inside abc() - b: " + b);
    console.log("From inside abc() - c: " + b);


}

abc();
console.log("From outside abc() - a: " + a);
//console.log("From outside abc() - b: " + b); //Not accessible
//console.log("From outside abc() - c: " + c); //Not accessible


