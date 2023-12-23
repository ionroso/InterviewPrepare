package easy;

import utility.Matrix;

public class FindWinnerOnATicTacToeGame {
    public static void main(String[] args) {
        System.out.println(new FindWinnerOnATicTacToeGame().tictactoe(new int[][]{{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}}));
    }
    public String tictactoeBest(int[][] moves) {

        int [][] rcd = new int[3][3]; // rcd[0] --> rows , rcd[1] --> columns , rcd[2] --> diagonals

        for(int turn =0 ; turn < moves.length ; turn++){

            int AorB =-1;
            if(turn%2==0){AorB=1;}

            int y = moves[turn][0];
            int x = moves[turn][1];

            rcd[0][y]+= AorB;
            rcd[1][x]+= AorB;

            if(y == x){rcd[2][0]+=AorB;}     // first diagonal
            if(y+x-2 == 0){rcd[2][1]+=AorB;} //2nd diagonal

            if( Math.abs(rcd[0][y]) == 3 || Math.abs(rcd[1][x]) == 3
                    ||Math.abs(rcd[2][0]) ==3 || Math.abs(rcd[2][1]) ==3  ){

                return AorB == 1 ? "A" : "B"; }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    public String tictactoe(int[][] moves) {
        boolean turnA = true;

        char[][]board = new char[3][3];
        int m = 3;
        int n = 3;

        int countMoves = 0;
        for (int i = 0; i < moves.length; i++) {
            int y = moves[i][0];
            int x = moves[i][1];
            if(turnA){
                board[y][x] = 'X';
            } else {
                board[y][x] = 'O';
            }

            if(validColumn(x, board) || validRow(y, board) || hasWonNWSEDiag(board, m, n, y, x) || hasWonNESWDiag(board, m, n, y, x )) {
                return turnA ? "A" : "B";
            }
            turnA=!turnA;
            countMoves++;
        }

        return countMoves == 9 ? "Draw" : "Pending";
    }

    boolean hasWonNWSEDiag(char[][]b, int m, int n, int y, int x){
        Coord nw = findNWDiagParent(m, n, y, x);
        Coord se = findSEDiagParent(m, n, y, x);
        int dist = dist(nw.y, nw.x, se.y, se.x);
        if(dist != 3) return false;

        char c = b[y][x];
        for (int i = 0; i < 3; i++) {
            if(b[nw.y+i][nw.x+i]!=c) return false;
        }

        return true;
    }

    boolean hasWonNESWDiag(char[][]b, int m, int n, int y, int x){
        Coord ne = findNEDiagParent(m, n, y, x);
        Coord sw = findSWDiagParent(m, n, y, x);
        int dist = dist(ne.y, ne.x, sw.y, sw.x);
        if(dist != 3) return false;

        char c = b[y][x];
        for (int i = 0; i < 3; i++) {
            if(b[ne.y+i][ne.x-i]!=c) return false;
        }

        return true;
    }


    boolean validColumn(int cn, char[][]b){
        char c = b[0][cn];
        for (int i = 1; i < b.length; i++) {
            if(c != b[i][cn]){
                return false;
            }
        }

        return true;
    }

    boolean validRow(int rn, char[][]b){
        char c = b[rn][0];
        for (int i = 1; i < b.length; i++) {
            if(c != b[rn][i]){
                return false;
            }
        }

        return true;
    }

    class Coord {
        int y,x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    int dist(int y2, int x2, int y1, int x1){
        return 1 + (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    Coord findNEDiagParent(int m, int n, int y, int x){
        int min = Math.min(y,n-1-x);
        return new Coord(y-min, x+min);
    }

    Coord findSWDiagParent(int m, int n, int y, int x){
        int min = Math.min(m-1-y, x);
        return new Coord(y+min, x-min);
    }

    Coord findNWDiagParent(int m, int n, int y, int x){
        int min = Math.min(y,x);
        return new Coord(y-min, x-min);
    }

    Coord findSEDiagParent(int m, int n, int y, int x){
        int min = Math.min(m-y-1,n-x-1);
        return new Coord(y+min, x+min);
    }

}

