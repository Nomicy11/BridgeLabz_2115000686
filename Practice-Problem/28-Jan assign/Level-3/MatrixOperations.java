import java.util.Random;

public class MatrixOperations {

 
    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random number between 0-9
            }
        }
        return matrix;
    }

    
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    
    public static int determinant2x2(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) {
            throw new IllegalArgumentException("Matrix must be 2x2");
        }
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    
    public static int determinant3x3(int[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new IllegalArgumentException("Matrix must be 3x3");
        }
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
             - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
             + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf("%4d", num);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       
        int[][] matrix3x3 = generateMatrix(3, 3);
        System.out.println("Original Matrix:");
        displayMatrix(matrix3x3);

        int[][] transposed = transposeMatrix(matrix3x3);
        System.out.println("\nTranspose of Matrix:");
        displayMatrix(transposed);

      
        if (matrix3x3.length == 2) {
            System.out.println("\nDeterminant (2x2): " + determinant2x2(matrix3x3));
        } else if (matrix3x3.length == 3) {
            System.out.println("\nDeterminant (3x3): " + determinant3x3(matrix3x3));
        }
    }
}
