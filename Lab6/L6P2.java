// Name: Sean Walborn
// Lab 6, Problem 2
// Submission date: 10/04/25

package Lab6;

import java.util.Scanner;
import java.util.Stack;

public class L6P2 {
	
	public static void main(String[] args) {
		// Variables used
		String infixExpression = " ";
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
	
		// loop to run until user ends
		while (!infixExpression.equalsIgnoreCase("n")) {
			// local variables used
			Stack <String> operand = new Stack<>();
			
			// collecting Expression
			System.out.print("Enter an infix expression (or 'n' or 'N' to exit): ");
			infixExpression = scan.next();
			
			//check if program runs
			if (infixExpression.equalsIgnoreCase("n")) {
				System.out.println("Program exited.");
				break;
			}
			
			// loop through stack decide what to with each char 
			for (int i = 0; i < infixExpression.length(); i++) {
				
				// Local variables
				char currentChar = infixExpression.charAt(i); 
				
				// determine how to handle each char - print or push to stack
				if (!isOperator(currentChar)) {
					System.out.print(currentChar + " ");
				}else if (operand.empty() || currentChar == '(') {
					operand.push(String.valueOf(currentChar));
				}
				else { 
					// checks precedence
					boolean highPrec = isHighPrec(currentChar, operand.peek().charAt(0)) ;
								
					// action taken on operand
					if (highPrec || currentChar == ')') {
						while (!operand.empty() && operand.peek().charAt(0) != '(') {
							System.out.print(operand.pop() + " ");
						}
					}
					
					// preventing ( and ) from printing
					if (!operand.empty() && operand.peek().charAt(0) == '(' && currentChar == ')') {
						operand.pop();
					}
					else {
						operand.push(String.valueOf(currentChar));
					}
						
				} 	
			}
			
			// prints out remaining stack at end of string evaluation
			while(!operand.empty()) {
				System.out.print(operand.pop());
			}
			System.out.println();
		} 
		
		scan.close();
	} 
	
	
	// helper methods
	// checks if char is an operator
	public static boolean isOperator(char c) {
		boolean result = false;
		if (c == '/' || c == '*' || c == '-' || c == '+' || c == '(' || c == ')') {
			result = true;
		}
		return result;
	}
	
	// checks if top of stack is higher precedence
	public static boolean isHighPrec(char inputChar, char stackChar) {
		boolean highPrecedence = false;
		
		if (inputChar == stackChar || stackChar == '/' || stackChar == '*') {
			highPrecedence = true;
		}else {
			switch (stackChar) {
				case '+':
					if(inputChar == '-') {
						highPrecedence = true;
					}
					break;
				case '-':
					if(inputChar == '+') {
						highPrecedence = true;
					}
					break;
			}	
		}
		return highPrecedence;
	} 
}
