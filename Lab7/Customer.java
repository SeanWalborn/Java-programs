package Lab7;

public class Customer {
	// variable used by class
	private int customerID;
	private String name;
	private int time;
	
	// constructor for class
	public Customer() {
		this.customerID = 0;
		this.name = "empty";
		this.time = 0;
	}
	public Customer(int ID, String n, int t) {
		this.customerID = ID;
		this.name = n;
		this.time = t;
	}
	
	//getters
	public int getCustomerID() {
		return customerID;
	}
	public String getName() {
		return name;
	}
	public int getTime() {
		return time;
	}
	
	// setters
	public void setCustomerID(int ID) {
		this.customerID = ID;
	}
	public void setName(String n) {
		this.name = n;
	}
	public void setTime(int t) {
		this.time = t;
	}
	
	//prints object
	public void printCustomer() {
		System.out.println("   --> Customer [" + customerID + ", " + name + ", (" + time + "ms)]");
	}
}


