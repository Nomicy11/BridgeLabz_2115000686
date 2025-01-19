import java.util.*;

public class CylinderVolume {
    public static void main(String[] args) {
   
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();

        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();
       
        double volume = Math.PI * Math.pow(radius, 2) * height;

        System.out.printf("The volume of the cylinder with radius %.2f and height %.2f is: %.2f", radius, height, volume);
    }
}
