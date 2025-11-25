
// Name: Sean Walborn
// Lab 10, Problem 2
// Submission date: 11/15/25

/*
 *  - demonstrates knowledge and implementation  of max heap
 *  - opens a file from the user and converts each line to an array list
 *  - the first number in each line is the length of the array
 *  - checks if the array is a max heap
 *  - if its not turn it into a max heap
 */

package Lab10;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class L10P2 {
	
	public static void main(String[] args) {
		// variables
		String fileName = "";
			
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter file name: ");
		fileName = scan.next();
		System.out.println();
		
		// open file
		try {
		
			// setting up new scanner and file
			File heapFile = new File(fileName);
			Scanner scan2 = new Scanner(heapFile);
			
			// building array heap and checking it
			while(scan2.hasNextLine()){
				ArrayList <Integer> heap = new ArrayList<>();
				
				// processing each line
				String currentLine = scan2.nextLine();
				
				// stores each line in an array as strings
				String[] parts = currentLine.split(" ");
				
				// saves length of array
				int length = Integer.parseInt(parts[0]);
				
				// moving and converting strings to ints
				for (int i = 1; i <= length; i++) {
					heap.add(Integer.parseInt(parts[i]));
				}
				
				// prints current heap
				for (int i = 0; i < heap.size(); i++) {
				    System.out.print(heap.get(i) + " ");
				}
				System.out.println();
				
				// checking if max of min heap adjust to max heap if neither 
				if (checkMaxHeap(heap)) {
					System.out.println("Max heap\n");
					
				}else if(checkMinHeap(heap)) {
					System.out.println("Min heap\n");
				}else {
					System.out.println("Not a heap. Applying Heapify algorithm");
					createMaxHeap(heap);
					// prints adjusted list
					for (int i = 0; i < heap.size(); i++) {
					    System.out.print (heap.get(i) + " ");
					}	
					System.out.println("\n");
				}
			}
			scan2.close();
			
		}catch(FileNotFoundException e) {
			System.out.print("File Not Found");
			e.printStackTrace();
		}
	
		scan.close();
	}
	
	// helper methods
	//checks if heap is max heap
	public static boolean checkMaxHeap(ArrayList<Integer> heap) {
		boolean sorted = true; 
			
			// starts from end of array and compares all children to parent
			for(int i = heap.size() - 1; i > 0; i--) {
				int child = heap.get(i);
				int parent = heap.get((i - 1)/2);
				
				// compares child and parent 
				if (parent < child) {
					sorted = false;
				}
			}
		
		return sorted;
	}
	
	// checks if heap is min heap
	public static boolean checkMinHeap(ArrayList<Integer> heap ) {
		boolean sorted = true; 
		
		// starts from end of array and compares all children to parent
		for(int i = heap.size() - 1; i > 0; i--) {
			int child = heap.get(i);
			int parent = heap.get((i - 1)/2);
			
			// compares child and parent 
			if (parent > child) {
				sorted = false;
			}
		}
	
		return sorted;
	}
	
	// creates max heap
	public static void createMaxHeap(ArrayList<Integer> heap) {
		// local variables
		int temp = 0;
		
		// if only one index in array is used
		if (heap.size() == 1) {
			return;
		}
		
		while(!checkMaxHeap(heap)) {
		// starts from end of array and compares all children to parent
		for(int i = heap.size() - 1; i > 0; i--) {
								
			// compares child and parent swaps if parent is smaller
			if (heap.get((i - 1)/2) < heap.get(i)) {
				temp = heap.get((i - 1)/2);
				heap.set(((i - 1)/2), heap.get(i));
				heap.set(i, temp);
			}
		}
		}
	}	
	
}
