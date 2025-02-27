function display(obj){
    console.log("Name: "+obj.name)
    console.log("Age: "+obj.age);
    console.log("Salary: "+obj.salary);
    console.log("Desgination: "+obj.designation);
    console.log("------------------");   
}
console.log("<--------- Using Object as a Constructor ------->");
var emp1 = new Object();
emp1.name = "John";
emp1.age = 30;
emp1.salary = 50000;
emp1.designation = "Developer";

display(emp1);


console.log("<--------- Using function as a Constructor ------->");
function Employee(name,age,salary,designation){
    this.name = name;
    this.age = age;
    this.salary = salary;
    this.designation = designation;
}
var emp2 = new Employee("Mark", 40, 60000, "Manager");
display(emp2);

console.log("<--------- Using JSON as a Constructor ------->");
var emp4={
    "name":"Raj",
    "age":50,
    "salary":70000,
    "designation":"Tester"
}
display(emp4);

console.log("<--------- Using ES6 Classes ------->");
class Employee2{
    constructor(name,age,salary,designation){
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }
    display(){
        console.log("Name: "+this.name)
        console.log("Age: "+this.age);
        console.log("Salary: "+this.salary);
        console.log("Desgination: "+this.designation);
        console.log("------------------");   
    }
}

var emp3 = new Employee2("Mahesh", 50, 70000, "Tester");
emp3.display();