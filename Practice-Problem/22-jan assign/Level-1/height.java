import java.util.Scanner;
public class Height{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 
		double heightInCentimeters = sc.nextDouble(); 
		double heightInInches = heightInCentimeters/2.54;
		double heightInFeet = heightInInches/12;
		System.out.println("Your Height in cm is "+heightInCentimeters +" while in feet is "+heightInFeet+" and inches is "+heightInInches);
	}
}
