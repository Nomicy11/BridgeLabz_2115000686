import java.util.*;
public class MaximumHandshakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();
		int numberOfHandshakes = (numberOfStudents*(numberOfStudents-1))/2;
		System.out.println("The total number handshakes are "+numberOfHandshakes +" by "+numberOfStudents+" students");
		
		}
}