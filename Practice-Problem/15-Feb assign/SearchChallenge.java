import java.util.Arrays;

public class SearchChallenge {
   
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

      
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
               
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1; 
    }

   
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                
            } else if (arr[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1}; 
        int firstMissing = findFirstMissingPositive(nums);
        System.out.println("First missing positive integer: " + firstMissing);

        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 
        int target = 5;
        int targetIndex = binarySearch(sortedArr, target);
        System.out.println("Target " + target + " found at index: " + targetIndex);
    }
}
