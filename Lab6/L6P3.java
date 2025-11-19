// Name: Sean Walborn
// Lab 6, Problem 3
// Submission date: 10/04/25

package Lab6;

import java.util.Scanner;
import java.util.Stack;

public class L6P3 {
	
	public static void main (String[]args) {
		//pseudo code:
		// collect input
		// turn into prefix
		// calculate result
		
		// Variables used
		String infixExpression = " ";
		String output = "";
		int evaluation = 0;
				
		// setting up scanner
		Scanner scan = new Scanner(System.in);
			
		// loop to run until user ends
		while (!infixExpression.equalsIgnoreCase("n")) {
			// local variables used
					
			// collecting Expression
			System.out.print("Enter an infix expression (or 'n' or 'N' to exit): ");
			infixExpression = scan.next();
			
			//check if program runs
			if (infixExpression.equalsIgnoreCase("n")) {
				System.out.println("Program exited.");
				break;
			}
			
			// converting infix to postfix and printing
			output = infixToPostfix(infixExpression);
			for (int i = 0; i < output.length(); i++) {
				System.out.print(output.charAt(i) + " ");
			}
			System.out.println();
		
			// evaluating for result
			evaluation = postfixEval(output);
			System.out.println("Evaluation Result: " + evaluation);
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
	
	//turns infix to post fix
	public static String infixToPostfix (String infix) {
		// Variables used
		String result = "";
		Stack <String> operand = new Stack<>();
	
		// loop through stack decide what to with each char 
		for (int i = 0; i < infix.length(); i++) {
			// Local variables
			char currentChar = infix.charAt(i); 
						
			// determine how to handle each char - concat or push to stack
			if (!isOperator(currentChar)) {
				result = result + String.valueOf(currentChar);
			}else if (operand.empty() || currentChar == '(') {
				operand.push(String.valueOf(currentChar));
			}else { 
				// checks precedence
				boolean highPrec = isHighPrec(currentChar, operand.peek().charAt(0)) ;
											
				// action taken on operand
				if (highPrec || currentChar == ')') {
					while (!operand.empty() && operand.peek().charAt(0) != '(') {
						result = result + operand.pop();
					}
				}
									
				// preventing ( and ) from being added to result
				if (!operand.empty() && operand.peek().charAt(0) == '(' && currentChar == ')') {
					operand.pop();
				}else {
					operand.push(String.valueOf(currentChar));
				}
			} 	
		}
				
		// concats remaining stack at end of string evaluation
		while(!operand.empty()) {
			result = result + operand.pop();
		}
			return result;		 
	}
	
	// evaluates postfix string returns result
	public static int postfixEval(String s) {
		int result = 0; 
		Stack <Integer> operand = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			//local variable to store char
			char currentChar = s.charAt(i);
			
			
			// checking if number or operator 		
			if (Character.isDigit(currentChar)) {
				operand.push(currentChar - '0');
			}else {
				int num2 = operand.pop();
				int num1 = operand.pop();
				
				// executing correct operation on popped numbers
				switch (currentChar) {
					case '+':
						operand.push(num1 + num2);
						break;
					case '-':
						operand.push(num1 - num2);
						break;
					case '/':
						operand.push(num1 / num2);
						break;
					case '*':
						operand.push(num1 * num2);
				}
			}
		}
		
		result = operand.pop();
		return result;
	}
	
	
}