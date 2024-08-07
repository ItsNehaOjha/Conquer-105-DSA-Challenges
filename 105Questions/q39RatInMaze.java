import java.util.*;
public class q39RatInMaze {
    public static void main(String[] args) {
        int[][] testcase={
            {1,0,0,0},
            {1,1,0,1},
            {0,1,0,0},
            {0,1,1,1}
            
        };
        int n= testcase.length;
        ArrayList<String> result = findPath(tsetcase, n);
        Collections.sort(result);
        if(result.size()>0){
            for(int j=0;j< result.size();j++){
                System.out.print(result.get(j));
            }
            System.out.println();
        }
        else{
            System.err.println(-1);
        }
    }
    public static ArrayList<String> findPath(int[][]m, int n){
        ArrayList<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        if(m[0][0]==1){
            backTrack(m, n, 0, 0, "",res, visited);
        }
        return res;
    }
    public static void backTrack(int[][]m, int n, int r, int c, String path, boolean[][] visited){
        if(r == n-1 && c == n-1){
            res.add(path);
            return;
        }
        if(r < 0 || c < 0 || visited[r][c] || r >= n || c>=n || maze[r][c]==0){
            return false;
        }

        visited[r][c]= true;

        backTrack(m, n, r+1, c, p+"D", visited);
        backTrack(m, n, r, c+1, p+"R", visited);
        backTrack(m, n, r-1, c, p+"U", visited);
        backTrack(m, n, r, c-1, p+"L", visited);

        visited[r][c]= false;
    }
command:java.show.server.task.status
}
