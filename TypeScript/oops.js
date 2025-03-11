var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Emp = /** @class */ (function () {
    function Emp(name, age) {
        this.name = name;
        this.age = age;
    }
    Emp.prototype.display = function () {
        console.log("Name: " + this.name);
        console.log("Age: " + this.age);
    };
    return Emp;
}());
var Clerk = /** @class */ (function (_super) {
    __extends(Clerk, _super);
    function Clerk(name, age, salary, designation) {
        var _this = _super.call(this, name, age) || this;
        _this.salary = salary;
        _this.designation = designation;
        return _this;
    }
    Clerk.prototype.displayAll = function () {
        this.display();
        console.log("Salary: " + this.salary);
        console.log("Designation: " + this.designation + "\n");
    };
    return Clerk;
}(Emp));
var e1 = new Clerk("Ravi", 25, 30000, "Tester");
var e2 = new Clerk("Rajesh", 35, 45000, "Developer");
e1.displayAll();
e2.displayAll();
// e1.display();
console.log("-----------------");
var A = /** @class */ (function () {
    function A() {
        console.log("A()");
    }
    return A;
}());
var B = /** @class */ (function (_super) {
    __extends(B, _super);
    function B() {
        var _this = this;
        console.log("B()");
        return _this;
    }
    return B;
}(A));
