import java.util.Scanner;

class Solution {
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
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of columns: ");
        int cols = scanner.nextInt();

        char[][] board = new char[rows][cols];

        System.out.println("Enter the board characters row by row:");
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
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
