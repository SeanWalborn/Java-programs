// Name: Sean Walborn
// Lab 5, Problem 1
// Submission date: 09/30/25

package Lab5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;

public class L5P1 {
	public static void main(String[] args) {
		
		// variables used in main
		ArrayList<Connection> flightConnList = new ArrayList<>();
		String fileName;
		String startingCity;
		String currentCity;
		LinkedList <String> route = new LinkedList<>();
		
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter filename: ");
		fileName = scan.next();
		
		// opening file
		try {
			// importing the files
			File file = new File(fileName);
			Scanner scan2 = new Scanner(file);
			
			
			while(scan2.hasNextLine()) {
				// captures the current line in a string
				String currentLine = scan2.nextLine();
				
				// splits the line into two parts at each space
				String[] parts = currentLine.split(" ");
				
				//putting each part into a temp var to use in connection
				String origin = parts[0];
				String destination = parts[1];
				
				
				// creates a new connection object to store info temp
				Connection connectingFlight = new Connection(origin, destination);
				
				// moves connection object to list
				flightConnList.add(connectingFlight);
				
			}
			scan2.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		}
	
		// printing out all flights
		System.out.println("All connections: ");
		for (int i = 0; i < flightConnList.size(); i++) {
			flightConnList.get(i).printConnection();
		}
		
		// prompting user to enter starting city
		System.out.println();
		System.out.print("Enter your starting city: ");
		startingCity = scan.next();
		System.out.println();
		currentCity = startingCity;
		route.add(startingCity);
		
		// loop finds all connections
		do {
			System.out.println("From [" + currentCity + "], you can travel to:");
			ArrayList <String> connFlights = connectingFlights(flightConnList, currentCity);
			
			for(int i = 0; i < connFlights.size(); i++ ) {
				System.out.println(" - " + connFlights.get(i));
			}
			// choosing next city and verifying input
			boolean validChoice = false;
			do {
				System.out.print("Enter the next city to visit: ");
				currentCity = scan.next();
				System.out.println();
			
				for(int i = 0; i < connFlights.size(); i++) {
					if (connFlights.get(i).equals(currentCity)) {
						validChoice = true;
					}
				}
				if (!validChoice) {
					System.out.println("Not a valid destination city");
				}
			}while(!validChoice);
			// updating Route
			route.add(currentCity);
		}while(!startingCity.equals(currentCity));
		
		
		//printing final route
		System.out.println("*** Returned to the starting city. Trip completed! ***");
		System.out.println();
		System.out.println("Your travel path:");
		for (int i = 0; i < route.size(); i++) {
			System.out.print(route.get(i));
			if(i < route.size() - 1) {
				System.out.print(" → ");
			}
		}
		
		scan.close();
	}
	
	
	// helper
	public static ArrayList<String> connectingFlights(ArrayList<Connection> conn, String start) {
		// ArrayList to store destinations
		ArrayList <String> destList = new ArrayList<>();
		
		// loop through array of connection and store the matching connections
		for (int i = 0; i < conn.size(); i++) {
			if(conn.get(i).getStart().equals(start)) {
				destList.add(conn.get(i).getDestination());
			}
		}
		return destList;
	}
	

	
}
