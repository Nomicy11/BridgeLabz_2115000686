public class HeapSort {
    public static void heapSort(double[] salaries) {
        int n = salaries.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            
            heapify(salaries, i, 0);
        }
    }
    
    private static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            double swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;
            
            heapify(salaries, n, largest);
        }
    }
    
    public static void main(String[] args) {
        double[] jobSalaries = {55000, 75000, 50000, 60000, 70000};
        System.out.println("Original Salary Demands:");
        for (double salary : jobSalaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
        
        heapSort(jobSalaries);
        
        System.out.println("Sorted Salary Demands:");
        for (double salary : jobSalaries) {
            System.out.print(salary + " ");
        }
    }
}
