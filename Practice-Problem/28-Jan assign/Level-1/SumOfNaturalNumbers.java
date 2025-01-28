import java.util.Scanner;

public class SumOfNaturalNumbers{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a natural number: ");
		int n = sc.nextInt();
		SumOfNaturalNumbers obj = new SumOfNaturalNumbers();
		int sum = obj.sum(n);
		
		System.out.println("The sum is "+sum);
		
	}
	
	public int sum(int num){
		int sum =0;
		while(num!=0){
			sum+=num;
			num--;
		}
		return sum;
	}
}