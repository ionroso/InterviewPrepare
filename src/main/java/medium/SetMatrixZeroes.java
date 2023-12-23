package medium;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            int[][] a = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
            new Solution().setZeroes(a);
            System.out.println();
        }
        class Solution {
            public void setZeroes(int[][] matrix) {
                int n = matrix.length;
                int m = matrix[0].length;
                boolean[] row = new boolean[n];
                boolean[] colum = new boolean[m];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(matrix[i][j] == 0) {
                            row[i] = true;
                            colum[j] = true;
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(row[i] || colum[i]) {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
        }
    }
}
