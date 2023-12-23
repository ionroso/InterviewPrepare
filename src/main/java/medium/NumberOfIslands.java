package medium;



public class NumberOfIslands {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().numIslands(new char[][]
                    {{'1','1','1','1','0'},
                     {'1','1','0','1','0'},
                     {'1','1','0','0','0'},
                     {'0','0','0','0','0'}}));
        }

        class Solution {

            private static final int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1,0}};
            public int numIslands(char[][] grid) {
                int n = grid.length;
                int m = grid[0].length;
                int count = 0;

                boolean [][] visited = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(visited[i][j] || grid[i][j] == '0') {
                            continue;
                        }
                        dfs(grid, i, j, visited);
                        count++;
                    }
                }


                return count;

            }

            private void dfs(char[][] grid, int r, int c, boolean[][] visited) {

                visited[r][c] = true;

                for (int k = 0; k < 4; k++) {
                    int rNew = r+direction[k][0];
                    int  cNew= c + direction[k][1];
                    if(rNew<0 || cNew < 0 || rNew >= grid.length || cNew >= grid[0].length) {
                        continue;
                    }

                    if(visited[rNew][cNew] || grid[rNew][cNew] == '0'){
                        continue;
                    }
                    dfs(grid, rNew, cNew, visited);
                }
            }
        }
    }
}
