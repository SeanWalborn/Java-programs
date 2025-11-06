// Name: Sean Walborn
// Lab 1, Problem 2
// Submission date: 09/05/25
package lab1;
import java.util.Scanner;

public class L1P2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// variables used to store input and frequency
		int inputNum;
		int tempInputNum;
		int arrLen = 0;
		int[] numArr;
		int[] freqArr = new int[10];		
		int count = 0;
		
		
		// collecting input from user
		System.out.println("Enter a number: ");
		inputNum = scanner.nextInt();
		
		// duplicating input to find length
		tempInputNum = inputNum;		
		
		//find length of array required
		while(tempInputNum > 0 ) {
			arrLen++;
			tempInputNum = tempInputNum / 10;
		}
		
		// Initializing arr with proper length
		numArr = new int[arrLen];
		
		//converting integer to array by div by 10 and saving remainder then dropping it from original variable
		while (inputNum > 0) {
			numArr[count] = inputNum % 10;
			count++;
			inputNum = inputNum / 10;
		}
		
		// finding frequency of each num and incrementing frequency array using nested for loop and if else statement 		
		for(int i = 0; i < 10; i++ ) {
			for(int j = 0; j < arrLen; j++) {
				if (numArr[j] == i) {
					freqArr[i]++;
				}
			}
		}
		
		// printing results
		for(int i = 0; i < 10; i++) {
			if (freqArr[i] != 0 ) {
				System.out.println(i + " appears " + freqArr[i] + " times.");
			}
		}
		
		
		scanner.close();
	}
}