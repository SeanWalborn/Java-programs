// Name: Sean Walborn
// Lab 13, Problem 1
// Submission date: 11/30/25

package Lab13;

import java.util.Scanner;

public class L13P1 {
    public static void main(String[] args) {
        // Variables used
    	Dictionary words = new Dictionary();
    	String fileName;
    	String searchWord;
    	String definition;
    	
    	// setting up scanner
    	Scanner scan = new Scanner(System.in);
    	
    	// Collecting file name and word to search
    	System.out.print("Enter dictionary file name: ");
    	fileName = scan.nextLine();
    	System.out.print("Enter a word to look up: ");
    	searchWord = scan.nextLine();
    	
    	// Setting up dictionary
    	words.loadFile(fileName);
    	
    	// finding word
    	definition = words.lookup(searchWord);
    	
    	// determining if word is present
    	if (definition == null) {
    		System.out.println("Meaing: Word not found");
    	}else {
    		System.out.println("Meainf: " + definition);
    	}
    	
    	// printing all dictionary words
    	System.out.println("\nAll dictionary words:");
    	for (String word : words.getDictionary().keySet()) {
    		System.out.println(word);
    	}
    	
        scan.close();
    }
}
