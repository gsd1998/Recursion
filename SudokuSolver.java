package interviewQA.Recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i <= board.length-1; i++){
            for(int j = 0; j <= board[0].length-1; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValidToPlace(c,board,i,j)){
                            board[i][j] = c;
                            if(solve(board) == true){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidToPlace(char c, char[][] board, int row, int col){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c){
                return false;
            }
            if(board[row][i] == c){
                return false;
            }
            if(board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == c){
                return false;
            }
        }
        return true;
    }
}
