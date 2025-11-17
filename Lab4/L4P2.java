// Name: Sean Walborn
// Lab 4, Problem 2
// Submission date: 09/29/25

package Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class L4P2 {
	public static void main(String[] args) {
		// variable use
		SortedDoublyLinkedList studentList = new SortedDoublyLinkedList();// creating doubly linked list
		String fileName = "student3.txt"; // var to store file name - file name must be changed inside code 
		
		try {
			// importing the files
			File file = new File(fileName);
			// moving file into scanner so it can be read
			Scanner scanner = new Scanner(file);
			
			
			while(scanner.hasNextLine()) {
				// captures the current line in a string
				String currentLine = scanner.nextLine();
				
				// splits the line into three parts at each space
				String[] parts = currentLine.split(" ");
				
				//putting each part into a temp var to use in student, converts numbers to ints
				int studentID = Integer.parseInt(parts[0]);
				String name = parts[1];
				int grade = Integer.parseInt(parts[2]);
				
				// creates a new student object to store info temp
				Student newStudent = new Student(studentID, name, grade);
				
				// moves student object to linked list sorts automatically
				studentList.add(newStudent);
						
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		}
		
		// prints out double linked list sorted
		System.out.println("< Student List by ID >");
		studentList.printList();
		
		// prints list reverse (optional);
		// studentList.printListReverse();
	}
}


