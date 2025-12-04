package Lab13;

import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	
	// Constructors
	public Dictionary() {
        dictionary = new TreeMap<>();
    }
	
	// Loading file
	public void loadFile(String filename) {
		try {
			// Setting up scanner and file
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            
            // processing file
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                // Separating word and definition
                String[] parts = line.split(" - ", 2);
                
                // saving words in strings then in Tree Map
                String word = parts[0].trim();
                String definition = parts[1].trim();
                dictionary.put(word, definition);
            }

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }
	
	// Looking up words
	public String lookup(String word) {
        return dictionary.get(word);
    }

	// Getter for entire dictionary
	public TreeMap<String, String> getDictionary() {
	    return dictionary; 
	}
	
	// Variables
	private TreeMap<String, String> dictionary;
}
