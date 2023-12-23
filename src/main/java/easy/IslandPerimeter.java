package easy;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = {{1,1},{1,1}};
        System.out.println(islandPerimeter.islandPerimeter(grid));
    }
    class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int[] r_wise = new int[] {-1, 1, 0, 0};
    int[] c_wise = new int[] {0, 0, -1, 1};
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;

        int n = grid[0].length;
        if(n == 0) return 0;

        Queue<Point> queue = new LinkedList<>();
        // 0 - not visited, 5 - in queue, 10 - visited
        int[][] state = new int[m][n];
        Point start = startPoint(grid);
        queue.offer(start);

        int perm = 0;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            state[p.r][p.c] = 10;

            if((p.r + (-1) >= 0 && grid[p.r + (-1)][p.c] == 0) || p.r == 0){
                perm++;
            }

            if((p.r + 1 < m && grid[p.r + 1][p.c] == 0) || p.r == m-1 ){
                perm++;
            }

            if((p.c + (-1) >= 0 && grid[p.r][p.c + (-1)] == 0) || p.c == 0){
                perm++;
            }

            if((p.c + 1 < n && grid[p.r][p.c + 1] == 0) || p.c == n-1){
                perm++;
            }

            for (int i = 0; i < 4; i++) {
                int rr = p.r+r_wise[i];
                int cc = p.c+c_wise[i];

                if(rr < 0 || cc < 0 || rr >= m || cc >= n) continue;
                if(state[rr][cc] == 10 || state[rr][cc] == 5) continue;
                if(grid[rr][cc] == 0) continue;

                queue.offer(new Point(rr,cc));
                state[rr][cc] = 5;
            }

        }

        return perm;
    }

    public Point startPoint(int[][] grid){
        boolean found = false;
        int i = 0, j = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        return new Point(i,j);
    }
}
