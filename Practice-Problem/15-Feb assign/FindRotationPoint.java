public class FindRotationPoint {
    public static int findRotationIndex(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }

        return left; 
    }

    public static void main(String[] args) {
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3}; 
        int rotationIndex = findRotationIndex(rotatedArray);

 
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}
