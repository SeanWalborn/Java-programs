
package lab1;
import java.util.Scanner;

public class L1P1 {
	public static void main(String[] args) {
		// variables used 
		int num1;
		int num2;
		int temp1;
		int temp2;
		int gcd;
		int lcm;
	
		Scanner scanner = new Scanner(System.in);
		
		// collecting user input
		System.out.println("Enter first positive integer: ");
		num1 = scanner.nextInt();
		
		System.out.println("Enter second positive integer: ");
		num2 = scanner.nextInt();
		
		// var used in loop
		temp1 = num1;
		temp2 = num2;
		// calculating GCD
		while (temp1 != 0 ) {
			int holdingNum = temp1;
			temp1 = temp2 % temp1;
			temp2 = holdingNum;
		}
		gcd = temp2;
		
		// calculating LCM using GCD
		lcm = Math.abs(num1 * num2)/ gcd;
		
		// Printing results
		System.out.println("Greatest Common Divisor (GCD): " + gcd);
		System.out.println("Least Common Multiple (LCM)  : " + lcm);
		
		
		scanner.close();
	}
}

