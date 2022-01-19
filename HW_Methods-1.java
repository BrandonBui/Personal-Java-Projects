import java.util.Scanner;

public class HW_Methods {
	/*
	 * Declares two instance variables, mario and coin.
	 * Instance variable used as these variables will be called
	 * in multiple methods.
	 */
	public static String mario = "PLACEHOLDERMARIO";
	public static String coin = "PLACEHOLDERCOIN";
	
	public static void main(String args[]) {
		
		runProgramA();
		runProgramB();

	}
	
	/*
	 * runProgramA creates the first program.
	 * 
	 * Creates two mario boards by calling each segment method
	 * a number of times and in different orders.
	 */
	public static void runProgramA() {
		//Mario Board 1
		System.out.println("Mario Board 1:");
		segment1();
		segment2(0);
		segment2(0);
		segment1();
		segment3(0);
		//Mario Board 2
		System.out.println("Mario Board 2:");
		segment1();
		segment2(0);
		segment1();
		segment2(0);
		segment2(0);
		segment3(0);
		}
	
	/*
	 * runProgramB creates the second program.
	 * 
	 * Creates the first mario board and also allows for user input
	 * to customize what mario looks like and what the coin looks like
	 */
	public static void runProgramB() {		
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("What do you want your mario to look like?");
		HW_Methods.mario = scannerObject.next();
		System.out.println("What do you want a coin to look like?");
		HW_Methods.coin = scannerObject.next();
		System.out.println();
		segment1();
		segment2(1);
		segment2(1);
		segment1();
		segment3(1);
	}
	
	/*This method creates segment 1
	 * 
	 * An integer declared as count is assigned a value of 6
	 * A while loop is used to repeat the println of "||" 6 times
	 * After "||" is printed, the variable count is decremented.
	*/
	public static void segment1() {
		int count = 6;
		
		while(count > 0) {
			System.out.println("||");
			count --;
		}
		System.out.println();
	}
	
	/*This method creates segment 2
	 * 
	 * An integer declared as count is assigned a value of 2
	 * A while loop is used to print ||, ||    |?|, || twice.
	 * After that is printed 1 is decremented form count.
	 * 
	 * @Parameters Variable of type int named tOrF, which stands for true or false,
	 * is used to determine whether the segment will print a coin or not.  If the input
	 * is 1 then it will print the coin.
	 */
	public static void segment2(int tOrF) {
		int count = 2;
		
		while(count > 0) {
			System.out.println("||");
			if(tOrF == 1) {
				System.out.println("||    |?|" + HW_Methods.coin);
			}else {
				System.out.println("||    |?|");
			}
			System.out.println("||");
			count --;
		}
		System.out.println();
	}
	
	/*This method creates segment 3
	 * 
	 * This seemed like the most efficient way of creating this method
	 * 
	 * @Parameters Variable of type int named tOrF, which stands for true or false,
	 * is used to determine whether the segment will print a mario or not.  If the input
	 * is 1 then it will print the mario.
	 */
	public static void segment3(int tOrF) {
		System.out.println("||");
		System.out.println("||||");
		System.out.println("||||||");
		System.out.println("||||||||");
		System.out.println("||||||||||");
		if(tOrF == 1) {
			System.out.println("||||||||||||" + HW_Methods.mario);
		}else {
		System.out.println("||||||||||||");
		}
		System.out.println("||");
		System.out.println("||              ^");
		System.out.println("|----------------");
		System.out.println();
	}
}
