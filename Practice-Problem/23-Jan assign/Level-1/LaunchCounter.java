import java.util.Scanner;
public class LaunchCounter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		while(count>1){
			count--;
			System.out.println(count);
		}
	}
}