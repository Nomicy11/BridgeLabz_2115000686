import java.util.*;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long num = sc.nextLong();

        int[] freq = new int[10];
        while (num != 0) {
            int digit = (int) Math.abs(num % 10);
            freq[digit]++;
            num /= 10;
        }

        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " -> " + freq[i]);
            }
        }


    }
}
