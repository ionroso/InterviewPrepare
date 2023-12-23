package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpiralMatrix {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            List<Integer> rez = new Solution().spiralOrder(new int[][]{{1}});
            System.out.println(rez);
        }

        class Solution {
            public List<Integer> spiralOrder(int[][] matrix) {
                int[][] visited = new int[matrix.length][matrix[0].length];
                List<Integer> output = new ArrayList<>();
                int n = matrix.length;
                int m = matrix[0].length;
                for(int i = 0; i < Math.min(matrix.length, matrix[0].length); i++){
                    if(visited[i][i] == 1){
                        break;
                    }
                    perimeterIterator(matrix, i, i, n, m, visited, output);
                    n-=2;
                    m-=2;
                }

                return output;
            }

            private void perimeterIterator(int[][] matrix, int r0, int c0, int n, int m, int[][] visited, List<Integer> output){
                for(int i = 0; i < m; i++){
                    output.add(matrix[r0][c0+i]);
                    visited[r0][c0+i] = 1;
                }
                for(int i = 0; i < n-1; i++){
                    if(visited[r0+i+1][c0+m-1] == 1){
                        break;
                    }
                    output.add(matrix[r0+i+1][c0+m-1]);
                    visited[r0+i+1][c0+m-1] = 1;
                }
                for(int i = 0; i < m-1; i++){
                    if(visited[r0+n-1][c0+m-2-i] == 1){
                        break;
                    }
                    output.add(matrix[r0+n-1][c0+m-2-i]);
                    visited[r0+n-1][c0+m-2-i] = 1;
                }
                for(int i = 0; i < n-2; i++){
                    if(visited[r0+n-2-i][c0] == 1){
                        break;
                    }
                    output.add(matrix[r0+n-2-i][c0]);
                    visited[r0+n-2-i][c0] = 1;
                }
            }
        }
    }
}
