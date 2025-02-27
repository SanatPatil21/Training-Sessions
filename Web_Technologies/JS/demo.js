var a = 10;
var b = "10";
console.log(a==b);   
console.log(a===b);  


var arr = [11,"hi",new Date(),3.4, false];
for(var i =0; i<arr.length; i++){
    console.log(arr[i]);
}
console.log("------------");
for(var i in arr){
    console.log(i+" : "+arr[i]);
}
console.log("------------");
for(var i of arr){
    console.log(i);
}
