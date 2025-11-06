// Name: Sean Walborn
// Lab 1, Problem 3
// Submission date: 09/05/25
package lab1;
import java.util.Scanner;

public class L1P3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// variables used 
		int inputNum;
		
		// collecting input from user
		System.out.println("Enter a integer (n): ");
		inputNum = scanner.nextInt();
		
		// implementing method to generate and print sequence
		expander(inputNum);
		
		scanner.close();
	}
	
	// method expands and prints sequence
	public static void expander(int input) {
		
		// variables used in method
		int backStop = input; 
		int startValue = 1;
		int nextValue = 2;
		int count = 1;
		int sum = 1; 
		
		// prints first number in seq
		System.out.print(startValue);
		
		// loop runs until it reaches input number
		while (count < backStop) {
			// generates next number in sequence
			startValue = startValue * 10 + nextValue;
			
			// prints next num in seq
			System.out.print(" + " + startValue);
			
			// sum values to use at the end
			sum += startValue;
			
			// Increments count thats used to control the loop and nextValue is used to generate next num in the seq
			count++;
			nextValue++;
		}
		
		// prints sum
		System.out.println(" = " + sum);
	}

}

