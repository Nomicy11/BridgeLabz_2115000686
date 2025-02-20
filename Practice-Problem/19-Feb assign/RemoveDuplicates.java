import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (Integer num : list) {
            if (!seen.contains(num)) {
                seen.add(num);
                uniqueList.add(num);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("List without Duplicates: " + removeDuplicates(numbers));
    }
}
