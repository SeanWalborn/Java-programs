
package Lab13;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

public class L13P2 {
	public static void main(String[] args) {
        // Variables used
    	int topK= 0;
    	String fileName;
    	TreeMap<String, Integer> wordFreq = new TreeMap<>();
    	
    	// setting up scanner
    	Scanner scan = new Scanner(System.in);
    	
    	// Collecting file name and word to search
    	System.out.print("Enter dictionary file name: ");
    	fileName = scan.nextLine();
    	System.out.print("Enter k: ");
    	topK = scan.nextInt();
    	
    	// opening file and processing words
    	try {
    		// setting up files and scanner
            File file = new File(fileName);
            Scanner scan2 = new Scanner(file);

            while (scan2.hasNextLine()) {
            	// processing each word and adding to tree map or incrementing if already present
                String word = scan2.nextLine();
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }

            scan2.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
         }
    	
    	// finding top k frequency words
    	List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFreq.entrySet());

    	entries.sort((e1, e2) -> {
    	    // Compare frequency first (descending)
    	    int freqCompare = e2.getValue().compareTo(e1.getValue());  
    	    if (freqCompare != 0) return freqCompare;

    	    // If frequency is same, sort alphabetically (ascending)
    	    return e1.getKey().compareTo(e2.getKey());
    	});
    	
    	// printing results
    	for (int i = 0; i < Math.min(topK, entries.size()); i++) {
    	    Map.Entry<String, Integer> entry = entries.get(i);
    	    System.out.println(entry.getKey() + ": " + entry.getValue());
    	}
    	
    	scan.close();
	}
}

