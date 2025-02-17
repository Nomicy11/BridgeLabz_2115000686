import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Generate random array
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(1000);  // Random integers between 0 and 999
        return arr;
    }

    public static void main(String[] args) {
        // Test different dataset sizes
        int[] datasetSizes = {1000, 10000, 1000000};

        for (int size : datasetSizes) {
            System.out.println("Testing with array size: " + size);

            // Generate the original random array
            int[] originalArray = generateArray(size);

            // Copy the original array to ensure algorithms work on the same data
            int[] arrBubble = Arrays.copyOf(originalArray, originalArray.length);
            int[] arrMerge = Arrays.copyOf(originalArray, originalArray.length);
            int[] arrQuick = Arrays.copyOf(originalArray, originalArray.length);

            // Bubble Sort
            long start = System.nanoTime();
            bubbleSort(arrBubble);
            long end = System.nanoTime();
            System.out.println("Bubble Sort Time: " + (end - start) / 1000000 + " ms");

            // Merge Sort
            start = System.nanoTime();
            mergeSort(arrMerge);
            end = System.nanoTime();
            System.out.println("Merge Sort Time: " + (end - start) / 1000000 + " ms");

            // Quick Sort
            start = System.nanoTime();
            quickSort(arrQuick, 0, arrQuick.length - 1);
            end = System.nanoTime();
            System.out.println("Quick Sort Time: " + (end - start) / 1000000 + " ms");

            System.out.println();
        }
    }
}
