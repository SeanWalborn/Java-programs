

package Lab2;
import java.util.Scanner;

public class L2P1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// variables used in main
		int inputNatNum;
		int sumNatNum;
				
		// collecting input
		System.out.println("Enter one positive number: ");
		inputNatNum = scanner.nextInt();
		
		// calling method to sum numbers assigning return value to sumNatNum
		sumNatNum = recursiveSum(inputNatNum);
		
		//printing output
		System.out.println("Sum of digits of " + inputNatNum + " is: " + sumNatNum);
				
		
		scanner.close();

	}
	
	public static int recursiveSum(int naturalNumber) {
		if (naturalNumber == 0) {
			return 0;
		}
		
		return (naturalNumber % 10) + recursiveSum(naturalNumber / 10);
	}
}

