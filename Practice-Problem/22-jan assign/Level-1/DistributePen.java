public class DistributePen{
	public static void main(String[] args){
		int numberOfPens = 14;
		int numberOfStudents = 3;
		int penPerStudent = 14/3;
		int penNotDistributed = 14%3;
		System.out.println("The Pen Per Student is "+penPerStudent +" and the remaining pen not distributed is " +penNotDistributed);
	}
}
