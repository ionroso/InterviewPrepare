package medium;


public class NumberOfProvinces {


    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(new NumberOfProvinces().findCircleNum(grid));
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[][] visited = new int[n][isConnected[0].length];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (visited[i][j] == 1 || visited[j][i] == 1 || isConnected[i][j] == 0) {
                    continue;
                }

                dfs(isConnected, visited, n, i, j);
                count++;
            }

        }

        return count;
    }

    private void dfs(int[][] isConnected, int[][] visited, int n, int y, int x) {
        visited[y][x] = 1;
        visited[x][y] = 1;

        for (int i = 0; i < n; i++) {
            if (visited[y][i] == 1 || isConnected[y][i] == 0) {
                continue;
            }

            dfs(isConnected, visited, n, y, i);
        }
    }

}
