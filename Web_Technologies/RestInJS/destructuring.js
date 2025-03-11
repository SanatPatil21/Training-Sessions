let emp1 = {
    "name": "Prakash",
    "age": 35,
    "salary": 50000,
    "designation": "Developer"
}


let emp2 = ["Prakash",35,50000,"Developer"]
//can set some default values
let { name, age, salary, designation = "Tester" } = emp1;
let [ a_name, a_age, a_salary, a_designation = "Tester" ] = emp2;

console.log("Name: " + a_name);
console.log("Age: " + a_age);
console.log("Salary: " + a_salary);
console.log("Designation: " + a_designation);


let arr1=  [1,2,3]
let arr2=  [4,5,6]
let arr3=  [7,8,9]

let arr = [arr1,arr2,arr3];
let arr_flat = [...arr1,...arr2,...arr3];

console.log(arr);
console.log(arr_flat);




