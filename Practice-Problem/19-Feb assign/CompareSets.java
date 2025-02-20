import java.util.*;

public class CompareSets {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        if (set1.size() != set2.size()) {
            return false; 
        }
        
        for (T element : set1) {
            if (!set2.contains(element)) {
                return false; 
            }
        }
        
        return true; 
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        System.out.println("Are Sets Equal? " + areSetsEqual(set1, set2));
    }
}
