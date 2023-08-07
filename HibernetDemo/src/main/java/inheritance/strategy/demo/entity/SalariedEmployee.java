package inheritance.strategy.demo.entity;

import javax.persistence.*;
@Entity
//@DiscriminatorValue("Salaried")
public class SalariedEmployee extends EmpSD 
{
	@Column(name="emp_sal")
	private double emp_sal;

	public SalariedEmployee() {
	}

	

	public SalariedEmployee(int emp_id, String emp_name, double emp_sal) {
		super(emp_id, emp_name);
		this.emp_sal = emp_sal;
	}



	public double getSalary() {
		return emp_sal;
	}

	public void setSalary(double emp_sal) {
		this.emp_sal = emp_sal;
	}



	@Override
	public String toString() {
		return "Salaried Employee-:\nEmployee Salary: " + emp_sal + "\n-*-*-*-*-*-*-*-*-*-*-*-*-*-\n";
	}
	
	

}
