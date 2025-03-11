class Emp
{
    name:string;
    age:number
    constructor(name:string,age:number)
    {
        this.name=name;
        this.age=age;
    }

    display()
    {
        console.log("Name: "+this.name);
        console.log("Age: "+this.age);
    }
}

class Clerk extends Emp{
    salary:number;
    designation:string;
    constructor(name:string,age:number,salary:number,designation:string){
        
        super(name,age);
        this.salary=salary;
        this.designation=designation
    }

    displayAll(){
        this.display();
        console.log("Salary: "+this.salary);
        console.log("Designation: "+this.designation+"\n");    
    }
}

var e1=new Clerk("Ravi",25,30000,"Tester");
var e2=new Clerk("Rajesh",35,45000,"Developer");
e1.displayAll();
e2.displayAll();
// e1.display();

console.log("-----------------");

class Person{
    name:string;
    constructor(name){
        console.log("Start of Constructor");
        this.name=name;
        setTimeout(()=>{
            console.log("From Within Constructor: "+this.name,);         
        },5000)
        
    }
}