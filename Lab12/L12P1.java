/*
 *  - demonstrates knowledge and implementation  of tree set
 *  - given an array of integers
 *  - removes duplicates
 *  - prints sorted results in ascending order
 */

package Lab12;

import java.util.TreeSet;

public class L12P1 {
	public static void main(String[] args) {
        // given array
		int[] arr = {4, 6, 6, 3, 2, 7, 8, 9, 2, 2, 3, 1, 1, 7};

        // Using TreeSet to remove duplicates and sort automatically
        TreeSet<Integer> numSet = new TreeSet<>();
        
        for (int num : arr) {
            numSet.add(num);
        }

        // Print the result
        System.out.println("Output: " + numSet);
    }
}

