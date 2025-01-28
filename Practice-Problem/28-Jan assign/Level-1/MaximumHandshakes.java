import java.util.*;
public class MaximumHandshakes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();
		MaximumHandshakes obj = new MaximumHandshakes();
		int max = obj.handshakes(numberOfStudents);
		
		System.out.println("The total number handshakes are "+max +" by "+numberOfStudents+" students");
		
		}
		
		public int handshakes(int student){
			int numberOfHandshakes = (student*(student-1))/2;
			return numberOfHandshakes;
			
		}
}