

public class Person {
	
	private int ssn;
	private String name;
	private int age;
	
	
	public Person(int ssn, String name, int age) {
		this.ssn = ssn;
		this.name = name;
		this.age = this.validateAge(age);
		
		
	}


	public int validateAge(int age) {
		if (age >=18)
			return age;
		else
			throw new InvalidAgeException("Invalid age as per labour law");
	}

	public Person() {
		
	}




	public int getSsn() {
		return ssn;
	}





	public void setSsn(int ssn) {
		this.ssn = ssn;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public int getAge() {
		return this.validateAge(age);
	}





	public void setAge(int age) {
		this.age = this.validateAge(age);
	}

}
