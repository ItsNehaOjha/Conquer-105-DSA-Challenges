class q31SetMatrixZero {


// 73. Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.You must do it in place.
// Input:
//  matrix=
// [[1,1,1],
// [1,0,1],
// [1,1,1]]

// Output:
// [[1,0,1],
// [0,0,0],
// [1,0,1]]

// Explanation:
//  Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = zeroMatrixSol1(matrix, n, m);

        ArrayList<ArrayList<Integer>> ans = zeroMatrixSol2(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    // brute froce approach  of TC:  O((N*M)*(N + M)) + O(N*M) almost o(N^3)
    // If any cell (i,j) contains the value 0, we will mark all cells in row i and column j with -1 except those which contain 0.

    public static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        // set all non-zero elements as -1 in the row i:
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }
    static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
        // set all non-zero elements as -1 in the col j:
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }
    static ArrayList<ArrayList<Integer>> zeroMatrixSol1(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, n, m, j);
                }
            }
        }
        // Finally, mark all -1 as 0:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    //better approach of TC   O(2*(N*M)):  We will traversing the entire matrix 2 times and each traversal is taking O(N*M) time complexity.
                        //  Space Complexity: O(N) + O(M), where N = no. of rows in the matrix and M = no. of columns in the matrix.
                        // Reason: O(N) is for using the row array and O(M) is for using the col array.

                    // EXPLAINATION :-

// In the previous approach, we were marking the cells with -1 while traversing the matrix. But in this approach, we are not marking
//  the entire row and column instead, we are marking the ith index of row array i.e. row[i], and jth index of col array i.e. col[j] 
//  with 1. These marked indices of the two arrays, row and col will tell us for which rows and columns we need to change the values 
//  to 0. For any cell (i, j), if the row[i] or col[j] is marked with 1, we will change the value of cell(i, j) to 0.
// Here we are marking the cells after traversal whereas in the previous case, we were marking the cells while traversal. 
// That is how the time complexity reduces in this case.
                        
    public static ArrayList<ArrayList<Integer>> zeroMatrixSOL2(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int[] row = new int[n]; // row array
        int[] col = new int[m]; // col array

        // Traverse the matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark ith index of row wih 1:
                    row[i] = 1;

                    // mark jth index of col wih 1:
                    col[j] = 1;
                }
            }
        }

        // Finally, mark all (i, j) as 0
        // if row[i] or col[j] is marked with 1.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

                      
    
    //OPTIMAL APPROACH 

// In the previous approach, the time complexity is minimal as the traversal of a matrix takes at least O(N*M)(where N = row 
// and M = column). In this approach, we can just improve the space complexity. So, instead of using two extra matrices row and 
// col, we will use the 1st row and 1st column of the given matrix to keep a track of the cells that need to be marked with 0. 
// But here comes a problem. If we try to use the 1st row and 1st column to serve the purpose, the cell matrix[0][0] is taken twice.
// To solve this problem we will take an extra variable col0 initialized with 1. Now the entire 1st row of the matrix will serve
// the purpose of the row array. And the 1st column from (0,1) to (0,m-1) with the col0 variable will serve the purpose of the col array.


    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // int[] row = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]

        int col0 = 1;
        // step 1: Traverse the matrix and
        // mark 1st row & col accordingly:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // mark i-th row:
                    matrix.get(i).set(0, 0);

                    // mark j-th column:
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    // check for col & row:
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }

}
