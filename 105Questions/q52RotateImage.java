public class q52RotateImage {
    
    // 48. Rotate Image

    // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    // You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
    // DO NOT allocate another 2D matrix and do the rotation.

    // Example 1:
    // Input:
    //  [[1,2,3],
    //  [4,5,6],
    //  [7,8,9]]

    // Output
    // [[7,4,1],
    // [8,5,2],
    // [9,6,3]]

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Perform the rotation
        rotateSol2(arr);
        
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Brute force approach 
    // Approach: Take another dummy matrix of n*n, and then take the first row of the matrix and put it in the last column of the dummy 
    // matrix, take the second row of the matrix, and put it in the second last column of the matrix and so.
    // Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.
    // Space Complexity: O(N*N) to copy it into some other matrix.

    public static int[][] rotateSol(int[][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    // Optimal APPROACH
    // We see that the first column of the original matrix is the reverse of the first row of the rotated matrix, 
    // so that’s why we transpose the matrix and then reverse each row. 
    // Since we are making changes in the matrix itself, space complexity gets reduced to O(1).

    // Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)
    // Step 2: Reverse each row of the matrix.

    static void rotateSol2(int[][] matrix) {
        // 1st step: transpose 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2nd step: reverse the rows 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
