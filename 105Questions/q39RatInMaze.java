import java.util.*;

public class q39RatInMaze {
    public static void main(String[] args) {
        int[][] testcase = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {0, 1, 1, 1}
        };
        int n = testcase.length;
        ArrayList<String> result = findPath(testcase, n);
        Collections.sort(result);
        if (result.size() > 0) {
            for (String path : result) {
                System.out.print(path + " ");
            }
            System.out.println();
        } else {
            System.err.println(-1);
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if (m[0][0] == 1) {
            backTrack(m, n, 0, 0, "", res, visited);
        }
        return res;
    }

    public static void backTrack(int[][] m, int n, int r, int c, String path, ArrayList<String> res, boolean[][] visited) {
        // Base case: if the rat has reached the destination
        if (r == n - 1 && c == n - 1) {
            res.add(path);
            return;
        }

        // Check for out of bounds, visited cells, and obstacles
        if (r < 0 || c < 0 || visited[r][c] || r >= n || c >= n || m[r][c] == 0) {
            return;
        }

        visited[r][c] = true; // Mark the cell as visited

        // Move down
        backTrack(m, n, r + 1, c, path + "D", res, visited);
        // Move right
        backTrack(m, n, r, c + 1, path + "R", res, visited);
        // Move up
        backTrack(m, n, r - 1, c, path + "U", res, visited);
        // Move left
        backTrack(m, n, r, c - 1, path + "L", res, visited);

        visited[r][c] = false; // Unmark the cell for backtracking
    }
}
