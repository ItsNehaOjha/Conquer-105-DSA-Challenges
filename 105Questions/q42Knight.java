public class q42Knight {

    // 2596. Check Knight Tour Configuration
    // Input: grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
    // Output: true
    // Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.

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
        if (grid[0][0] != 0) return false; // The starting point must be 0
        return helper(grid, 0, 0, 0); // Start from the first cell
    }

    public static boolean helper(int[][] grid, int row, int col, int num) {
        int len = grid.length;
        if (num == len * len - 1) { // Check if we have reached the last number
            return true;
        }

        // Define all possible knight moves
        int[][] moves = {
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1},
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2}
        };

        // Check all possible knight moves
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            // Ensure the new position is valid and has the next number
            if (newRow >= 0 && newRow < len && newCol >= 0 && newCol < len && grid[newRow][newCol] == num + 1) {
                // Mark the current cell as visited
                int temp = grid[row][col];
                grid[row][col] = -1; // Mark as visited

                // Recur for the next number
                if (helper(grid, newRow, newCol, num + 1)) {
                    return true;
                }

                // Backtrack
                grid[row][col] = temp; // Unmark the visited cell
            }
        }
        
        return false; // No valid path found
    }
}
