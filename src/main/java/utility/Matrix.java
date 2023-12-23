package utility;

public class Matrix {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        // 3x3
//        int[][] m = new int[][]{{1,2},{4,5},{7,8}};
//        Coord leftRightDiagParent = matrix.findLeftRightDiagParent(m, 2, 1);
//        System.out.println(leftRightDiagParent.y + " " + leftRightDiagParent.x);

        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int m = args.length;
        int n = 2;
        int y=1,x=1;
        System.out.println("y,x:" + y + ":" + x);

        Coord ne = matrix.findNEDiagParent(m, n, y,x);
        Coord se = matrix.findSEDiagParent(m, n, y,x);
        System.out.print("NE:" + ne.y + ":" + ne.x);
        System.out.println(" SE:" + se.y + ":" + se.x);

        Coord nw = matrix.findNWDiagParent(m, n, y,x);
        Coord sw = matrix.findSWDiagParent(m, n, y,x);
        System.out.print("NW:" + nw.y + ":" + nw.x);
        System.out.println(" SW:" + sw.y + ":" + sw.x);

        System.out.println("Dist " + matrix.dist(0,0, 2, 2));

//        String input = "[[1,2,3],[3,8,4],[5,3,5]]";
//        matrixStrToMatrix(input);
    }

    public static int[][] matrixStrToMatrix(String str){
        String temp = str.substring(2, str.length()-2);
        String[] tempSplit = temp.split("\\],\\[");
        int m = tempSplit.length;
        int n = (int) count(tempSplit[0], ',') + 1;

        int[][] output = new int[m][n];

        int line = 0;
        for (String split : tempSplit) {
            String[] tmpSplint = split.split(",");
            for (int i = 0; i < n; i++) {
                output[line][i] = Integer.parseInt(tmpSplint[i]);
            }
            line++;
        }
        return output;
    }

    public static long count(String s, char ch)
    {
        return s.chars()
                .filter(c -> c == ch)
                .count();
    }

    class Coord {
        int y,x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    int dist(int y2, int x2, int y1, int x1){
        return 1 + (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    Coord findNEDiagParent(int m, int n, int y, int x){
        int min = Math.min(y,n-1-x);
        return new Coord(y-min, x+min);
    }

    Coord findSWDiagParent(int m, int n, int y, int x){
        int min = Math.min(m-1-y, x);
        return new Coord(y+min, x-min);
    }

    Coord findNWDiagParent(int m, int n, int y, int x){
        int min = Math.min(y,x);
        return new Coord(y-min, x-min);
    }

    Coord findSEDiagParent(int m, int n, int y, int x){
        int min = Math.min(m-y-1,n-x-1);
        return new Coord(y+min, x+min);
    }
}
