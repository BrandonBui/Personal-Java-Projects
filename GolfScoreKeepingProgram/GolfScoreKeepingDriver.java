/*
 * Author: Brandon Bui
 * Date: 3/8/2022
 * 
 * GolfScoreKeepingProgram
 * 
 * This is the driver for the Scorecard class.  This program is designed to
 * help golfers keep track of their score.  The program begins by asking the
 * user if they have a par file.  This par file should be a txt file with the
 * par of each hole listed in a column with one number per line.  If the user 
 * answers with a 'y' then the program will prompt the user for the file name.
 * I have attached a demo file named "coursePar.txt" that you can use.  After
 * the user has inputted the file or chosen not to, the user will be shown a
 * menu.  The user can input/change a score, check their score, or end their
 * round.
 * 
 * ###Due to spacing reasons score must be put in consecutive order.
 * ie. Hole one then two then three, no skipping holes.###
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GolfScoreKeepingDriver {

	/*
	 * Main
	 * 
	 * This is the main method of the program. This method starts the program, 
	 * then other methods called in the method take over.
	 */
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("Welcome to the Golf Score Keeping program.");

		Scorecard golfer1 = new Scorecard();
		
		//boolean used to decide whether the prompting repeats or not.
		boolean repeat = true;
		do {
		System.out.println("Do you have a course par file that you would like"
				+ " to input? (y/n)");
		char in = kbd.next().charAt(0);
		//If the user wants to input a file, it calls the parInput method and 
		//also sets the repeat boolean to false since a valid input was given.
		if (in == 'y') {
			repeat = false;
			parInput(golfer1, kbd);
			System.out.println("The course par file has been succefully "
					+ "uploaded.");
			//testScorecardVariables(group); //@@@@
		//If user does not want to input a file repeat boolean is set to false
		//so that user isnt prompted again.
		} else if (in == 'n') {
			repeat = false;
		//Invalid input, user is prompted again.
		} else {
			System.out.println("Input invalid. Please try again.");
		}
		} while (repeat);
		
		System.out.println("Please use the following menu to navigate.");
		
		//Calls the menu method that the user will use to navigate the rest of
		//the program.  Method is stuck in infinite loop since the method
		//has the code to end the program.
		while(true) {
			menu(kbd, golfer1);
		}
	}
	
	/*
	 * parInput
	 * 
	 * This method is designed to get the name of the file that the user wants
	 * to input and creates an inputStream to read that file. Once the file is
	 * input, the method calls a method from the scorecard class to set the par
	 * of each hole.
	 * 
	 * @param golfer	The object of the scorecard class
	 * @param kbd		The scanner being used in the program
	 */
	public static void parInput(Scorecard golfer, Scanner kbd) {
		
		System.out.println("Please enter the name of the file.");
		String file = kbd.next();
		
		Scanner inputStream = null;
		
		//Sets the inputStream to the parTryCatch method which will return a
		//scanner.
		inputStream = parTryCatch(inputStream, kbd, file);
		
		//Sets the par for each hole using the file just uploaded.
		golfer.setCoursePar(inputStream);
		
		inputStream.close();
	}
	
	/*
	 * parTryCatch
	 * 
	 * This method contains the try catch that is called in parInput.  This was
	 * separated to make the program more organized. This method tries to find
	 * the file that the user input and if it finds it, the method returns a
	 * FileInputStream.  If it doesn't it keeps prompting the user until a
	 * file is input.
	 * 
	 * @param inputStream	The scanner being used to read the files.
	 * @param kbd			The scanner being used to get user input from the
	 * 						console.
	 * @param file			The string containing the name of the file being
	 * 						found.
	 * @return Scanner		The FileInputStream for the user's file.
	 */
	public static Scanner parTryCatch(Scanner inputStream, Scanner kbd, String
			file) {
		//boolean variable used to decide whether or not prompt is repeated.
		boolean repeat = true;
		
		do {
			try {
				inputStream = new Scanner(new FileInputStream(file));
				//Since file is found the repeat variable is set to false and
				//will not loop again.
				repeat = false;
				
			//If file not found exception is thrown then the program will
			//prompt user again.  User is prompted until a valid file is 
			//entered.
			} catch (FileNotFoundException e) {
				System.out.println("File not found. Please try again.");
				System.out.println("Please enter the name of the file.");
				file = kbd.next();
			}
		} while(repeat);
		
		return inputStream;
	}
	
	/*
	 * menu
	 * 
	 * This method produces a menu and contains a switch case that calls other
	 * methods.
	 * 
	 * @param kbd		The scanner being used to get user input from the console.
	 * @param golfer	The object of the Scorecard class.
	 */
	public static void menu(Scanner kbd, Scorecard golfer) {
		System.out.println("\nMenu");
		System.out.println("----");
		System.out.println("Please choose one of the following options:");
		System.out.println("	1) Input/Change score");
		System.out.println("	2) Check score");
		System.out.println("	3) End round");
		
		int choice = kbd.nextInt();
		
		switch (choice) {
			case 1:
				inputScore(kbd, golfer);
				break;
			case 2:
				checkScore(kbd, golfer);
				break;
			case 3:
				endRound(kbd, golfer);
				break;
		}
	}
	
	/*
	 * inputScore
	 * 
	 * This method is designed to be called from the menu method.  This method
	 * prompts the user for which hole, the score for the hole, and how many
	 * putts the user took on the hole. It then calls the various setter
	 * methods within the Scorecard class to set the score, drive, and putts.
	 * 
	 * ###Due to spacing reasons score must be put in consecutive order.
	 * ie. Hole one then two then three, no skipping holes.###
	 * 
	 * @param kbd		The scanner being used to get user input from the console.
	 * @param golfer	The object of the Scorecard class.
	 */
	public static void inputScore(Scanner kbd, Scorecard golfer) {
		//Prompts user with some questions then uses the scanner to get the input.
		System.out.println("Which hole are you inputting/changing the score "
				+ "for?");
		int hole = kbd.nextInt();
		System.out.println("Please enter your score for hole " + hole);
		int score = kbd.nextInt();
		System.out.println("Where did your drive land (Left, Center, or Right)?"
				+ " L C R");
		char drive = kbd.next().charAt(0);
		System.out.println("How many putts?");
		int putts = kbd.nextInt();
		
		golfer.setHoleScore(hole, score);
		golfer.setPuttStat(hole, putts);
		golfer.setDriveStat(hole, drive);
	}
	
	/*
	 * checkScore
	 * 
	 * This method is designed to be called from the menu method. The method
	 * will print out a nice and easy to read report to the console of how
	 * user is doing so far.  It calls the getter methods within the Scorecard
	 * class to print out the values.
	 * 
	 * @param kbd		The scanner being used to get user input from the console.
	 * @param golfer	The object of the Scorecard class.
	 */
	public static void checkScore(Scanner kbd, Scorecard golfer) {
		System.out.println("Hole:   1   2   3   4   5   6   7   8   9   10  11"
				+ "  12  13  14  15  16  17  18");
		System.out.println("-----   -   -   -   -   -   -   -   -   -   --  --"
				+ "  --  --  --  --  --  --  --");
		System.out.print("Par:    ");
		//Loops through and gets par for each hole
		for (int i = 0; i < 18; i++) {
			System.out.print(golfer.getHolePar(i) + "   ");
		}
		System.out.print("\nScore:  ");
		//Loops through and gets score for each hole. If statement is used to
		//help with spacing between one and two digit numnbers.
		for (int i = 0; i < 18; i++) {
			if (golfer.getHoleScore(i) <= 9 ) {
				System.out.print(golfer.getHoleScore(i) + "   ");
			} else {
				System.out.print(golfer.getHoleScore(i) + "  ");
			}
		}
		//Loops through and gets putts for each hole
		System.out.print("\nPutts:  ");
		for (int i = 0; i < 18; i++) {
			if (golfer.getPuttStat(i) <= 9 ) {
				System.out.print(golfer.getPuttStat(i) + "   ");
			} else {
				System.out.print(golfer.getPuttStat(i) + "  ");
			}
		}
		//Loops through and gets drives for each hole
		System.out.print("\nDrives: ");
		for (int i = 0; i < 18; i++) {
			System.out.print(golfer.getDriveStat(i) + "   ");
		}
	}
	
	/*
	 * endRound
	 * 
	 * This method is designed to be used in the menu method. Once the user has
	 * selected that they want to end their round, it prompt the user if they 
	 * would like to export a file containing a report of their round.
	 * 
	 * @param kbd		The scanner being used to get user input from the console.
	 */
	public static void endRound(Scanner kbd, Scorecard golfer) {
		System.out.println("Thank you for using the Golf Score Keeping program!");
		
		char ans;
		do {
			System.out.println("Would you like to export your round review? "
					+ "(y/n)");
			ans = kbd.next().charAt(0);
			//If yes then outputStream is created and outputted to file.
			if (ans == 'y') {
				
				PrintWriter outputStream = null;
			
				try {
					outputStream = new PrintWriter(new FileOutputStream
							("roundReview.txt"));
				} catch (FileNotFoundException e) {
					System.out.println("Error, file not found.");
					System.exit(0);
				}
				
				//Outputs to the file. Exactly like the checkScore method
				//except it uses ouputStream instead of System.out
				outputStream.println("Hole:   1   2   3   4   5   6   7   8   9"
						+ "   10  11  12  13  14  15  16  17  18");
				outputStream.println("-----   -   -   -   -   -   -   -   -   -"
						+ "   --  --  --  --  --  --  --  --  --");
				outputStream.print("Par:    ");
				for (int i = 0; i < 18; i++) {
					outputStream.print(golfer.getHolePar(i) + "   ");
				}
				outputStream.print("\nScore:  ");
				for (int i = 0; i < 18; i++) {
					if (golfer.getHoleScore(i) <= 9 ) {
						outputStream.print(golfer.getHoleScore(i) + "   ");
					} else {
						outputStream.print(golfer.getHoleScore(i) + "  ");
					}
				}
				outputStream.print("\nPutts:  ");
				for (int i = 0; i < 18; i++) {
					if (golfer.getPuttStat(i) <= 9 ) {
						outputStream.print(golfer.getPuttStat(i) + "   ");
					} else {
						outputStream.print(golfer.getPuttStat(i) + "  ");
					}
				}
				outputStream.print("\nDrives: ");
				for (int i = 0; i < 18; i++) {
					outputStream.print(golfer.getDriveStat(i) + "   ");
				}
				
				outputStream.close();
				System.out.println("Have a great rest of your day.");
				System.exit(0);
			//If no then program ends.
			} else if (ans == 'n') {
				System.out.println("Well have a great rest of your day then!");
				System.exit(0);
			//If invalid input then user is prompted again.
			} else {
				System.out.println("Invalid input. Please try again.");
			}
		} while (ans != 'y' && ans != 'n');
	}
	
	/*
	 * testScorecardVariables
	 * 
	 * This method is used to test the variables after they were inputted into
	 * the program.
	 * 
	 * @param golfer	The object of the Scorecard class.
	 */
	public static void testScorecardVariables(Scorecard golfer) {
		//Loops through each hole and prints out the par for that hole.
		for (int i = 0; i < 18; i++) {
			System.out.println(golfer.getHolePar(i));
		}
		System.out.println();
	}
}
