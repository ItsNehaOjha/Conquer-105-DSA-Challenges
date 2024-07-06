public class q43SudukoSolver {
    

//     37. Sudoku Solver

// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

    public static void main(String[] args) {
        // Example Sudoku board
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        printBoard(board);
    }
    private static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    public static boolean solve(char[][]board, int row, int col){
        if(row== board.length){
            return true;
        }

       // Move to next row when current row is fully filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        if( board[row][col]!= '.'){
            return solve(board, row, col+1);
            
        }
        for(char num ='1'; num<='9'; num++){
            if(isValid(board, row, col)){
                board[row][col]= num;
                if(isSafe(board, row , col+1)){
                    return true;
                }
                board[row][col]= '.'
            }
        }
        return false;

    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(board.length);
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;

        for (int r = rStart; r < rStart + sqrt; r++) {
            for (int c = cStart; c < cStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
    

}

