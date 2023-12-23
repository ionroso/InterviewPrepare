package medium;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] g = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(g));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int max = 0;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) continue;
                if(visited[i][j] != 0) continue;

                Count c = new Count();
                c.val=1;
                dfs(grid, visited, i, j, c);

                max = Math.max(max, c.val);
            }
        }
        System.out.println();
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }



        return max;
    }

    void dfs(int[][] g, int[][] v, int i, int j,  Count c){
        if(v[i][j] != 0) return;
        if(g[i][j] == 0) return;

        v[i][j] = c.val;
        c.val++;
        if(i-1 >= 0){
            dfs(g, v, i-1, j, c);
        }

        if(i+1 < g.length){
            dfs(g, v, i+1, j, c);
        }

        if(j-1 >= 0){
            dfs(g, v, i, j-1, c);
        }

        if(j+1 < g[0].length){
            dfs(g, v, i, j+1, c);
        }
    }

    class Count {
        int val;
    }

}
