import java.util.Random;

public class EmployeeBonus {
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateBonus(employeeData);
        displaySummary(updatedData);
    }

    static double[][] generateEmployeeData(int numEmployees) {
        Random random = new Random();
        double[][] data = new double[numEmployees][2];

        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = 10000 + random.nextInt(90000); // Random salary between 10000 - 99999
            data[i][1] = random.nextInt(11); // Random years of service between 0 - 10
        }
        return data;
    }

    static double[][] calculateBonus(double[][] data) {
        double[][] updatedData = new double[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonusPercentage = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusPercentage;
            double newSalary = salary + bonus;

            updatedData[i][0] = salary;
            updatedData[i][1] = years;
            updatedData[i][2] = bonus;
            updatedData[i][3] = newSalary;
        }
        return updatedData;
    }

    static void displaySummary(double[][] data) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s\n", "ID", "Old Salary", "Years", "Bonus", "New Salary");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            totalOldSalary += data[i][0];
            totalNewSalary += data[i][3];
            totalBonus += data[i][2];

            System.out.printf("%-5d %-10.2f %-10.0f %-10.2f %-10.2f\n", (i + 1), data[i][0], data[i][1], data[i][2], data[i][3]);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("TOTAL  %-10.2f %-10s %-10.2f %-10.2f\n", totalOldSalary, "", totalBonus, totalNewSalary);
    }
}
