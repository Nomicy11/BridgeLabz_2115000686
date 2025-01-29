import java.util.*;
public class MaxOfThreeNum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		int res = max(num1,num2,num3);
		System.out.println("The max pf three numbers is : " +res);
	}
	
	public static int max(int n1,int n2 , int n3){
		if(n1>n2 && n1>n3){
			return n1;
		}
		
		else if (n2>n3 && n2>n1){
			return n2;
		}
		else{
			return n3;
		}
		
	}
	
	
	
}