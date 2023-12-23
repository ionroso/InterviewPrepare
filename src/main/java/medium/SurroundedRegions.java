package medium;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X','X'},{'X','X','X','X','X'},{'X','X','X','O','X'},{'X','X','O','O','O'},{'X','X','O','X','O'}};
        new SurroundedRegions().solve(board);
        System.out.println();
    }

    int[] Y = {-1,1,0,0};
    int[] X = {0,0,-1,1};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if(board[y][x]!='O') continue;
                if(visited[y][x]) continue;
                Surrounded sur = new Surrounded();
                dfs(board, visited, m, n, y, x, sur);
                if(sur.val)
                    dfs(board, m, n, y, x);
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited , int m, int n, int y, int x, Surrounded sur) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int yd=y+Y[i];
            int xd=x+X[i];

            if(yd<0 || xd<0 || yd == m || xd == n){
                sur.val = false;
                continue;
            }

            if(board[yd][xd]!='O') continue;
            if(visited[yd][xd]) continue;

            dfs(board, visited, m, n, yd, xd, sur);
        }
    }

    private void dfs(char[][] board, int m, int n, int y, int x) {
        board[y][x] = 'X';

        for (int i = 0; i < 4; i++) {
            int yd=y+Y[i];
            int xd=x+X[i];

            if(board[yd][xd]=='X') continue;
            dfs(board, m, n, yd, xd);
        }
    }

    class Surrounded  {
        boolean val = true;
    }
}
