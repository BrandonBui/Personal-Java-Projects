/*
 * Author: Brandon Bui
 * Date: 3/8/2022
 * 
 * Scorecard
 * 
 * This is the Scorecard class used in the GolfScoreKeepingDriver program.
 * It contains the getter, and setter methods for the instance variables
 * which are all arrays.
 */

import java.util.Scanner;

public class Scorecard {
	
	private int[] pars = new int[18];
	private int[] scores = new int[18];
	private int[] puttStats = new int[18];
	private char[] driveStats = new char[18];
	
	/*
	 * Constructor
	 */
	public Scorecard() {

	}
	
	/*
	 * getScoreArray
	 * 
	 * Used to get the entire array that contains the score for each hole.
	 * 
	 * @return int[]	The score array.
	 */
	public int[] getScoreArray() {
		return this.scores;
	}
	
	/*
	 * getHoleScore
	 * 
	 * Used to get the score for a hole
	 * 
	 * @return int	The score for a hole.
	 */
	public int getHoleScore(int hole) {
		return this.scores[hole];
	}
	
	/*
	 * getHolePar
	 * 
	 * Used to get the par for a hole
	 * 
	 * @return int	The par for a hole.
	 */
	public int getHolePar(int hole) {
		return this.pars[hole];
	}
	
	/*
	 * getPuttStat
	 * 
	 * Used to get the putting stat for a hole
	 * 
	 * @return int	The putts for a hole.
	 */
	public int getPuttStat(int hole) {
		return this.puttStats[hole];
	}
	
	/*
	 * getDriveStat
	 * 
	 * Used to get the driving stat for a hole
	 * 
	 * @return int	The drive stat for a hole.
	 */
	public char getDriveStat(int hole) {
		return this.driveStats[hole];
	}
	
	/*
	 * setHoleScore
	 * 
	 * Used to set the score for a hole
	 * 
	 *@param hole	The specified hole.
	 *@param score	The score for the hole.
	 */
	public void setHoleScore(int hole, int score) {
		this.scores[hole - 1] = score;
	}
	
	/*
	 * setHolePar
	 * 
	 * Used to set the par for a hole
	 * 
	 *@param hole	The specified hole.
	 *@param score	The par for the hole.
	 */
	public void setHolePar(int hole, int par) {
		this.pars[hole] = par;
	}
	
	/*
	 * setCoursePar
	 * 
	 * Used to set the par for the course
	 * 
	 *@param inputStream	The inputStream that contains the par file.
	 */
	public void setCoursePar(Scanner inputStream) {
		for (int i = 0; i < pars.length; i++) {
			pars[i] = inputStream.nextInt();
		}
	}
	
	/*
	 * setPuttStats
	 * 
	 * Used to set the putt stat for a hole
	 * 
	 *@param hole	The specified hole.
	 *@param score	The putts for the hole.
	 */
	public void setPuttStat(int hole, int putts) {
		this.puttStats[hole - 1] = putts;
	}
	
	/*
	 * setDriveStat
	 * 
	 * Used to set the drive stat for a hole
	 * 
	 *@param hole	The specified hole.
	 *@param score	The drive stat for the hole.
	 */
	public void setDriveStat(int hole, char drive) {
		this.driveStats[hole - 1] = drive;
	}
	
}
