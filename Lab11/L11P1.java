
/*
 *  - demonstrates knowledge and implementation  of priority queue
 *  - takes a file with a list of integers representing priorities
 *  - 0 is a pop operation
 *  - the higher the number the higher the priority
 *  - the numbers are read one by one, if its higher than 0 its added to the queue
 *  - if the number is zero the highest priority number is removed from the queue
 *  - the queue and the popped number are displayed to the user every time a new number is popped
 */

package Lab11;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;

public class L11P1 {
	public static void main(String[] args) {
		// setting up variables
		String fileName = "";	
		PriorityQueue<Integer> priQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter file name: ");
		fileName = scan.next();
		
		// opening file
		try {
			// setting up to open file and scan
			File priorityFile = new File(fileName);
			Scanner scan2 = new Scanner(priorityFile);
			
			// building priority Queue
			while(scan2.hasNextLine()) {
				int currentNum = scan2.nextInt();
				
				// determine what to do with current number
				if(currentNum == 0) {
					// popping highest priority number
					currentNum = priQueue.poll();
					// printing the priority queue and popped number
					System.out.println(currentNum + " popped");
					System.out.println("Priority Queue: " + priQueue);	
				}else {
					// adding number to the queue
					priQueue.add(currentNum);
					
				}
			}
			scan2.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		scan.close();
	}
}

