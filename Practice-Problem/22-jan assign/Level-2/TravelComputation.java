import java.util.Scanner;

public class TravelComputation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String fromCity = scanner.nextLine();
        String viaCity = scanner.nextLine();
        String toCity = scanner.nextLine();

        double distanceFromToVia = scanner.nextDouble();
        double distanceViaToFinalCity = scanner.nextDouble();
        
        int timeFromToVia = scanner.nextInt();
        int timeViaToFinalCity = scanner.nextInt();
        
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;

        double fee = scanner.nextDouble();
        double discountPercent = scanner.nextDouble();
        
        double discountAmount = (fee * discountPercent) / 100;
        double finalFee = fee - discountAmount;

        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity +
                         " is " + totalDistance + " miles and " +
                         "the Total Time taken is " + totalTime + " minutes.");
    }
}
