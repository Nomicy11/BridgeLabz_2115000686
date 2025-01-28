import java.util.Scanner;
public class SpringSeason{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int month = sc.nextInt();
		SpringSeason obj = new SpringSeason();
		obj.season(day,month);
		
		
	}
	
	public void season(int day,int month){
		if((month == 3 && day >= 20 && day <= 31) || 
            (month == 4 && day >= 1 && day <= 30) || 
            (month == 5 && day >= 1 && day <= 31) || 
            (month == 6 && day >= 1 && day <= 20)){
			System.out.println("Its a Spring Season");
		}
		else{
			System.out.println("Its not a Spring Season");
		}
	}
}