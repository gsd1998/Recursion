package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueensOptimised {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        int[] left = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        solve(0, n, ans, board, left, lowerDiagonal, upperDiagonal);
        return ans;
    }

    public void solve(int col, int n, List<List<String>> ans, char[][] board, int[] left, int[] lowerDiagonal, int[] upperDiagonal){
        if(col == n){
            List<String> output = new ArrayList<>();
            for(int k=0; k < board.length; k++){
                String s = new String(board[k]);
                output.add(s);
            }
            ans.add(output);
            return;
        }
        for(int row = 0; row <= n-1; row++){
            if(left[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0){
                left[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[n-1+col-row] = 1;
                board[row][col] = 'Q';
                solve(col+1, n, ans, board, left, lowerDiagonal, upperDiagonal);
                left[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[n-1+col-row] = 0;
                board[row][col] = '.';
            }
        }
    }
}
