package Lab4;

public class SortedDoublyLinkedList {
	private Node2 tail;
	private Node2 head;
	
	// method to add variable in sorted manner
	public void add(Student s) {

		Node2 newNode = new Node2(s); // creating node
		
		if (head == null) {  // inserting first node if list is empty
			head = newNode;
			tail = newNode;
			return;
		}
		else if(s.getStudentID() < head.getStudent().getStudentID()) { // add node in front if smallest
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
			return;
		}
		
		else {
			// finding middle spot for node 
			Node2 current = head.getNext();
			Node2 previous = head;
			
			while (current != null) {
				if (newNode.getStudent().getStudentID() < current.getStudent().getStudentID()) {
					newNode.setNext(current);
					newNode.setPrev(previous);
					previous.setNext(newNode);
					current.setPrev(newNode);
					return;
				}
				previous = current;
				current = current.getNext();
			}
			// adds node at the end if it was never added
			previous.setNext(newNode);
			newNode.setPrev(previous);
			tail = newNode;
			
		}

	}
	
	
	// method to add node to end of list
	public void append(Student s) {
		Node2 newNode = new Node2(s);
		if (head == null) {
			head = tail = newNode;
		}
		else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
	}
	
	// print all elements
	public void printList() { 
		Node2 current = head;
		while (current != null) {
			current.getStudent().printStudent();
			current = current.getNext();
		}
	}
	
	public void printListReverse() {
		Node2 current = tail;
		while (current != null) {
			current.getStudent().printStudent();
			current = current.getPrev();
		}
	}

}
