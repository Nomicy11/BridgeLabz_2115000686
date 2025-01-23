import java.util.Scanner;
public class LaunchCounter2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i=count;i>0;i--){
		
			System.out.println(i);
		}
	}
}