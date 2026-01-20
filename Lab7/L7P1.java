

package Lab7;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.File;
import java.io.FileNotFoundException;

public class L7P1 {
	public static void main (String[] args) {
		// Variables
		String fileName;
		Queue <Customer> customerQueue = new LinkedList<>();
		int time = 0;
		int previousTime = 0;
		boolean firstLoop = true;
		
		// setting up scanner
		Scanner scan = new Scanner(System.in);
		
		// collecting file name
		System.out.print("Enter file name : ");
		fileName = scan.next();
		
		
		customerQueue = loadQueue(fileName);
		System.out.println();
		
		while(!customerQueue.isEmpty()) {
			// displaying current queue
			System.out.println(" << Current queue status >>");
			for (Customer c: customerQueue) {
				c.printCustomer();
			}
			System.out.println();
			
			// serving first customer with not wait time
			if(firstLoop) {
				System.out.println("'" + customerQueue.peek().getName() + "' is being served.");
				System.out.println(customerQueue.peek().getName() + "'s total waiting time: " + time + " ms\n");
				previousTime = customerQueue.peek().getTime();
				customerQueue.poll();
				firstLoop = false;
			}
			else {
				
				// wait time for next customer
				try {
					// pauses program for wait time of next customer
					Thread.sleep(previousTime);
					time += previousTime;
					previousTime = customerQueue.peek().getTime();
					
				}
				catch(InterruptedException e){
					// handles exception if wait time was interrupted
					System.out.println("Wait was interrupted");
				}
				
				// serving remaining customers 
				System.out.println("'" + customerQueue.peek().getName() + "' is being served.");
				System.out.println(customerQueue.peek().getName() + "'s total waiting time: " + time + " ms\n");
				customerQueue.poll();
			}
		}
		
		System.out.println(" << Current queue status >>");
		System.out.println("All customers have been served");
		scan.close();
		
	}
	// helper methods
	static Queue<Customer> loadQueue(String f) {
		// Variables used
		Queue <Customer> customerQueue = new LinkedList<>();
		
		// loading file 
		try{
			// setting up scanner and file
			File customerFile = new File(f);
			Scanner scan2 = new Scanner(customerFile);
			
			while (scan2.hasNextLine()) {
				Customer tempCustomer = new Customer();
				
				// Processing each line of the file and adding to the linked list
				String currentLine = scan2.nextLine();
				String [] part = currentLine.split(" ");
							
				// setting up customer object
				tempCustomer.setCustomerID(Integer.parseInt(part[0]));
				tempCustomer.setName(part[1]);
				tempCustomer.setTime(Integer.parseInt(part[2]));
				
				// setting up linkedList
				customerQueue.offer(tempCustomer);
				
				// displaying new customer in queue to user
				System.out.println("'"+ tempCustomer.getName() + "' has entered the queue.");
				
			}
			scan2.close();
		}
		catch(FileNotFoundException e){
			System.out.print("File not Found");
			e.printStackTrace();
			
		}
		
		return customerQueue;
	}
	
	
}


