package Lab4;

public class Student {
	// variable used by class
	private int studentID;
	private String name;
	private int grade;
	
	// constructor for class
	public Student(int ID, String n, int g) {
		this.studentID = ID;
		this.name = n;
		this.grade = g;
	}
	
	//getters
	public int getStudentID() {
		return studentID;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	
	// setters
	public void setStudentID(int ID) {
		this.studentID = ID;
	}
	public void setName(String n) {
		this.name = n;
	}
	public void setGrade(int g) {
		this.grade = g;
	}
	
	//prints object
	public void printStudent() {
		System.out.printf("%3d %10s %4d \n", studentID, name, grade);
		
	}
}
