import java.util.Arrays;
import java.util.Random;

public class SearchPerformanceComparison {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search: O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }


    public static void measurePerformance(int N) {
        int[] data = new int[N];
        Random rand = new Random();

      
        for (int i = 0; i < N; i++) {
            data[i] = i;
        }
        int target = rand.nextInt(N); 

        // Measure Linear Search Time
        long start = System.nanoTime();
        linearSearch(data, target);
        long end = System.nanoTime();
        System.out.println("Linear Search (" + N + " elements): " + ((end - start) / 1e6) + " ms"); // (1e6:  1 milisecond = 1,000,000 nanoseconds)

        // Measure Binary Search Time (data already sorted)
        start = System.nanoTime();
        binarySearch(data, target);
        end = System.nanoTime();
        System.out.println("Binary Search (" + N + " elements): " + (end - start) / 1e6 + " ms");
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};// Same as int number = 1000;

        for (int N : datasetSizes) {
            measurePerformance(N);
        }
    }
}
