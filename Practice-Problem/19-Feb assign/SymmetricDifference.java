import java.util.*;

public class SymmetricDifference {
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>();
        
   
        for (T element : set1) {
            if (!set2.contains(element)) {
                result.add(element);
            }
        }
        
        
        for (T element : set2) {
            if (!set1.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + findSymmetricDifference(set1, set2));
    }
}
