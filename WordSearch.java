package interviewQA.Recursion;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int index = 0;
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j <= m-1; j++){
                if(board[i][j] == word.charAt(index)){
                    if(searchIfWordExists(i,j,board,m,n,index,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchIfWordExists(int row, int col, char[][] board, int m, int n, int index, String word) {
        if(index == word.length()){
            return true;
        }
        if(row == n || col == m || row < 0 || col < 0 || board[row][col] != word.charAt(index) || board[row][col] == '1'){
            return false;
        }
        char c = board[row][col];
        board[row][col] = '1';
        boolean down = searchIfWordExists(row+1,col,board,m,n,index+1,word);
        boolean left = searchIfWordExists(row,col-1,board,m,n,index+1,word);
        boolean right = searchIfWordExists(row,col+1,board,m,n,index+1,word);
        boolean up = searchIfWordExists(row-1,col,board,m,n,index+1,word);
        board[row][col] = c;
        return down || left || right || up;
    }

}
