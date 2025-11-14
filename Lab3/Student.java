package Lab3;

public class Student implements Comparable <Student> {
	// variable used by class
	private int studentID;
	private String name;
	private int score;
	
	// constructor for class
	public Student(int studentID, String name, int score) {
		this.studentID = studentID;
		this.name = name;
		this.score = score;
	}
	
	//getters
	public int getStudentID() {
		return studentID;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	// setters
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	// setting up so collection can sort by studentID
	@Override
	public int compareTo(Student other) {
		// sorting by student ID
		return Integer.compare(this.studentID, other.studentID);
	}
}
