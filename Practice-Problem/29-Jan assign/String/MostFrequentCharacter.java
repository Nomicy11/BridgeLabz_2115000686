import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        int[] frequency = new int[256]; 
        int maxFrequency = 0;
        char mostFrequentChar = ' ';
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            frequency[ch]++;
            
            if (frequency[ch] > maxFrequency) {
                maxFrequency = frequency[ch];
                mostFrequentChar = ch;
            }
        }
        
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
        
        
    }
}
