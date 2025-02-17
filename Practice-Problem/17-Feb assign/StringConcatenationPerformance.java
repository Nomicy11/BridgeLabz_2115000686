public class StringConcatenationPerformance {

    // Method using String
    public static String concatenateUsingString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a";  // Concatenation using String
        }
        return result;
    }

    // Method using StringBuilder
    public static String concatenateUsingStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("a");  // Concatenation using StringBuilder
        }
        return result.toString();
    }

    // Method using StringBuffer
    public static String concatenateUsingStringBuffer(int n) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append("a");  // Concatenation using StringBuffer
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test with different number of operations (N)
        int[] testSizes = {1000, 10000, 100000};

        for (int size : testSizes) {
            System.out.println("Testing with " + size + " concatenations:");

            // String concatenation
            long startTime = System.nanoTime();
            concatenateUsingString(size);
            long endTime = System.nanoTime();
            System.out.println("String (Time): " + (endTime - startTime) / 100000 + " ms");

            // StringBuilder concatenation
            startTime = System.nanoTime();
            concatenateUsingStringBuilder(size);
            endTime = System.nanoTime();
            System.out.println("StringBuilder (Time): " + (endTime - startTime) / 100000 + " ms");

            // StringBuffer concatenation
            startTime = System.nanoTime();
            concatenateUsingStringBuffer(size);
            endTime = System.nanoTime();
            System.out.println("StringBuffer (Time): " + (endTime - startTime) / 100000 + " ms");

            System.out.println();
        }
    }
}
