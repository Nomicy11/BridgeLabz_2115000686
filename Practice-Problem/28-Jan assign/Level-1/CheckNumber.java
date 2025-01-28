import java.util.*;
public class CheckNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		CheckNumber check = new CheckNumber();
		check.checknum(num);
		
	}
	
	public	void checknum(int num){
		if(num==0){
			System.out.println("Zero");
			
		}
		else if(num>0){
			System.out.println("Positive");
		}
		else{
			System.out.println("Negative");
		}
	}
}