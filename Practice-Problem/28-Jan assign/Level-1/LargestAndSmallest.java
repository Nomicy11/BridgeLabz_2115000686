import java.util.Scanner;

public class LargestAndSmallest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		LargestAndSmallest obj = new LargestAndSmallest();
		int[] arr1 = obj.fun(num1,num2,num3);
		int small = arr1[1];
		int large = arr1[0];
		System.out.println("Smallest : "+small+"\nLargest : "+large);
		
	}
	
	public int[] fun(int n1,int n2,int n3){
	
		int[] arr = new int[2];
		if(n1>n2 ){
			if(n1>n3){
				arr[0]= n1;
				if(n2>n3){
					arr[1]= n3;
				}
				else{
					arr[1]=n2;
				}
			}
			else{
				arr[0]=n3;
				arr[1]=n2;
			}
			
		}
		
		else if(n2>n3){
			arr[0]=n2;

			if(n1<n3){
				arr[1]=n1;
			}
			else{
				arr[1]=n3;
			}
		}
		else if(n3>n2){
			arr[0]=n3;
			if(n1<n3){
				arr[1]=n1;
			}
		}
		
		
		return arr;
	}
}