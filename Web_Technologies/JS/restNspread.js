/** 
function add(a,b){
    console.log(a+b);
}
function add(a,b,c){
    console.log(a+b+c);
}

add(10,20);
add(10,20,30);
*/
//Multiple parameters to single ARRAY
function add(...a){
	var res=0;
	for(var i=0;i<a.length;i++){
		res=res+a[i];
	}
	console.log("Res: "+res);
}
add(10,20)
add(10,20,30,40)

console.log("-----------------");

var emp=["Rajesh",32,50000,"Developer"];
function display(name,age,salary,desg){
    console.log("Name: "+name);
    console.log("Age: "+age);
    console.log("Salary: "+salary);
    console.log("Desgination: "+desg);
}
//Single ARRAY to Multiple parameters
display(...emp);