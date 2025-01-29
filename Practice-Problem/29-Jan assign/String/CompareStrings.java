import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();
        
        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();
        
        int minLength = Math.min(str1.length(), str2.length());
        int result = 0;
        
        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            if (ch1 < ch2) {
                result = -1;
                break;
            } else if (ch1 > ch2) {
                result = 1;
                break;
            }
        }
        
        if (result == 0) {
            if (str1.length() < str2.length()) {
                result = -1;
            } else if (str1.length() > str2.length()) {
                result = 1;
            }
        }
        
        if (result == 0) {
            System.out.println("The strings are equal.");
        } else if (result < 0) {
            System.out.println("The first string is lexicographically smaller.");
        } else {
            System.out.println("The first string is lexicographically larger.");
        }
        
     
    }
}
