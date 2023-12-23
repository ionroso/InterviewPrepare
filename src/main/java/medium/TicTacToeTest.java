package medium;

import java.util.Arrays;

public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(2);
        System.out.println(ticTacToe.move(0, 1, 2));
        System.out.println(ticTacToe.move(1, 0, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
    }

    static
    class TicTacToe {
        int[][] board;
        int n;

        public TicTacToe(int n) {
            this.n = n;
            this.board = new int[n][n];
        }

        public int move(int row, int col, int player) {
            board[row][col] = player;
            return (checkRowCols(row, col, player) || checkDiagonals(row, col, player)) ? player : 0 ;
        }

        private boolean checkDiagonals(int row, int col, int player) {
            if(row != col){
                return false;
            }

            boolean validRow = true, validCol = true, validMainDiag = true, validSecondDiag = true;
            for (int i = 0; i < n; i++){
                if(board[i][i] != player){
                    validMainDiag = false;
                }
                if(board[i][n-i-1] != player){
                    validSecondDiag = false;
                }
                if(board[i][col] != player){
                    validCol = false;
                }
                if(board[row][i] != player){
                    validRow = false;
                }
            }

            return validRow || validCol || validMainDiag || validSecondDiag;
        }

        private boolean checkRowCols(int row, int col, int player) {
            for (int i = 0; i < n; i++){

            }

            return true;
        }
    }
}
