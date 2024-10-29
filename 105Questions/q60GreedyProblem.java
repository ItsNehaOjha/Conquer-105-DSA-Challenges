public class q60GreedyProblem {
    
    // 1605. Find Valid Matrix Given Row and Column Sums

// You are given two arrays rowSum and colSum of non-negative integers where rowSum[i] is the sum of the elements in the ith row and 
// colSum[j] is the sum of the elements of the jth column of a 2D matrix. In other words, you do not know the elements of the matrix, 
// but you do know the sums of each row and column.Find any matrix of non-negative integers of size rowSum.length x colSum.length 
// that satisfies the rowSum and colSum requirements.Return a 2D array representing any matrix that fulfills the requirements. 
// It's guaranteed that at least one matrix that fulfills the requirements exists.

// Example 1:

// Input: rowSum = [3,8], colSum = [4,7]
// Output: [[3,0],
//          [1,7]]
// Explanation: 
// 0th row: 3 + 0 = 3 == rowSum[0]
// 1st row: 1 + 7 = 8 == rowSum[1]
// 0th column: 3 + 1 = 4 == colSum[0]
// 1st column: 0 + 7 = 7 == colSum[1]
// The row and column sums match, and all matrix elements are non-negative.
// Another possible matrix is: [[1,2],
//                              [3,5]]
    public static void main(String[] args) {
        // Example input
        int[] rowSum = {3, 8};
        int[] colSum = {4, 7};

        // Call the method and store the result
        int[][] result = restoreMatrix(rowSum, colSum);

        // Print the resulting matrix
        System.out.println("Restored matrix:");
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int cur_row = 0, cur_col = 0;
        int[][] res = new int[rows][cols];

        while (cur_row < rows || cur_col < cols) {
            if (cur_row >= rows) {
                res[rows - 1][cur_col] = colSum[cur_col];
                cur_col++;
                continue;
            } else if (cur_col >= cols) {
                res[cur_row][cols - 1] = rowSum[cur_row];
                cur_row++;
                continue;
            }

            int value_to_put = Math.min(rowSum[cur_row], colSum[cur_col]);
            rowSum[cur_row] -= value_to_put;
            colSum[cur_col] -= value_to_put;
            res[cur_row][cur_col] = value_to_put;

            // I write this as this because it's possible that rowSum[cur_row] == colSum[cur_col] and 
            // we'll want to move both row and col pointers
            if (rowSum[cur_row] == 0) {
                cur_row++;
            }
            if (colSum[cur_col] == 0) {
                cur_col++;
            }
        }
        return res;
    }

}
