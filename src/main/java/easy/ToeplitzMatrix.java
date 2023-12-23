package easy;

import java.util.Stack;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{11,74,0,93},{40,11,74,7}};
        System.out.println(new ToeplitzMatrix().isToeplitzMatrix(matrix));
    }
    class Coord {
        int r, c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Stack<Coord> stack = new Stack<>();
        for (int i = m-2; i > 0 ; i--) {
            stack.add(new Coord(i,0));
        }

        for (int i = 0; i < n-1 ; i++) {
            stack.add(new Coord(0,i));
        }

        while (!stack.isEmpty()){
            Coord c = stack.pop();
            int i = c.r;
            int j = c.c;
            boolean first = true;
            while (i<m && j<n){
                if(first){
                    first = false;
                    i++;
                    j++;
                    continue;
                }

                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }

                i++;
                j++;
            }
        }

        return true;
    }
}
