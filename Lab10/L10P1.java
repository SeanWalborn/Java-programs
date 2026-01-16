
/*
 *  - demonstrates knowledge and implementation  of max heap
 *  - numbers are collected for a user one at a time and added to a max heap
 *  - the new adjusted max heap is printed to the user every time a number is added
 *  - entering 0 end the program
 *  - a static array of 100 is used for the max heap
 *  - all input must be greater than or equal to zero
 */

package Lab10;

import java.util.Scanner;


public class L10P1 {
	 
	
	public static void main(String[] args) {
		// variable
		int input;
		int count  = 0; // used for formating numbers and adding to array
		final int SIZE = 100; 
		int[] maxHeapArr = new int[SIZE]; // array for storing max heap
		
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		
		// loop that runs until program is ended
		while(true) {
			
			// collecting user input
			System.out.print("Enter a number " + (count + 1) + ": ");
			input = scan.nextInt();
			
			// checks if program runs
			if (input == 0) {
				scan.close();
				return;
			}
			
			// adds number to heap
			maxHeapArr[count] = input;
			count ++;
			
			// sorts into max heap
			sortMaxHeap(maxHeapArr, count);
			
			// displays heap
			for (int i = 0; i < count; i++) {
				System.out.print(maxHeapArr[i] + " ");
			}
			System.out.println();
			
			
		}
		
	}
	
	// helper Methods
	// sorts a max heap
	public static void sortMaxHeap(int[] heap, int length) {
		// local variables
		int temp = 0;
		
		// if only one index in array is used
		if (length == 1) {
			return;
		}
		
		// starts from end of array and compares all children to parent
		for(int i = length - 1; i > 0; i--) {
								
			// compares child and parent swaps if parent is smaller
			if (heap[(i - 1)/2] < heap[i]) {
				temp = heap[(i - 1)/2];
				heap[(i - 1)/2] = heap[i];
				heap[i] = temp;
			}
		}
	}
	
	//check if the max heap is sorted  - used for troubleshooting
	public static boolean checkMaxHeap(int[] heap, int length) {
		boolean sorted = true; 
			
			// starts from end of array and compares all children to parent
			for(int i = length - 1; i > 0; i--) {
				int child = heap[i];
				int parent = heap[(i - 1)/2];
				
				// compares child and parent 
				if (parent < child) {
					sorted = false;
				}
			}
		
		return sorted;
	}
	
	
}

