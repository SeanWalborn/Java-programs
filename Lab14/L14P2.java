// Name: Sean Walborn
// Lab 14, Problem 2
// Submission date: 12/7/25

package Lab14;

import java.util.Scanner;
import java.util.HashMap;

public class L14P2 {
	 public static void main(String[] args) {
		 // Variables
		 String input1;
		 String input2;
		 HashMap<Character, Integer> word = new HashMap<>();
		 HashMap<Character, Integer> word2 = new HashMap<>();
		 
		 // setting up scanner
		 Scanner scan = new Scanner(System.in);
		 
		 // Displaying title
		 System.out.println("Anagram Checker (type 'exit' to stop)\n");
		 
		 // runs until user enters exit
		 while (true) {
			 // collecting first input
			 System.out.print("Enter string 1: ");
			 input1 = scan.next();
			 
			 // checking if programs runs
			 if (input1.equals("exit")) {
				 System.out.println("Program exited.");
				 scan.close();
				 return;
			 }
			 
			 // collecting second input
			 System.out.print("Enter string 2: ");
			 input2 = scan.next();
			 
			// checking if programs continues to run
			 if (input2.equals("exit")) {
				 System.out.println("Program exited.");
				 scan.close();
				 return;
			 }
			 
			 // splitting first word into char and pushing to hash map
			 for (int i = 0; i < input1.length(); i++) {
				 	char c = input1.charAt(i);
				 			
				 	// adds or increments count if char is already present 
				    word.put(c, word.getOrDefault(c, 0) + 1);
			}
			 
			 // splitting second work
			 for (int i = 0; i < input2.length(); i++) {
				 // gets current char	
				 char c = input2.charAt(i);
				 			
				 // adds char or increments count if char is already present 
				 word2.put(c, word2.getOrDefault(c, 0) + 1);
			}
			 
			 
			 // displaying results
			 if(word.equals(word2)) {
				 System.out.println("\"" + input1 + "\" and \"" + input2 + "\" are anagrams\n");
			 }else {
				 System.out.println("\"" + input1 + "\" and \"" + input2 + "\" are NOT anagrams\n");
			 }
			 
			 // setting up for next loop
			 word.clear();
			 word2.clear();
			 
		 }
	 }
}
