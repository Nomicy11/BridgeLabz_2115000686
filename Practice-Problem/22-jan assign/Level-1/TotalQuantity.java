import java.util.*;

import java.util.*;
public class TotalQuantity{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int unitPrice = sc.nextInt();
		int quantity = sc.nextInt();
		
		int totalPrice = unitPrice * quantity;
		
		System.out.println("The total purchase price is INR "+totalPrice+" if the quantity is " +quantity+" and unit price is INR " +unitPrice);
	}
}
