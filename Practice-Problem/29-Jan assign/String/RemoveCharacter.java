import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        System.out.print("Enter the character to remove: ");
        char chToRemove = sc.next().charAt(0);
        
        String result = input.replaceAll(String.valueOf(chToRemove), "");
        
        System.out.println("Modified String: " + result);
        
       
    }
}
