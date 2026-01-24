
package Lab5;

import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;

public class L5P2 {
	public static void main(String[] args) {
		// program pseudo code:
		// get file name
		// open file
		// read one line
		// split into two stacks based on brackets 
		// compare stack sizes and print results
		// repeat until end of file is reached
		
		// Variables used in main 
		String fileName;
		int stringLength;
		int lineCount = 0;
		
		// Setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// Collecting file name
		System.out.print("Enter file name: " );
		fileName = scan.next();		
	
		// opening file and validating file opened 
		try {
			// importing the files
			File file = new File(fileName);
			Scanner scan2 = new Scanner(file);
			
			// loop that runs for every line of the file
			while(scan2.hasNextLine()) {
				//local Variables
				Stack<String> openBracketStack = new Stack<>();
				Stack<String> closedBracketStack = new Stack<>();
				String result = "Invalid";
				
				// increments line count once for output
				lineCount++;
				
				// captures the current line in a string
				String currentLine = scan2.nextLine();
				
				// finds length of string 
				stringLength = currentLine.length();
				
		
				//push all opening brackets to stack
				for (int i = 0; i < stringLength; i++) {
					// pushes char to stack and converts to string to fit in stack if opening brackets
					if (currentLine.charAt(i) == '(') {
						openBracketStack.push(String.valueOf(currentLine.charAt(i)));
					}
				}
				
				//push all closing brackets to stack
				for (int i = 0; i < stringLength; i++) {
					// pushes char to stack and converts to string to fit in stack if opening brackets
					if (currentLine.charAt(i) == ')') {
						closedBracketStack.push(String.valueOf(currentLine.charAt(i)));
					}
				}
				
				// compares two stack sizes to check for balance
				if (openBracketStack.size() == closedBracketStack.size()) {
					result = "Valid";
				}
					
				// prints output
				System.out.println("Line " + lineCount + ": " + currentLine + " => " + result);
				
			}
			scan2.close();
		}
		// Notify user if file did not open or not found
		catch(FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		}
		scan.close();
	}

//	 helper function used for testing
//		public static void printStack(Stack<String> s) {
//			int len = s.size();
//			
//			for (int i = 0; i < len; i++ ) {
//				System.out.print(s.pop());
//			}
//		}

}
