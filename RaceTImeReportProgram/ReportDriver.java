import java.util.Scanner;

/*
 * Author: Brandon Bui
 * Date: 3/3/2022
 * 
 * ReportDriver
 * 
 * This class assumes that the user also has the RaceReport and Race classes,
 * and that the user knows how to properly input the race times.  This class is 
 * designed to take in three race times, sort the race times from fast to slow,
 * and then print out statistics regarding the times.
 * 
 */
public class ReportDriver {
	
	/*
	 * Main
	 * 
	 * This method is the main method of the driver that calls most of the
	 * other methods, and creates objects of the other classes.
	 */
	public static void main(String[] args) {
		
		//Boolean used to decide if the main will loop again
		boolean repeatMain = true;
		
		do {
			//objects of the classes are created.
			Scanner kbd = new Scanner(System.in);
			Race race = new Race();
			RaceReport raceRep = new RaceReport();

			timeInput(race);
			
			//Lines 37-43 call methods from the other classes
			race.sortTimeAscending();
			
			//testVariables(race.getTime(1), race.getTime(2), race.getTime(3)); //@@@@
		
			raceRep.placePrint(race.getTime(1), race.getTime(2), race.getTime(3));
			raceRep.tieCheck(race.getTime(1), race.getTime(2), race.getTime(3));
			raceRep.statPrint(race.getTime(1), race.getTime(2), race.getTime(3));
			
			//The following lines prompt the user to enter y/n to decide if
			//they want to enter another race or not. If they do, then the
			//repeat main boolean stays true and the do-while loop repeats.
			//If they select no then the repeat boolean turns to false and the
			//do-while loop evaluates to false and does not repeat. If they
			//user inputs a invalid input the system terminates with a message.
			System.out.print("\nEnter another race? (y/n): ");
			char cha = kbd.next().charAt(0);
			
			if (cha == 'y') {
				repeatMain = true;
				System.out.println();
			} else if (cha == 'n') {
				repeatMain = false;
			} else {
				System.out.println("Invalid input.");
				System.exit(0);
			}
		
		} while (repeatMain);
		
	}
	
	/*
	 * timeInput
	 * 
	 * This method is designed to get the race times from the user and then
	 * assign them to a race time using the class' setter method.
	 * 
	 * @param race	Takes in an object of the race class which allows the
	 * program to assign the user input to a variable
	 */
	public static void timeInput(Race race) {
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Enter the race times (in seconds):");
		String line = kbd.nextLine();
		Scanner lineScanner = new Scanner(line);
		
		for (int i = 1; i <= 3; i++) {
			race.setTime(i, lineScanner.nextDouble());
		}
	}
	
	/*
	 * testVariables
	 * 
	 * Just a test method to take in any double variables and print them.
	 * Assists with variable tracing.
	 * 
	 * @param doule...arg Any double variable.
	 */
	public static void testVariables(double...arg) {
		for (double elem : arg) {
			System.out.println(elem);
		}
	}
	
	
}
