/*
 * HW_Arrays
 * 
 * @author Brandon Bui
 * @version 2/22/2022
 * 
 * This program is designed to take in user inputs to calculate the velocity of
 * a sky diver.  Assumes that the user knows the information to input and works
 * when the Total Time is evenly divisible into the change in time.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class SkydiverVelocityCalculator {
	
	/*
	 * main
	 * 
	 * This is the main method. It gets user input which gets passed on as
	 * parameters into the other methods. It also creates the printwriter and
	 * outputs everything to the file.
	 */
	public static void main(String args[]) {
		
		boolean repeat = true;
		
		while (repeat) {
			
			Scanner kbd = new Scanner(System.in);
			
			//gets user input and assigns to appropriate variables
			System.out.print("Enter the mass of the skydiver (kg): ");
			double mass = kbd.nextDouble();
			System.out.print("Enter the cross-sectional area of the skydiver "
					+ "(m^2): ");
			double area = kbd.nextDouble();
			System.out.print("Enter the drag coefficient of the skydiver: ");
			double drag = kbd.nextDouble();
			System.out.print("Enter the ending time (sec): ");
			double endTime = kbd.nextDouble();
			System.out.print("Enter the time step (sec): ");
			double timeStep = kbd.nextDouble();
			System.out.print("Enter the output filename: ");
			String file = kbd.next();
			
			PrintWriter outputStream = null;
			
			//try catch statement to catch possible FileNotFound exceptions
			try {
				outputStream = new PrintWriter(new FileOutputStream(file));
			} catch (FileNotFoundException e) {
				System.out.println("File was not found.");
				System.exit(0);
			}
			
			//declares two arrays, one for the time and one for velocity.
			//The size of the array is determined by the amount of time divided
			//by the step size.  Assumes that the numbers divide equally.
			int arraySize = (int) (endTime/timeStep) + 1;
			
			double[] time = new double[arraySize];
			double[] velocity = new double[arraySize];
			
			time[0] = 0;
			velocity[0] = 0;
			
			System.out.println("\nWriting out file. Here are the values within"
					+ " the first second:");
			
			System.out.println(time[0] + ", " + velocity[0]);
			outputStream.println(time[0] + ", " + velocity[0]);
			
			//for every index after the first, the velocity is calculated
			for (int i = 1; i < arraySize; i += 1) {
				
				velocity[i] = calculation(mass, area, drag, velocity[i-1], 
						timeStep);
				time[i] = time[i - 1] + timeStep;
				
				outputStream.printf("%.4f, %.4f\n", time[i], velocity[i]);
				
				//I wanted to display the velocity for the first second so an
				//if statement is used to check if the current index of time
				//is still less than one.
				if (time[i] < 1) {
					System.out.printf("%.4f, %.4f\n", time[i], velocity[i]);
				}
				
			}
			outputStream.close();
			
			boolean question = true;
			
			//A while loop that contains the entire method is used to determine
			//whether or not the user would like to calculate another dive. If
			//they do, then the condition stays true and the program loops
			//again.  This while loop below is just used to repeat the prompt
			//in the event that the user enters an invalid choice.
			while (question) {
				
				System.out.println("Would you like to enter another dive? "
						+ "(y/n)");
				
				char chrIn = kbd.next().charAt(0);
				
				//Checks the entered character to see if it is valid
				if(chrIn == 'y') {
					repeat = true;
					question = false;
				} else if (chrIn == 'n') {
					repeat = false;
					question = false;
				} else {
					System.out.println("Incorrect input please enter y or n.");
				}
			}
		}
		
		System.out.println("Thank you for using the velocity calculator!");
	}
	
	/*
	 * calculation
	 * 
	 * Calculates the velocity using the user inputs gained in the main method.
	 * The velocity formula was split into multiple lines for easier
	 * understanding and so java reads it correctly.
	 * 
	 * @param mass	Mass of the sky diver.
	 * @param area	Cross-sectional area of the sky diver.
	 * @param drag	Drag coefficient of the sky diver.
	 * @param previousVel	The velocity from the previous time.
	 * @param timeStep	The change in time.
	 * 
	 * @return velocity	The velocity of the skydiver at the given time.
	 * 
	 */
	public static double calculation(double mass, double area, double drag, 
			double previousVel, double timeStep) {
		
		double velocity;
		double temp;
		
		velocity = previousVel * previousVel;
		temp = drag * 1.14 * area;
		temp = temp / (2 * mass);
		velocity *= temp;
		velocity = 9.81 - velocity;
		velocity *= timeStep;
		velocity += previousVel;
		//testVariables(velocity, temp, drag, area); //@@@@ test method
		
		return velocity;
	}
	/*
	 * testVatiables
	 * 
	 * 
	 * This method is used to help with tracing variables.  It takes in an
	 * unlimited amount of parameters and prints each on it's individual line.
	 * 
	 * @param double...arg Any amount of double variables.
	 */
	public static void testVariables(double...arg) {
		for (double elem : arg) {
			System.out.println(elem);
		}
	}
}
