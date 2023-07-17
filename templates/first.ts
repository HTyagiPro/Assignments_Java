
class Employee  {
	private  e_id:number;
	private salary:number;
	private ename:string;
	
	
	
	
	
	
	public constructor(e_id:number, ename:string, salary:number) {
		this.e_id = e_id;
		this.salary = salary;
		this.ename = ename;
	}

	

	public getE_id() :number{
		return this.e_id;
	}
	
	public getSalary():number {
		return this.salary;
	}
	
	public getEname() :string{
		return this.ename;
	}
		
}

let emp = new Employee(7007, "James Bond", 62500);
console.log(emp.getE_id());
console.log(emp.getEname());
console.log(emp.getSalary());