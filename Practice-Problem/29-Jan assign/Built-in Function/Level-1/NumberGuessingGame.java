import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int guess;
        
        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");
        
        while (true) {
            guess = generateGuess(lowerBound, upperBound, random);
            String feedback = getUserFeedback(sc, guess);
            
            if (feedback.equals("correct")) {
                System.out.println("Great! I guessed your number.");
                break;
            } else if (feedback.equals("high")) {
                upperBound = guess - 1;
            } else if (feedback.equals("low")) {
                lowerBound = guess + 1;
            } else {
                System.out.println("Something went wrong. Are you sure about your answers?");
                break;
            }
            
            if (lowerBound > upperBound) {
                System.out.println("Something went wrong. Are you sure about your answers?");
                break;
            }
        }
  
    }
    
    private static int generateGuess(int lowerBound, int upperBound, Random random) {
        return lowerBound + random.nextInt(upperBound - lowerBound + 1);
    }
    
    private static String getUserFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
        return sc.nextLine().toLowerCase();
    }
}
