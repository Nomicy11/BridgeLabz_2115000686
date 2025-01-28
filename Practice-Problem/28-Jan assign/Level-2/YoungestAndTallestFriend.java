import java.util.Scanner;

public class YoungestAndTallestFriend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter the ages of the friends:");
        System.out.print("Enter age of Amar: ");
        ages[0] = sc.nextInt();
        System.out.print("Enter age of Akbar: ");
        ages[1] = sc.nextInt();
        System.out.print("Enter age of Anthony: ");
        ages[2] = sc.nextInt();

        System.out.println("\nEnter the heights of the friends (in meters):");
        System.out.print("Enter height of Amar: ");
        heights[0] = sc.nextDouble();
        System.out.print("Enter height of Akbar: ");
        heights[1] = sc.nextDouble();
        System.out.print("Enter height of Anthony: ");
        heights[2] = sc.nextDouble();

        int youngestIndex = findYoungest(ages);
        String youngestFriend = (youngestIndex == 0) ? "Amar" : (youngestIndex == 1) ? "Akbar" : "Anthony";
        System.out.println("\nThe youngest friend is: " + youngestFriend + " with age " + ages[youngestIndex]);

        int tallestIndex = findTallest(heights);
        String tallestFriend = (tallestIndex == 0) ? "Amar" : (tallestIndex == 1) ? "Akbar" : "Anthony";
        System.out.println("The tallest friend is: " + tallestFriend + " with height " + heights[tallestIndex] + " meters.");
    }

    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
}
