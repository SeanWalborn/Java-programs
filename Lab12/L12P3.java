// Name: Sean Walborn
// Lab 12, Problem 3
// Submission date: 11/30/25

/*
 *  - demonstrates knowledge and implementation  of tree set and listg
 *  - given an array of integers
 *  - main is provided
 *  - finds longest consecutive numbers - completed helper method
 *  - prints results to user
 */
package Lab12;

import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class L12P3 {
	public static void main(String[] args) {
		int[] num1 = {4, 10, 11, 20, 3, 2, 88, 1};
		List<Integer> result1 = findLongestConsecutiveSequence(num1);
		int length1 = result1.size();
		System.out.println("\nnum1: " + Arrays.toString(num1));
		System.out.println("Length: " + length1);
		System.out.println("Longest consecutive sequence: " + result1);
		int[] num2 = {3, 5, 10, 22, 55, 30, 9};
		List<Integer> result2 = findLongestConsecutiveSequence(num2);
		int length2 = result2.size();
		System.out.println("\nnum2: " + Arrays.toString(num2));
		System.out.println("Length: " + length2);
		System.out.println("Longest consecutive sequence: " + result2);
		int[] num3 = {3, 4, 10, 7, 33, 21, 11, 32, 50};
		List<Integer> result3 = findLongestConsecutiveSequence(num3);
		int length3 = result3.size();
		System.out.println("\nnum3: " + Arrays.toString(num3));
		System.out.println("Length: " + length3);
		System.out.println("Longest consecutive sequence: " + result3);
	}
	
	// helper method
	public static List<Integer> findLongestConsecutiveSequence(int[] nums) {
	    // Variables
		List<Integer> longest = new ArrayList<>();
	    List<Integer> current = new ArrayList<>();
	    Integer prev = null;
		
		// puts array in treeSet - sorted/ no duplicates
	    TreeSet<Integer> set = new TreeSet<>();
	    for (int n : nums) {
	        set.add(n);
	    }

	    // loops through the sorted TreeSet
	    for (Integer num : set) {
	        if (prev == null || num != prev + 1) {
	            // Start a new sequence
	            current = new ArrayList<>();
	        }
	        current.add(num);

	        // Update longest sequence if current is larger
	        if (current.size() > longest.size()) {
	            longest = new ArrayList<>(current);
	        }

	        prev = num;
	    }

	    return longest;
	}
}
