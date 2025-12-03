// Name: Sean Walborn
// Lab 12, Problem 2
// Submission date: 11/30/25

/*
 *  - demonstrates knowledge and implementation  of tree map
 *  - given an array of strings
 *  - counts the frequency of each word
 *  - prints in alphabetical order with frequency
 */

package Lab12;

import java.util.TreeMap;

public class L12P2 {
	 public static void main(String[] args) {
	        // Provided array
		 	String[] words = {"red", "blue", "yellow", "red", "purple", "cyan", "cyan", "cyan"};

	        // Variables used
	        TreeMap<String, Integer> colors = new TreeMap<>();

	        // Count number of each word
	        for (String word : words) {
	            if (colors.containsKey(word)) {
	                colors.put(word, colors.get(word) + 1);
	            } else {
	                colors.put(word, 1);
	            }
	        }
	        
	        // Displaying results
	        for (String key : colors.keySet()) {
	            System.out.println(key + ": " + colors.get(key));
	        }
	    }
}
