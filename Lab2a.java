import java.util.Scanner;

/*
 * Lab2a.java
 *
 * Authors: Samantha Smith, Brandon Bui
 */
// TODO: Import Scanner

public class Lab2a {
    public static void main(String[] args){
        // kelvins and temperaturePrinter tests
        System.out.println("\nTesting kelvins and temperaturePrinter:");
        
        temperaturePrinter(10, kelvins(10));//260.98
        temperaturePrinter(32, kelvins(32));//273.150
        temperaturePrinter(38, kelvins(38));//276.483
        temperaturePrinter(44, kelvins(44));//279.817
        temperaturePrinter(79, kelvins(79));//299.261

        // inSeconds tests
        System.out.println("\nTesting inSeconds:");
        
        inSeconds(1, 5, 1);// Expect: 3901
        inSeconds(1, 7, 5);//4025
        inSeconds(4, 30, 9);//16209
        inSeconds(3, 2, 40);//10960
        inSeconds(5, 44, 43);//20683
       

        // secondTime tests
        System.out.println("\nTesting secondTime:");
        
        secondTime(12479);//3:27:59
        secondTime(13579);//3:46:19
        secondTime(1234);//0:20:34
        secondTime(145678);//40:27:58
        secondTime(75321);//20:55:21
    }

    /**
     * kelvins
     *
     * This method converts a value in F to the corresponding value in K.
     *
     * @param   f   double  The temperature in Farenheit
     * @return  The temeprature in Kelvins
     */
    public static double kelvins(double f) {
    	double k = (5.0/9.0);
    	k = k*(f-32.0);
    	k = k + 273.15;
       	return k;
    	
    }

    /**
     * temperaturePrinter
     *
     * This method prints the message "<f> F corresponds to <k> K"
     *
     * @param   f   double  The temperature in Farenheit
     * @param   k   double  The temperature in Kelvins
     */
    public static void temperaturePrinter(double f, double k) {
        System.out.printf("%.3f deg. F equals %.3f deg. K", f, k);
        System.out.println();
    }



    /**
     * secondTime
     *
     * This method converts from seconds to hour:minutes:seconds, and prints the
     * result to the console.
     *
     * @param   inputSeconds    int The total seconds to convert
     */
    // TODO: You figure out the declaration and the method!
    public static void secondTime(int seconds){
        int hours = seconds / 3600;
        int hoursRem = seconds % 3600;
        int min = hoursRem / 60;
        int sec = hoursRem % 60;
        
        System.out.println(seconds + "==" + hours + ":" + min + ":" + sec);
    }
    /**
     * inSeconds
     *
     * This method converts from hours:munites:seconds to seconds, and prints the
     * result to the console.
     *
     * @param   hours   int The hours to convert
     * @param   mins    int The minutes to convert
     * @param   secs    int The seconds to convert
     * @return The total number of seconds
     */
    // TODO: You figure out the declaration and the method!
    public static void inSeconds(int hours, int mins, int secs) {
    	int seconds = (hours * 3600) + (mins * 60) + secs;
    	System.out.println(hours + ":" + mins + ":" + secs + " == " + seconds);
    }
}

