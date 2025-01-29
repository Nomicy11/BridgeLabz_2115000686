import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get the date input from the user
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String inputDate = sc.nextLine();
        
        // Convert input string to LocalDate
        LocalDate date = LocalDate.parse(inputDate);
        
        // Add 7 days, 1 month, and 2 years
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2);
        
        // Subtract 3 weeks from the resulting date
        newDate = newDate.minusWeeks(3);
        
        // Display the final date
        System.out.println("The final date after adding and subtracting is: " + newDate);
    }
}
