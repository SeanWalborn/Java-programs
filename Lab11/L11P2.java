
/*
 *  - demonstrates knowledge and implementation of priority queue
 *  - collects the number of numbers, and the kth largest, and then each number all from user input
 *  - finds the kth number and displays the number for the user
 *  - all numbers are unique
 *  - time complexity is linear and uses priority queue
 *  - no adjustment made for output formating 1st, 2nd, 3rd etc
 */

package Lab11;

import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;

public class L11P2 {
	public static void main(String[] args) {
		// setting up variables
		int numData = 0;
		int k = 0;
		int kthNum = 0;
		PriorityQueue<Integer> priQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting data num and k
		System.out.print("Enter number of data: ");
		numData = scan.nextInt();
		System.out.print("\nEnter k: ");
		k = scan.nextInt();
		System.out.println();
		
		// collecting data
		for (int i = 0; i < numData; i++) {
			priQueue.add(scan.nextInt());
		}
		
		// moving to Kth largest number
		for (int i = 1; i < k; i++) {
			priQueue.poll();
		}
		
		// removing and displaying kth largest number
		kthNum = priQueue.poll();
		System.out.print("The " + k + "th largest number is: " + kthNum);
			
		scan.close();		
	}
}

