package medium;

public class NumberOfClosedIslands {
    int[] Y = {-1, 1, 0, 0};
    int[] X = {0, 0, -1, 1};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    Result rez = new Result();
                    dfs(grid, m, n, i, j, rez);
                    count+=rez.val? 1 : 0;
                }

            }
        }

        return count;
    }

    private void dfs(int[][] grid, int m, int n, int y, int x, Result r) {
        if(y==0 || x==0 || y == m-1 || x ==  n-1) r.val = false;

        grid[y][x] = 2;

        for (int i = 0; i < 4; i++) {
            int yd=y+Y[i];
            int xd=x+X[i];

            if(!validBoundaries(m, n, yd, xd)) continue;
            if(grid[yd][xd] != 0){
                continue;
            }
            dfs(grid, m, n, yd, xd, r);
        }

    }

    private static class Result {
        boolean val = true;
    }

    private boolean validBoundaries(int m, int n, int y, int x){
        return y>=0 && x>=0 && y < m && x < n;
    }
}
