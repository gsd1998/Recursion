package interviewQA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        solve(0, n, ans, board);
        return ans;
    }

    public void solve(int col, int n, List<List<String>> ans, char[][] board){
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
            if(canPlaceTheQueen(row,col,board,n)){
                board[row][col] = 'Q';
                solve(col+1, n, ans, board);
                board[row][col] = '.';
            }
        }
    }

    public boolean canPlaceTheQueen(int row, int col, char[][] board, int n){
        int rowDup = row;
        int colDup = col;

        while(row >=0 && col >=0){
            while(col >=0){
                if(board[row][col] == 'Q'){
                    return false;
                }
                col--;
            }
            row = rowDup;
            col = colDup;
            while(row < n && col >= 0){
                if(board[row][col] == 'Q'){
                    return false;
                }
                row++;
                col--;
            }
            row = rowDup;
            col = colDup;
            while(row >=0 && col >=0){
                if(board[row][col] == 'Q'){
                    return false;
                }
                row--;
                col--;
            }
        }
        return true;
    }

}
