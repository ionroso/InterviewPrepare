package medium;

public class BattleshipsInABoard {
    int[] r = {0, -1, 0, 1};
    int[] c = {-1, 0, 1, 0};
    public static void main(String[] args) {

    }
    public int countBattleships(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(visited[i][j]) continue;

                if(board[i][j] == 'X')
                    dfs(board, visited, i, j);
                }
            }

        return count;
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if((i<0 || i >= board.length) || (j<0 || j >= board[0].length )) return;

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int y = i + r[k];
            int x = j + c[k];
            if((y < 0 || y >= board.length) || (x < 0 || x >= board[0].length ))

            if(visited[y][x]) continue;

            if(board[y][x] == 'X')
                dfs(board, visited, y, x);
        }
    }
}
