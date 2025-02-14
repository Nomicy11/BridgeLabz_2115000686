public class SelectionSort {
    public static void selectionSort(double[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] examScores = {85.5, 70.2, 90.3, 60.8, 78.4};
        System.out.println("Original Exam Scores:");
        for (double score : examScores) {
            System.out.print(score + " ");
        }
        System.out.println();
        
        selectionSort(examScores);
        
        System.out.println("Sorted Exam Scores:");
        for (double score : examScores) {
            System.out.print(score + " ");
        }
    }
}
