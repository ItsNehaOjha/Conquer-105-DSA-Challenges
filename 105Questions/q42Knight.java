public class q42Knight {

    // 2596. Check Knight Tour Configuration
    //Input: grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
    //Output: true
    //Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.

    public static void main(String[] args) {
        // Example input
        int[][] grid = {
            {0, 11, 16, 5, 20},
            {17, 4, 19, 10, 15},
            {12, 1, 8, 21, 6},
            {3, 18, 23, 14, 9},
            {24, 13, 2, 7, 22}
        };

        // Check if the grid is a valid knight tour configuration
        boolean isValid = checkValidGrid(grid);

        // Output the result
        System.out.println("Is the knight tour configuration valid? " + isValid);
    }

    public static boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        return helper(grid, 0, 0, 0);
    }

    public static boolean helper(int[][] grid, int row, int col, int num) {
        int len = grid.length;
        if (grid[row][col] == len * len - 1) {
            return true;
        }
        int i, j;

        // Check all possible knight moves
        i = row - 2;
        j = col - 1;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row - 2;
        j = col + 1;
        if (i >= 0 && j < len && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row + 2;
        j = col - 1;
        if (i < len && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row + 2;
        j = col + 1;
        if (i < len && j < len && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row - 1;
        j = col - 2;
        if (i >= 0 && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row - 1;
        j = col + 2;
        if (i >= 0 && j < len && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row + 1;
        j = col - 2;
        if (i < len && j >= 0 && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        i = row + 1;
        j = col + 2;
        if (i < len && j < len && grid[i][j] == num + 1) {
            return helper(grid, i, j, num + 1);
        }

        return false;
    }

    // or a short for loop for all the valid path
    public static boolean helper(int[][] grid, int row, int col, int num) {
        int len = grid.length;
        if (grid[row][col] == len * len - 1) {
            return true;
        }

        // Mark the current cell as visited
        int temp = grid[row][col];
        grid[row][col] = -1;

        // Define all possible knight moves
        int[][] moves = {
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
        };

        // Check all possible knight moves
        for (int[] move : moves) {
            int i = row + move[0];
            int j = col + move[1];
            if (i >= 0 && i < len && j >= 0 && j < len && grid[i][j] == num + 1) {
                if (helper(grid, i, j, num + 1)) {
                    return true;
                }
            }
        }

        // Unmark the current cell (backtrack)
        grid[row][col] = temp;

        return false;
    }
}
