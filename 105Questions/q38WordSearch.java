import java.util.Scanner;

class q38WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true; // Found the word
        }

        // Check boundaries and conditions
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true; // Mark the cell as visited

        // Explore all possible directions: down, up, right, left
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true; // If any direction leads to a solution
        }

        visited[i][j] = false; // Unmark the cell for backtracking
        return false; // No valid path found
    }

    public static void main(String[] args) {
        q38WordSearch solution = new q38WordSearch();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = scanner.nextInt();

        char[][] board = new char[rows][cols];

        System.out.println("Enter the board characters row by row:");
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
            if (row.length() != cols) {
                System.out.println("Row length does not match the number of columns. Please re-enter.");
                i--; // Decrement i to retry the current row
                continue;
            }
            for (int j = 0; j < cols; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        System.out.println("Enter the word to search: ");
        String word = scanner.next();

        boolean result = solution.exist(board, word);
        System.out.println("The word \"" + word + "\" is " + (result ? "found" : "not found") + " in the board.");
        
        scanner.close();
    }
}
