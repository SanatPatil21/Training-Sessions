var a = 10;
console.log(a);
a=function(){
    console.log("Hello");
}
console.log(a)
a();

console.log("_____________________");



function abc(){
    console.log("From function abc()");
}

function xyz(){
    console.log("From function xyz");
    return abc;
}

function demo1(func_passed){
    console.log("<<<<<<<<<<From function demo1()>>>>>>>>>>");
    func_passed(); 
}

function demo2(){
    console.log("<<<<<<<<<<From function demo2()>>>>>>>>>>");
    return xyz;
}

demo1(abc);
demo1(xyz);

console.log("------------------------");

var res1=demo2();
var res2=res1();
res2();

console.log("------------------------");

demo2()
demo2()();
demo2()()();

