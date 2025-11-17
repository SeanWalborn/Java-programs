// Node class for problem 2
package Lab4;

public class Node2 {
	// variables used by class
	private Student student;
	private Node2 prev;
	private Node2 next;
	
	// constructor
	public Node2(Student s) {
		this.student = s;
		this.prev = null;
		this.next = null;
	}
	
	// setters
	public void setData(Student s) { this.student = s; }
	public void setPrev(Node2 prev) { this.prev = prev; }
	public void setNext(Node2 next) { this.next = next; }
	
	// getters
	public Student getStudent() { return student; }
	public Node2 getPrev() { return prev; }
	public Node2 getNext() { return next; }
}
