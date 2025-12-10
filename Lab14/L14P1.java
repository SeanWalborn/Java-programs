// Name: Sean Walborn
// Lab 14, Problem 1
// Submission date: 12/7/25

package Lab14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class L14P1 {
	 public static void main(String[] args) {
		 // Variables
		 String fileName;
		 int searchScore;
		 HashMap<Integer, HashSet<String>> map = new HashMap<>();
		 HashSet<String> studentNames;
		 TreeSet<String> sortedNames;
		 
		 
		// Setting up scanner
	    Scanner scan = new Scanner(System.in);
	    
	    // collecting file name
	    System.out.print("Enter file name: ");
	    fileName = scan.next();
	    System.out.print("Enter the score to search: ");
	    searchScore = scan.nextInt();
	    
	    // opening file 
	    try {
			// Setting up scanner and file
            File file = new File(fileName);
            Scanner scan2 = new Scanner(file);
            
            // processing file
            while (scan2.hasNextLine()) {
            	// processing line by line
            	String line = scan2.nextLine();
            	
            	// breaking up the line
            	String[]parts = line.split(" ");
            	
            	// Saving name and score - converting to integer
            	String name = parts[0];
            	int score = Integer.parseInt(parts[1]);
            	
            	// adding the name and score to the hash map- creating new hash set if score is not already present
            	map.putIfAbsent(score, new HashSet<>());
            	map.get(score).add(name);          	
            }
            scan2.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
	    
	    // checking is entered score is present and presenting hash set if it is
	    if(map.containsKey(searchScore)) {
	    	// gets hash set with the student names and convert to tree set to sort
	    	studentNames = map.get(searchScore);
	    	sortedNames = new TreeSet<>(studentNames);
	    	    	
	    	// displaying results to the user
	    	System.out.println ("There are " + sortedNames.size() + " students who got " + searchScore);
	    	System.out.println ("They are : " + sortedNames );
	    }
	    else {
	    	System.out.println("No student recieved a score of " + searchScore + ".");
	    }
	    scan.close();
	 }
}
