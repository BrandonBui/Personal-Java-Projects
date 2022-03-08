/*
 * Author: Brandon Bui
 * Date: 3/3/2022
 * 
 * This class is designed to be use with the Driver and Report classes.  It is
 * designed to use the input from the driver class and assign them a time
 * variable, and sort them into ascending order.
 */
public class Race {
	
	private double time1;
	private double time2;
	private double time3;
	
	//Constructor
	public Race() {
	}
	
	/*
	 * getTime
	 * 
	 * Uses a switch case to avoid having to write a method for each variable,
	 * and instead uses a parameter, corresponding to a variable, and a switch
	 * case. Returns a requested race time.
	 * 
	 * @param time An integer referring to the 1, 2, or 3 race time.
	 * @return double Returns the race time for a racer.
	 */
	public double getTime(int time) {
		switch (time) {
			case 1: 
				return time1;
			case 2:
				return time2;
			case 3:
				return time3;
		}
		
		return getTime(time);
	}
	
	/*
	 * setTime
	 * 
	 * Uses a switch case to avoid having to write a method for each variable,
	 * and instead uses a parameter, corresponding to a variable, and a switch
	 * case. Takes input and assigns a new race time.
	 * 
	 * @param time An integer referring to the 1, 2, or 3 race time.
	 * @param raceTime The new race time.
	 */
	public void setTime(int time, double raceTime) {
		
		switch (time) {
			case 1: 
				time1 = raceTime;
				break;
			case 2:
				time2 = raceTime;
				break;
			case 3:
				time3 = raceTime;
				break;
		}		
	}
	
	/*
	 * sortTimeAscending
	 * 
	 * Sorts the time into ascending order using Min and Max methods.
	 */
	public void sortTimeAscending() {
		double temp1 = time1;
		double temp2 = time2;
		double temp3 = time3;
		double temp;
		
		time1 = Math.min(temp1, temp2);
		temp = Math.min(temp2, temp3);
		
		time1 = Math.min(time1, temp);
		
		time3 = Math.max(temp1, temp2);
		temp = Math.max(temp2, temp3);
		
		time3 = Math.max(time3, temp);
		
		time2 = (temp1 + temp2 + temp3) - (time1 + time3);
	}

}
