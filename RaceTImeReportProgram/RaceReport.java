/*
 * Author: Brandon Bui
 * Date: 3/3/2022
 * 
 * This class is designed to be use with the ReportDriver and Race class. The
 * class prints out the statistics for the race using the times inputed in the
 * Driver class. 
 */
public class RaceReport {
	
	//Constructor
	public RaceReport() {
		
	}
	
	/*
	 * placePrint
	 * 
	 * Designed to print out the first, second, and third places in order using
	 * the race times obtained in the driver class.
	 * 
	 * @param time1	Time for first place racer.
	 * @param time2	Time for second place racer.
	 * @param time3	Time for third place racer.
	 */
	public void placePrint(double time1, double time2, double time3) {
			
		System.out.printf("\nFirst place (time in seconds): %.2f \n", time1);
		System.out.printf("Second place (time in seconds): %.2f \n", time2);
		System.out.printf("Third place (time in seconds): %.2f \n\n", + time3);
	}

	/*
	 * tieChecker
	 * 
	 * Designed to check if there are any ties, based on 3 conditions: All tie,
	 * 2 tie for first, or 2 tie for second.
	 * 
	 * @param time1	Time for first place racer.
	 * @param time2	Time for second place racer.
	 * @param time3	Time for third place racer.
	 */
	public void tieCheck(double time1, double time2, double time3) {
		
		if (time1 == time2 && time2 == time3) {
			System.out.println("All racers tied.");
		}
		if (time1 == time2) {
			System.out.println("Two racers are tied for first.");
		}
		if (time2 == time3) {
			System.out.println("Two racers are tied for second.");
		}
	}
	
	/*
	 * statPrint
	 * 
	 * Designed to print out the range and the average race time.
	 * 
	 * @param time1	Time for first place racer.
	 * @param time2	Time for second place racer.
	 * @param time3	Time for third place racer.
	 */
	public void statPrint(double time1, double time2, double time3) {
		
		System.out.printf("The range of the race times (in seconds): %.2f \n", 
				(time3 - time1));
		System.out.printf("The average time of all racers (in seconds): %.2f \n",
				((time1 + time2 + time3) / 3));
	}
}
