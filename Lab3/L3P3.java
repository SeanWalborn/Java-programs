// Name: Sean Walborn
// Lab 3, Problem 3
// Submission date: 09/12/25

package Lab3;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;


public class L3P3 {
	// method to read student info from file and save to array list of class students
	public static ArrayList<Student> readDataFromFile(String filename) {
		// variables used to store student info
		ArrayList<Student> studentInfo = new ArrayList<>();
		
		try {
			// importing the files
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			
			
			while(scanner.hasNextLine()) {
				// captures the current line in a string
				String currentLine = scanner.nextLine();
				
				// splits the line into three parts at each space
				String[] parts = currentLine.split(" ");
				
				//putting each part into a temp var to use in student, converts numbers to ints
				int studentID = Integer.parseInt(parts[0]);
				String name = parts[1];
				int score = Integer.parseInt(parts[2]);
				
				// creates a new student object to store info temp
				Student student = new Student(studentID, name, score);
				
				// moves student object to list
				studentInfo.add(student);
						
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		}
		
		// returning arraylist of student profiles
		return studentInfo;
		
	}
	
	// method to print the array lists of students
	public static void printArrayList(ArrayList<Student> list) {
		// loop that prints each element of the array list
		for (int i = 0; i < list.size(); i++ ) {
			System.out.print(list.get(i).getStudentID() + " ");
			System.out.print(list.get(i).getName()+ " ");
			System.out.println(list.get(i).getScore());
		}
	}
	
	// main
	public static void main(String[] args) {
		// Variables
		int score;
		ArrayList<Student> sortedList = new ArrayList<Student>();
		// Setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter filename: ");
		String filename = scan.next();
		
		ArrayList<Student> list = readDataFromFile(filename);
		//Original list
		System.out.println("\n < Original Data >");
		printArrayList(list);
		
		// collecting score to search
		System.out.print("\nEnter score to search: ");
		score  = scan.nextInt();
		
		// finding all students with that score
		for (int i = 0; i < list.size(); i++) {
			// checks each students score
			if(list.get(i).getScore() == score) {
				sortedList.add(list.get(i));
			}
		}
		
		//Sorts student with input score by id
		Collections.sort(sortedList);
		
		// prints out Sorted list
		System.out.println("\n < Sorted List by ID with " + score + " score >");
		printArrayList(sortedList);
		scan.close();
		
	}

}
