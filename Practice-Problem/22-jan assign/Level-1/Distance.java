import java.util.*;
public class Distance{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double distanceInFeet = sc.nextDouble();
		double distanceInYard = distanceInFeet/3;
		double distanceInMile = distanceInYard/1760;
		System.out.println("Distance in feet is "+distanceInFeet +"while is yard is "+distanceInYard+" and in miles is " +distanceInMile);
	}
}