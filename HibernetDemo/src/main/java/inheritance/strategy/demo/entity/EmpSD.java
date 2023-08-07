package inheritance.strategy.demo.entity;

import javax.persistence.*;

@Entity
//@DiscriminatorColumn(name = "emp_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class EmpSD {
		@Id
		private int emp_id;
		private String emp_name;
		
		
		
		public EmpSD(int emp_id, String emp_name) {
			this.emp_id = emp_id;
			this.emp_name = emp_name;
		}


		public EmpSD() {
		}


	

		public int getEmp_id() {
			return emp_id;
		}


		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}


		public String getEmp_name() {
			return emp_name;
		}


		public void setEmp_name(String emp_name) {
			this.emp_name = emp_name;
		}


		@Override
		public String toString() {
			return "Employee Salary Details:-\n-------------------------------------\nEmployee ID: " + emp_id + "\nEmployee Name: " + emp_name + "\n-------------------------------------\n";
		}


		
		
		
}
