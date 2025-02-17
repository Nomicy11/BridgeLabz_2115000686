import java.util.*;

public class DataStructureSearchComparison {


    public static boolean arraySearch(int[] array, int key) {
        for (int num : array) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }

 
    public static boolean hashSetSearch(HashSet<Integer> set, int key) {
        return set.contains(key);
    }

    
    public static boolean treeSetSearch(TreeSet<Integer> set, int key) {
        return set.contains(key);
    }

    public static void main(String[] args) {
   
        int[] datasetSizes = {1000, 10000, 100000};
        
     
        for (int size : datasetSizes) {
            System.out.println("Testing with dataset size: " + size);

            
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }

            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < size; i++) {
                hashSet.add(i);
                treeSet.add(i);
            }

        
            int key = size - 1; 

            long startTime = System.nanoTime();
            arraySearch(array, key);
            long endTime = System.nanoTime();
            System.out.println("Array Search Time: " + (endTime - startTime) / 1000000.0 + " ms");

            
            startTime = System.nanoTime();
            hashSetSearch(hashSet, key);
            endTime = System.nanoTime();
            System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000.0 + " ms");

          
            startTime = System.nanoTime();
            treeSetSearch(treeSet, key);
            endTime = System.nanoTime();
            System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000.0 + " ms");

            System.out.println();
        }
    }
}
