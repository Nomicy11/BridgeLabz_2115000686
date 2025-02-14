public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; 
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {78, 55, 89, 91, 67, 88, 76, 45};
        System.out.println("Original marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        
        bubbleSort(marks);
        
        System.out.println("Sorted marks:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
