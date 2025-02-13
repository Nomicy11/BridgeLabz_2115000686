import java.util.*;

class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num)) {
                System.out.println("Pair found: (" + (target - num) + ", " + num + ")");
                return true;
            }
            seen.add(num);
        }

        System.out.println("No pair found.");
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        hasPairWithSum(nums, target);
    }
}
