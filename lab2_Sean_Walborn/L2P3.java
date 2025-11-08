// Name: Sean Walborn
// Lab 2, Problem 3
// Submission date: 09/07/25

package Lab2;
import java.util.Scanner;

public class L2P3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// variables used to hold input
		String stringInput;
		String reverseString;
		
		// collecting input
		System.out.print("Enter one string: ");
		stringInput = scanner.nextLine();
		 
		// calling method to reverse string
		reverseString = reverseString(stringInput, stringInput.length() - 1 );
		
		//printing original and reversed string
		System.out.println("Original: " + stringInput);
		System.out.println("Reversed: " + reverseString);
		
		
		scanner.close();

	}
	
	public static String reverseString(String originalString, int index) {
		if (index == -1) {
			return "";
		}
		else {
			return(originalString.charAt(index) + "" + reverseString(originalString, index - 1));
		}
		
	}
}
