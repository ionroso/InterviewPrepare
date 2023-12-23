package medium;

import utility.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathWithMinimumEffort {
    int[] Y = {-1, 1, 0, 0};
    int[] X = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] h = Matrix.matrixStrToMatrix("[[1,2,2],[3,8,2],[5,3,5]]");
        System.out.println(new PathWithMinimumEffort().minimumEffortPath(h));
    }
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int rez1 = dfs(heights, m, n, new boolean[m][n], 0, 1, Math.abs(heights[0][0]-heights[0][1]));
        int rez2 = dfs(heights, m, n, new boolean[m][n], 1, 0,  Math.abs(heights[0][0]-heights[1][0]));

        return Math.min(rez1, rez2);
    }

    private int dfs(int[][] heights, int m, int n, boolean[][] visited, int y, int x, int effortSoFar) {
        visited[y][x]=true;

        if(y==m-1 && x==n-1) return effortSoFar;

        List<Integer> rez = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int yd = y + Y[i];
            int xd = x + X[i];

            if(!validBoundaries(m, n, yd, xd)) continue;
            if(visited[yd][xd]) continue;

            int currEffort = Math.abs(heights[yd][xd]-heights[y][x]);
            int dfsMin = dfs(heights,m,n,visited,yd,xd, Math.max(currEffort, currEffort));
            rez.add(dfsMin);
        }

        visited[y][x]=false;
        return rez.size() > 0 ? Collections.min(rez) : Integer.MAX_VALUE;

    }

    private boolean validBoundaries(int m, int n, int y, int x){
        return y>=0 && x>=0 && y < m && x < n;
    }


}
