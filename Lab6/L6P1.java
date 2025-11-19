// Name: Sean Walborn
// Lab 6, Problem 1
// Submission date: 10/04/25

package Lab6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

public class L6P1 {
	
	public static void main(String[] args) {
		// pseudo code:
		// collect word and file name
		// read file line by line
		// count instances of word in each line
		// print line number and occurrence number
		// find highest word count and line
		
		// variables used
		String fileName;
		String searchWord;
		int lineCount = 0;
		int highestWordCount = 0;
		int lineWithHighCount = 0;
		Stack<String> mostWords = new Stack<>();
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		
		// collecting file name and word
		System.out.print("Enter file name: ");
		fileName = scan.next();
		System.out.print("Enter word to search: ");
		searchWord = scan.next();
		
		// loading file and checking to ensure it opened
		try {
			// setting up scanner and file to search for word
			File file = new File(fileName);
			Scanner scan2 = new Scanner(file);
			
			System.out.println();
			System.out.println("<< Word occurrences per line >>");
			System.out.println();
			
			
			// loops to check each line and return results
			while (scan2.hasNextLine()){
				// declaring or updating variables
				lineCount ++;
				int wordCount = 0;
				Stack<String> tempWord = new Stack<>();
				
				// storing line in temp var as all lower case
				String currentLine = scan2.nextLine();
			
				
				// splits the line into parts using regex to ignore spaces and punctuation
				String[] parts = currentLine.split("[^a-zA-Z]+");
				
				// checks for search word in the line pushes word to stack if matches
				for (int i = 0; i < parts.length; i++) {
					if (parts[i].equalsIgnoreCase(searchWord)) {
						wordCount++;
						tempWord.push(parts[i]);
					}
				}
				
				// prints occurrences per line
				System.out.println("Line " + lineCount + ": " + wordCount + " occurrence(s)");
				
				// checking for highest count
				if (wordCount > highestWordCount ) {
					// updating the line and count 
					highestWordCount = wordCount;
					lineWithHighCount = lineCount;
					
					// clearing stack to prep for new words
					mostWords.clear();
					
					// updating stack with new words from longest line
					for (int i = 0; i < parts.length; i++) {
						if (parts[i].equalsIgnoreCase(searchWord)) {
							// un-reverses word order in stack so prints correctly when popped again
							mostWords.push(tempWord.pop());
						}
					}
				}
			}
			
			// print highest count and the line
			System.out.println();
			System.out.println("** The line with the most occurrences:");
			System.out.print("** Line " + lineWithHighCount + ": \"");
			for(int i = 0; i < highestWordCount; i++) {
				System.out.print(mostWords.pop() + " ");
			}
			System.out.println("- it's everywhere! \"" );
			System.out.println("** Occurrences: " + highestWordCount);
			
			
			scan2.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		
		scan.close();
	
	}
}
