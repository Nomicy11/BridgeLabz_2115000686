import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter salary for employee " + i + ": ");
            double salary = sc.nextDouble();

            System.out.println("Enter years of service for employee " + i + ": ");
            double years = sc.nextDouble();

            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;

            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += newSalary;

            System.out.println("Employee " + i + " Bonus: " + bonus + ", New Salary: " + newSalary);
        }

        System.out.println("\nSummary:");
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Payout: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

    }
}
