package medium;

public class Flatten2DVector {
    public static void main(String[] args) {
//        Vector2D vector2D = new Vector2D(new int[][]{{1, 2}, {3}, {4}});
//        vector2D.next();    // return 1
//        vector2D.next();    // return 2
//        vector2D.next();    // return 3
//        vector2D.hasNext(); // return True
//        vector2D.hasNext(); // return True
//        vector2D.next();    // return 4
//        vector2D.hasNext(); // return False


        Vector2D vector2D = new Vector2D(new int[][]{{}, {3}});
        vector2D.hasNext(); // return True
        vector2D.next();    // return 4
        vector2D.hasNext(); // return False

    }

    static
    class Vector2D {
        private int totalCount;
        int ptrR = -1;
        int ptrC = 0;

        int[][] vec;
        public Vector2D(int[][] vec) {
            this.vec = vec;

            for (int i=0; i < vec.length; i++) {
                int[] ints = vec[i];
                if(ptrR == -1 && ints.length>0){
                    ptrR = i;
                }
                this.totalCount += ints.length;
            }
        }

        public int next() {
            if(!hasNext()) {
                return -1;
            }

            int rez = vec[ptrR][ptrC];

            totalCount--;
            if(totalCount == 0){
                return rez;
            }

            if(ptrC==vec[ptrR].length-1){
                int nextRow = ptrR+1;
                while (nextRow < vec.length && vec[nextRow].length==0){
                    nextRow++;
                }
                ptrR=nextRow;
                ptrC=0;
            } else {
                ptrC++;
            }

            return rez;
        }

        public boolean hasNext() {
            return totalCount > 0;
        }
    }

}
