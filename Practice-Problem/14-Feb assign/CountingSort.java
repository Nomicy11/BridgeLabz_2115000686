public class CountingSort {
    public static void countingSort(int[] ages) {
        int[] count = new int[9]; 
        for (int age : ages) count[age - 10]++;
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                ages[index++] = i + 10;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 13, 17, 16, 11};
        countingSort(studentAges);
        for (int age : studentAges) {
            System.out.print(age + " ");
        }
    }
}
