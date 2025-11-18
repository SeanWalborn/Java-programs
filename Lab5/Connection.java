package Lab5;


public class Connection{
	
		// variable used by class
		private String start;
		private String destination;
		
		// constructor for class
		public Connection() {
			this.start = "empty";
			this.destination = "empty";
		}
		public Connection(String s, String d) {
			this.start = s;
			this.destination = d;
		}
		
		//getters
		public String getStart() {
			return start;
		}
		public String getDestination() {
			return destination;
		}
		
		// setters
		public void setStart(String s) {
			this.start = s;
		}
		public void setDestination(String d) {
			this.destination = d;
		}
		
		// operators
		public void printConnection() {
			System.out.println(start + " → " + destination);
		}
		

}
