var Employee = /** @class */ (function () {
    function Employee(e_id, ename, salary) {
        this.e_id = e_id;
        this.salary = salary;
        this.ename = ename;
    }
    Employee.prototype.getE_id = function () {
        return this.e_id;
    };
    Employee.prototype.getSalary = function () {
        return this.salary;
    };
    Employee.prototype.getEname = function () {
        return this.ename;
    };
    return Employee;
}());
var emp = new Employee(7007, "James Bond", 62500);
console.log(emp.getE_id());
console.log(emp.getEname());
console.log(emp.getSalary());
