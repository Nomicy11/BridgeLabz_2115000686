import java.util.Scanner;
public class SumOfNaturalNumbers
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int temp = num;
		int sum=0;
		while((num>0)){
			sum+=num;
			num--;
		}
		System.out.println(sum);
		
		if(temp>0){
			int sum2 = (temp*(temp+1))/2;
			System.out.println(sum2);
		}
		
		}
	
}