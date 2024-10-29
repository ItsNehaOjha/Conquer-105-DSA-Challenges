import java.util.*;

public class practice {
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
            for (int j = 0; j < result.size(); j++) {
                System.out.println(result.get(j));
            }
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
        if (r == n - 1 && c == n - 1) {
            res.add(path);
            return;
        }
        if (r < 0 || c < 0 || visited[r][c] || r >= n || c >= n || m[r][c] == 0) {
            return;
        }

        visited[r][c] = true;

        backTrack(m, n, r + 1, c, path + "D", res, visited);
        backTrack(m, n, r, c + 1, path + "R", res, visited);
        backTrack(m, n, r - 1, c, path + "U", res, visited);
        backTrack(m, n, r, c - 1, path + "L", res, visited);

        visited[r][c] = false;
    }
}
