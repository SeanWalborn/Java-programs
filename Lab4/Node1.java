package Lab4;

public class Node1 {
	// variables
	private int data;
	private Node1 next;
	
	// inserting data and connector
	public Node1(int data) {
		this.data = data;
		this.next = null;
	}
	
	// setters
	public void setData(int data) { this.data = data; }
	public void setNext(Node1 next) { this.next = next; }
	
	// getters
	public int getData() { return this.data; }
	public Node1 getNext() { return this.next; }
}
