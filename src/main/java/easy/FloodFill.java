package easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    // west,up
    static final int [] r = new int[]{0,1,0,-1};
    static final int [] c = new int[]{-1,0,1,0};

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        int[][] floor = new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}};
        floodFill(floor, 1, 1 ,2);
        for (int[] ints : floor) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if(currColor == color)
            return image;

        int m = image.length;
        int n = image[0].length;
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(sr,sc));
        while (!queue.isEmpty()){
            Point currPoz = queue.poll();
            if(image[currPoz.r][currPoz.c] == color){
                continue;
            }

            image[currPoz.r][currPoz.c] = color;

            for (int i = 0; i < 4; i++) {
                int nextPozR = currPoz.r + r[i];
                int nextPozC = currPoz.c + c[i];
                if(nextPozR<0 || nextPozR >= m || nextPozC < 0 || nextPozC >= n) {
                    continue;
                }
                if(image[nextPozR][nextPozC] == currColor && image[nextPozR][nextPozC] != color) {
                    queue.offer(new Point(nextPozR, nextPozC));
                }
            }
            System.out.print("");
        }

        return image;
    }
}
