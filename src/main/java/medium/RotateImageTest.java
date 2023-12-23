package medium;

public class RotateImageTest {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//            int[][] a = new int[][]{{1,2},{3,4}};
            new Solution().rotate(a);
            System.out.println();
        }

            class Solution {
                public void rotate(int[][] matrix) {
                    int n = matrix.length;
                    for(int p=0; p<n/2;p++){
                        rotatePerimeter(matrix, n-p-p /* n */, p /* r */, p /*c */   );
                    }
                }

                private void rotatePerimeter(int[][] matrix, int n, int y0, int x0){
                    for (int i = 0; i < n-1; i++) {
                        int temp = matrix[y0][x0+i];
                        matrix[y0][x0+i] = matrix[y0+n-1-i][x0];
                        matrix[y0+n-1-i][x0] = matrix[y0+n-1][x0+n-1-i];
                        matrix[y0+n-1][x0+n-1-i] = matrix[y0+i][x0+n-1];
                        matrix[y0+i][x0+n-1] = temp;
                    }
                }
            }

    }
}
