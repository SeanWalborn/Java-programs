

package Lab3;

import java.util.Arrays;

public class L3P1 {
	public static void main(String[] args) {
		int[] A = {7, 2, 9, 1, 5, 12, 20, 13, 3, 12, 11, 8, 10};
		int[] B = {4, 3, 9, 1, 8, 6, 2};
		int[] C = {90, 88, 11, 22, 66, 200, 67, 85, 34, 1, 4, 5, 6, 100, 23, 20, 33};
		int[] D = {4, 7, 5};
		int median1 = findMedian(A);
		int median2 = findMedian(B);
		int median3 = findMedian(C);
		int median4 = findMedian(D);
		System.out.println("Median1: " + median1);
		System.out.println("Median2: " + median2);
		System.out.println("Median3: " + median3);
		System.out.println("Median4: " + median4);
	}
	
	public static int findMedian(int[] numArr) {
		// Var used in method
		int median = 0;
		int medianIndex = 0;
		
		// sorting the array
		Arrays.sort(numArr);
		
		// finding middle index depending if the array has an even or odd number of elements
		if (numArr.length % 2 == 0) {
	
			for(int i = 0; i < numArr.length; i++) {
				median+= numArr[i];
			}
			median = median / numArr.length;
		}
		else {
			medianIndex = numArr.length / 2;
			median = numArr[medianIndex];
		}
		
		
		// returning the median number
		return median;
		
		
	
		
	}
}

