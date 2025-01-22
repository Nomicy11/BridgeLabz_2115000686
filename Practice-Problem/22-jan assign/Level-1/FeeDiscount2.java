import java.util.Scanner;
public class FeeDiscount2{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
		double fee = sc.nextDouble();
                double discountPercent = sc.nextDouble();
                double discount = 125000*10/100;
                double discountedFee = fee - discount;
                System.out.println("The discount amount is INR " +discount +" and final discounted fee is INR " +discountedFee);
        }
}
