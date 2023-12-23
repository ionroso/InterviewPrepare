package medium;

public class NumberOfEnclaves {
    private static final int[] Y = {-1, 1, 0, 0};
    private static final int[] X = {0, 0, -1 , 1};

    public int numEnclaves(int[][] grid) {
        for(int i=0; i<getM(grid); i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0);
            }
        }

        for(int i=0; i<getN(grid); i++){
            if(grid[0][i] == 1){
                dfs(grid, 0, i);
            }
        }

        for(int i=0; i<getM(grid); i++){
            if(grid[i][getN(grid)-1] == 1){
                dfs(grid, i, getN(grid)-1);
            }
        }

        for(int i=0; i<getN(grid); i++){
            if(grid[getM(grid)-1][i] == 1){
                dfs(grid, getM(grid)-1, i);
            }
        }

        int count = 0;
        for(int i=0; i<getM(grid); i++){
            for (int j = 0; j < getN(grid); j++) {
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int y, int x) {
        if(y<0 || x<0 || y>=getM(grid) || x>= getN(grid)){
            return;
        }

        if(grid[y][x] != 1){
            return;
        }

        grid[y][x] = 2;

        for(int c = 0; c < 4 ; c++){
           dfs(grid, y+Y[c], x+X[c]);
        }
    }

    private int getM(int[][] array){
        return array.length;
    }

    private int getN(int[][] array){
        return array[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new NumberOfEnclaves().numEnclaves(grid));
    }
}
