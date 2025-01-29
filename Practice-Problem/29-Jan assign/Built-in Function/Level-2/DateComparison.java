import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the first date input
        System.out.print("Enter the first date (yyyy-mm-dd): ");
        String firstDateInput = sc.nextLine();
        
        // Get the second date input
        System.out.print("Enter the second date (yyyy-mm-dd): ");
        String secondDateInput = sc.nextLine();
        
        // Convert input strings to LocalDate objects
        LocalDate date1 = LocalDate.parse(firstDateInput);
        LocalDate date2 = LocalDate.parse(secondDateInput);
        
        // Compare the two dates
        if (date1.isBefore(date2)) {
            System.out.println("The first date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("The first date is after the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("The first date is the same as the second date.");
        }
    }
}

