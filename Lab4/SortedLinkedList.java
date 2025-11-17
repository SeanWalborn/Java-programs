package Lab4;

public class SortedLinkedList {
	private Node1 head; // Start of the list
	
	public void add(int data) {// sorting nod
		Node1 newNode = new Node1(data); // creating node
		
		if (head == null) {  // inserting first node
			head = newNode;
			return;
		}
		else if(data < head.getData()) { // add node in front if smallest
			newNode.setNext(head);
			head = newNode;
			return;
		}
		
		else {
			// finding middle spot for node 
			Node1 current = head.getNext();
			Node1 previous = head;
			
			while (current != null) {
				if (newNode.getData() < current.getData()) {
					newNode.setNext(current);
					previous.setNext(newNode);
					return;
				}
				previous = current;
				current = current.getNext();
			}
			// adds node at the end if it was never added
			previous.setNext(newNode);
			
		}

	}
	
	
	// print all elements
	public void printList() { 
		Node1 current = head;
		while (current != null) {
			System.out.print(current.getData() + " → ");
			current = current.getNext();
		}
		System.out.println("null");
	}

}
