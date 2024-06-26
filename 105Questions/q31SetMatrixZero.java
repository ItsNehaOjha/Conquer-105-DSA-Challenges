class q31SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;   // number of rows
        int n = matrix[0].length; // number of columns
        int[] row = new int[m];
        int[] col = new int[n];
        
        // Mark rows and columns that need to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {   
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        // Set the matrix cells to zero where required
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };
        
       setZeroes(matrix);
        
        System.out.println("Matrix after setZeroes:");
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
