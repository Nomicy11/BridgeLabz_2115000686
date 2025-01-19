import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the length of the rectangle: ");
        int length = scanner.nextInt();

        
        System.out.print("Enter the width of the rectangle: ");
        int width = scanner.nextInt();

        // Calculate the perimeter of the rectangle
        int perimeter = 2 * (length + width);

        // Display the result
        System.out.println("The perimeter of the rectangle is: " + perimeter);
    }
}
