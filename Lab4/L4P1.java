// Name: Sean Walborn
// Lab 4, Problem 1
// Submission date: 09/29/25

package Lab4;

public class L4P1 {
	public static void main(String[] args)
	{
		int[] A = {4, 6, 5, 8, 2, 0, 1, 7, 3, 9};
		SortedLinkedList list = new SortedLinkedList();
		
		// Create a sorted linked list from the array A	
		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
			System.out.print("Inserting " + A[i] + " : ");
			list.printList();
		}

	}
}



