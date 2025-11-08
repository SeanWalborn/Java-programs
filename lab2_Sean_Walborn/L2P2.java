// Name: Sean Walborn
// Lab 2, Problem 2
// Submission date: 09/07/25

package Lab2;
import java.util.Scanner;
import java.util.Random;

public class L2P2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		
		// variables used in main
		int[] randNumArr = new int [10];
		int sumNatNum;
				
		// assigning random numbers to array
		for (int i = 0; i < 10; i++) {
			randNumArr[i] = rand.nextInt(10) + 1;
		}
		
		// calling method to sum numbers assigning return value to sumNatNum
		sumNatNum = recursiveSumArr(randNumArr, 0);
		
		
		//printing arr and sum
		System.out.print(" A: [");
		for (int i = 0; i < 10; i++) {
			if(i  == 9) {
				System.out.print(randNumArr[i]);
			}
			else{
				System.out.print(randNumArr[i] + ", ");
			}
			
		}
		System.out.println("]");
		System.out.println("Sum of array elements: " + sumNatNum);
				
		
	
		scanner.close();

	}
	
	// recursive method that sums each element of the array
	public static int recursiveSumArr(int[] numArr, int index) {
			if (index == numArr.length) {
				return 0;
			}
			
			else{
				return (numArr[index]) + recursiveSumArr(numArr, index + 1);
			}
		
	}
}
