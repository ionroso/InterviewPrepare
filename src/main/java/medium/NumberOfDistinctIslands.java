package medium;

import java.util.*;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        int [][]grid = new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(new NumberOfDistinctIslands().numDistinctIslands(grid));
    }
    int[] Y = {-1,1,0,0};
    int[] X = {0,0,-1,1};
    class Coord{
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    class Offset{
        int yOffset;
        int xOffset;

        public Offset(int yOffset, int xOffset) {

            this.yOffset = yOffset;
            this.xOffset = xOffset;
        }
    }
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Coord>> list = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if(visited[y][x]) continue;

                if(grid[y][x] == 0) continue;

                List<Coord> output = new ArrayList<>();
                dfs(grid, visited, output, m, n, y, x);
                list.add(output);
            }
        }

        Set<Integer> foundMatch = new HashSet<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Coord> shape = list.get(i);
            if(foundMatch.contains(i)) continue;
            foundMatch.add(i);

            count++;

            for (int j = i+1; j < list.size(); j++) {
                List<Coord> shapeToMatch = list.get(j);
                if(isSameShape(shape, shapeToMatch)){
                    foundMatch.add(j);
                }
            }
        }

        return count;

    }

    private Offset getOffset(List<Coord> shape) {
        int yOffset=-1, xOffset=-1;
        for (Coord coord : shape) {
            if(yOffset == -1 && xOffset==-1){
                yOffset=coord.y;
                xOffset=coord.x;
            } else {
                yOffset = Math.min(yOffset, coord.y);
                xOffset = Math.min(xOffset, coord.x);
            }
        }
        return new Offset(yOffset, xOffset);
    }

    private boolean isSameShape(List<Coord> shape, List<Coord> shapeToMatch) {
        if(shape.size()!=shapeToMatch.size()) return false;

        Offset shapeOffset = getOffset(shape);
        Offset shapeToMatchOffset = getOffset(shapeToMatch);


        for (int i = 0; i < shape.size(); i++) {
            Coord shapeCoord = shape.get(i);
            Coord shapeToMatchCoord = shapeToMatch.get(i);
            if(shapeCoord.y-shapeOffset.yOffset != shapeToMatchCoord.y - shapeToMatchOffset.yOffset || shapeCoord.x - shapeOffset.xOffset != shapeToMatchCoord.x - shapeToMatchOffset.xOffset) return false;
        }

        return true;
    }

    private void dfs(int[][] grid, boolean[][] visited, List<Coord> output, int m, int n, int y, int x) {
        visited[y][x]=true;
        output.add(new Coord(y,x));
        for (int i = 0; i < 4; i++) {
            int yd=y+Y[i];
            int xd=x+X[i];

            if(!validBoundaries(m, n, yd, xd)) continue;
            if(visited[yd][xd]) continue;
            if(grid[yd][xd] == 0) continue;

            dfs(grid, visited, output, m, n, yd, xd);
        }
    }

    private boolean validBoundaries(int m, int n, int y, int x){
        return y>=0 && x>=0 && y < m && x < n;
    }
}
