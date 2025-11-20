// Name: Sean Walborn
// Lab 7, Problem 2
// Submission date: 10/12/25

package Lab7;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;


public class L7P2 {
	public static void main(String[] args) {
		// Variables used
		String fileName;
		Deque<String> undo = new ArrayDeque<>();
		Deque<String> redo = new ArrayDeque<>();
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter file name: ");
		fileName = scan.next();
		
		// loading file 
		try{
			// setting up scanner and file
			File wordFile = new File(fileName);
			Scanner scan2 = new Scanner(wordFile);
			
			while (scan2.hasNextLine()) {				
				// Processing each line of the file and adding to the linked list
				String currentLine = scan2.nextLine();
				String [] part = currentLine.split(" ");
				
				// switch to determine actions
				switch(part[0]){ 
					case "type" :
						undo.push(part[1]);
						redo.clear();
						break;
					case "print" :
						// for each loop that prints each item in the stack
						printStack(undo);
						break;
					case "redo" : 
						// pops most recent item from redo and push to undo
						if (!redo.isEmpty()) {
							undo.push(redo.pop());
						}
						break;
					
					case "undo" : 
						// pops most recent item from undo and push to redo
						if (!undo.isEmpty()) {
							redo.push(undo.pop());
						}
						break;
				}
			}
			scan2.close();
		}
		catch(FileNotFoundException e){
			System.out.print("File not Found");
			e.printStackTrace();	
		}
		scan.close();
	}
	
	// Helper function
	static void printStack(Deque<String> input) {
		Deque<String> temp = new ArrayDeque <>(input);
		
		while (!temp.isEmpty()) {
			System.out.print(temp.pollLast());
		}
		
		System.out.println();
	}
}

