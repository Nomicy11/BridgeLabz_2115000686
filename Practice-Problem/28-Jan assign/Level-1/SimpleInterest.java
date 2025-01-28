import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double principal = scanner.nextDouble();
        double rate = scanner.nextDouble();
        double time = scanner.nextDouble();
        
       SimpleInterest obj = new SimpleInterest();
	   double simpleInterest= obj.SI_Calculator(principal,rate,time);
        
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + 
                           ", Rate of Interest " + rate + " and Time " + time);
    }
	
	public double SI_Calculator(double principal, double rate, double time){
		double simpleInterest = (principal * rate * time) / 100;
        
			return simpleInterest;
	}
}