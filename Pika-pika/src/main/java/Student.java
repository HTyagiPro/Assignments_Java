class Student extends Person {
	private int rollNo;
	private int admsnNo;
	String university;
	String levelEdu;
	public Student() {	}
	public Student(int ssn, String name, int age, int rollNo, int admsnNo, String university, String levelEdu) {
		super(ssn, name, age);
		this.rollNo = rollNo;
		this.admsnNo = admsnNo;
		this.university = university;
		this.levelEdu = levelEdu;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getAdmsnNo() {
		return admsnNo;
	}
	public void setAdmsnNo(int admsnNo) {
		this.admsnNo = admsnNo;
	}
	
	
	
}


class PGStudent extends Student{
	private int experience;
	private String b_course;
	private String m_course;
	private String subject;
	public PGStudent() {	}
	public PGStudent(int ssn, String name, int age, int rollNo, int admsnNo, String university, String levelEdu,
			int experience, String b_course, String m_course, String subject) {
		super(ssn, name, age, rollNo, admsnNo, university, levelEdu);
		this.experience = experience;
		this.b_course = b_course;
		this.m_course = m_course;
		this.subject = subject;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getB_course() {
		return b_course;
	}
	public void setB_course(String b_course) {
		this.b_course = b_course;
	}
	public String getM_course() {
		return m_course;
	}
	public void setM_course(String m_course) {
		this.m_course = m_course;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
