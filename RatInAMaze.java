package interviewQA.Recursion;

import java.util.ArrayList;

public class RatInAMaze {
    public static void main(String[] args) {
        int n = 4;
        int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        ArrayList<String> direction = findPath(a, n);
        System.out.println(direction);//[DDRDRR, DRDDRR]
    }

    public static ArrayList<String> findPath(int[][] maze, int n) {
        int vis[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 0;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        if (maze[0][0] == 1) {
            solve(0, 0, maze, n, ans, "", vis);
        }
        return ans;
    }

    private static void solve(int row, int col, int[][] maze, int n, ArrayList<String> ans, String dir, int[][] vis) {
        if(row == n-1 && col == n-1){
            ans.add(dir);
            return;
        }
        //down
        if(row + 1 < n && maze[row+1][col] == 1 && vis[row+1][col] != 1) {
            vis[row][col] = 1;
            solve(row + 1, col, maze, n, ans, dir + 'D', vis);
            vis[row][col] = 0;
        }
        //left
        if(col - 1 >= 0 && maze[row][col-1] == 1 && vis[row][col-1] != 1) {
            vis[row][col] = 1;
            solve(row, col - 1, maze, n, ans, dir + 'L', vis);
            vis[row][col] = 0;
        }
        //right
        if(col + 1 < n && maze[row][col+1] == 1 && vis[row][col+1] != 1) {
            vis[row][col] = 1;
            solve(row, col + 1, maze, n, ans, dir + 'R', vis);
            vis[row][col] = 0;
        }
        //up
        if(row - 1 >= 0 && maze[row-1][col] == 1 && vis[row-1][col] != 1) {
            vis[row][col] = 1;
            solve(row - 1, col, maze, n, ans, dir + 'R', vis);
            vis[row][col] = 0;
        }
    }

}
