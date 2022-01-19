//Add all numbers then subtract max and min to get middle number

import java.util.Scanner;

public class Lab2b {
	public static void main(String args[]) {
		Scanner scannerObject = new Scanner(System.in);
 
		System.out.println("Please enter your name followed by 3 numbers.  (Use spaces to seperate)");
		
		String name = scannerObject.next();
		Double n1 = scannerObject.nextDouble();
		Double n2 = scannerObject.nextDouble();
		Double n3 = scannerObject.nextDouble();
		
		System.out.println("Hello " + name + "! Here are the numbers you entered in descending order:");
		numberSorter(n1, n2, n3);
		System.out.println("Thank you for using the 3 number sorting system!");
		
	}
	
	public static void numberSorter(double n1, double n2, double n3) {
		double maxNumber1 = Math.max(n1, n2);
		double maxNumber2 = Math.max(n2, n3);
		double maxNumber = Math.max(maxNumber1, maxNumber2);
		
		double minNumber1 = Math.min(n1, n2);
		double minNumber2 = Math.min(n2, n3);
		double minNumber = Math.min(minNumber1, minNumber2);
		
		double middleNumber = (n1 + n2 + n3) - maxNumber - minNumber;
		
		System.out.println(maxNumber + " " + middleNumber + " " + minNumber);
		
	}
}
