package Exercise_04;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Week01 Exercise 13.4 Display Calendar
 * @author Kristin Myers
 * Github https://github.com/km0931977/CIS171MyersK 
 * 
 * Program starts by creating a static array of the months. 
 * Then checks if the year and month given is valid.
 * Determines and displays days in the month.
 * Then prints display of the calendar according to argument parameters.
 * Additionally the required output is available, it displays
 * The month of the year and the number of days in said month.
 */


public class Exercise_04 {

   private final static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   /**
   * Checks if the month is valid (1-12)
   * @param month
   * @return
   */
   public static boolean validMonth(int month) {
       if((0 < month) && (month < 13))
           return true;
      
       return false;
   }
  
   /**
   * Checks if the year is valid (4 digits)
   * @param year
   * @return
   */
   public static boolean validYear(int year) {
       if((year + "").length() == 4)
           return true;
       return false;
   }
  
   /**
   * Returns the maximum number of days in a month
   * @param month
   * @param year
   */
   public static int maxMonthDays(int month, int year) {
       if(month == 2) {
               return 28;
       } else if((month == 1) || (month == 3) || (month == 5) || (month == 7) ||
               (month == 8) || (month == 10) || (month == 12))
           return 31;
      
       else
           return 30;
   }
  
   /**
   * Prints the Calendar
   * @param month
   * @param year
   */
   public static void printCalendar(int month, int year) {
       Calendar cal = new GregorianCalendar(year, month - 1, 1);
      
       String header = months[month - 1] + " " + year;
       System.out.printf("%8s %s", " ", header);
       System.out.printf(String.format("\n%29s", " ").replace(" ", "-"));
       System.out.printf("\n%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
      
       // Prints space to adjust number spacing
       int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
       for(int i = 0 ; i < (4 * (dayOfWeek - 1)) ; i++) {
           System.out.print(" ");
       }
      
       for(int i = 1 ; i <= maxMonthDays(month, year) ; i++) {
           System.out.printf("%4d", i);
          
           if(((dayOfWeek % 7) == 0) && (i != 0))
               System.out.println();
          
           dayOfWeek += 1;
       }
       
        // Additional required output
        System.out.println("\nMonth " + cal.get(Calendar.MONTH) + " of 2022 has " + cal.getMaximum(Calendar.DAY_OF_MONTH) + " days.");
   }
  
   public static void main(String[] args) {
       int month = 0;
       int year = 0;
      
       switch (args.length) {
           case 1 -> {
               month = Integer.parseInt(args[0]);
               year = Calendar.getInstance().get(Calendar.YEAR);
           }
           case 2 -> {
               month = Integer.parseInt(args[0]);
               year = Integer.parseInt(args[1]);
           }
           default -> {
                   month = Calendar.getInstance().get(Calendar.MONTH) + 1;
                   year = Calendar.getInstance().get(Calendar.YEAR);
           }
       }
      
       if(validMonth(month)) {
           if(validYear(year)) {
               printCalendar(month, year);
           } else {
               System.out.println("The year is not valid. Format: XXXX");
           }
       } else {
           System.out.println("The month is not valid. The number should be between 0 and 13.");
       }
   }
}