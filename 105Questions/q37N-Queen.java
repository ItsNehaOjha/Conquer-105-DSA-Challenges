import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both 
// indicate a queen and an empty space, respectively.


class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();

        int rowLeft[] = new int[n];
        int upDiagonal[] = new int[2 * n - 1];
        int lowDiagonal[] = new int[2 * n - 1];

        solve(0, board, res, rowLeft, upDiagonal, lowDiagonal);
        return res;
    }

    public void solve(int col, char[][] board, List<List<String>> res, int[] rLeft, int[] lowDiag, int[] upDiag) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (rLeft[row] == 0 && lowDiag[row + col] == 0 && upDiag[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                rLeft[row] = 1;
                lowDiag[row + col] = 1;
                upDiag[board.length - 1 + col - row] = 1;

                solve(col + 1, board, res, rLeft, lowDiag, upDiag);

                board[row][col] = '.';
                rLeft[row] = 0;
                lowDiag[row + col] = 0;
                upDiag[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        
        int n = 4; 
        List<List<String>> results = solveNQueens(n);

        for (List<String> solutionBoard : results) {
            for (String row : solutionBoard) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
