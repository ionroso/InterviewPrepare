package medium;

public class RemoveAllOnesWithRowAndColumnFlips {
    public static void main(String[] args) {

    }
    public boolean removeOnes(int[][] grid) {
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if(!validSquare(grid, i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validSquare(int[][] grid, int x, int y) {
        int count = grid[x][y] + grid[x][y+1] + grid[x+1][y] + grid[x+1][y+1];

        return count % 2  == 0;
    }
}
