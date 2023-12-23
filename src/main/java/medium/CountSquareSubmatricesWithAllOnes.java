package medium;

public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] matrix =  new int[][] {
              {0,1,1,1},
              {1,1,1,1},
              {0,1,1,1}
        };

        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(matrix));
    }
    public int countSquares(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    count++;
                    int maxSize = Math.min(m-i, n-j);
                    for (int k = 2; k < maxSize; k++) {
                        if(validSquares(matrix, i, j , k))
                            count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean validSquares(int[][] matrix, int r, int c, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrix[r+i][c+j] != 1) return false;
            }
        }
        return true;
    }
}
