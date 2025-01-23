import java.util.Scanner;
public class SumOfNumbers{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double num=1;
		double sum=0;
		while(num!=0){
			num = sc.nextDouble();
			sum+=num;
		}
		System.out.println(sum);
	}
}