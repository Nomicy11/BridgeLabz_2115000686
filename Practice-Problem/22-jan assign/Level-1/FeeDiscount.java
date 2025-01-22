public class FeeDiscount{
	public static void main(String[] args){
		double fee = 125000;
		double discountPercent = 10;
		double discount = 125000*10/100;
		double discountedFee = fee - discount;
		System.out.println("The discount amount is INR " +discount +" and final discounted fee is INR " +discountedFee);
	}
}
