package medium;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestBridge {

    public static void main(String[] args) {
        new Test().test();
    }

    // 1. find one of the components
    // 2. change from 1 to 2
    // 3. get next layer to the perimeter
    // 4. explore with bfs until the first connection with 2nd island

    private static class Test {
        public void test() {
            System.out.println(new Solution().shortestBridge(new int[][]{{1,0},{0,1}}));
        }

        class Solution {
            private final static int[][] direction = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
            public int shortestBridge(int[][] grid) {
                int n = grid.length;
                int m = grid[0].length;


                // 1. find one of the components
                int i1_r=-1, i1_c = -1;
                Result result = getResult(grid, n, m, i1_r, i1_c);

                Deque<Position> q = new LinkedList<>();
                dfs(grid, n, m, result.i1_r(), result.i1_c(), q);


                return bfs(grid, n, m, result.i1_r(), result.i1_c(), q);
            }

            private Result getResult(int[][] grid, int n, int m, int i1_r, int i1_c) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(grid[i][j] == 1){
                            i1_r = i;
                            i1_c = j;
                            break;
                        }
                    }
                    if(i1_r != -1 && i1_c != -1){
                        break;
                    }
                }
                Result result = new Result(i1_r, i1_c);
                return result;
            }

            private record Result(int i1_r, int i1_c) {
            }

            private int bfs(int[][] grid, int n, int m, int i1R, int i1C, Deque<Position> curr) {
                int bridge = 0;

                Deque<Position> next = new LinkedList<>();

                while (!curr.isEmpty()) {
                    Position p = curr.getFirst();

                    for (int i = 0; i < 4; i++) {
                        if(inside(grid, n, m, i1R + direction[i][0], i1C + direction[i][1])){
                            Position p1 = new Position(i1R + direction[i][0], i1C + direction[i][1]);
                            grid[p1.i1R][p1.i1C] = 100;

                        }

                    }





                }

                return 0;
            }

            private boolean inside(int[][] grid, int n, int m, int i1R, int i1C) {
                return i1R>=0 && i1C >= 0 && i1R < n && i1C < m;
            }

            private void dfs(int[][] grid, int n, int m, int i1R, int i1C, Deque<Position> q) {
                if(!inside(grid, n, m, i1R, i1C)){
                    return;
                }

                if(grid[i1R][i1C] == 0) {
                    q.addLast(new Position(i1R, i1C));
                    return;
                }

                if(grid[i1R][i1C] == 10 || grid[i1R][i1C] != 1) {
                    return;
                }


                grid[i1R][i1C] = 10;

                for (int i = 0; i < 4; i++) {
                    dfs(grid, n, m, i1R + direction[i][0], i1C + direction[i][1], q);
                }
            }

            private class Position {
                private final int i1R;
                private final int i1C;

                public Position(int i1R, int i1C) {

                    this.i1R = i1R;
                    this.i1C = i1C;
                }
            }
        }
    }

}
