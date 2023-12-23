package medium;

import java.util.List;

public class ZigzagIteratorTest {
    public static void main(String[] args) {
        ZigzagIterator z = new ZigzagIterator(List.of(1,2), List.of(3,4,5,6));
        z.next();
        z.next();
        z.next();
        z.next();
        z.next();
        z.next();
    }


    static
    class ZigzagIterator {

        List<Integer> v1;
        List<Integer> v2;
        boolean takeFromFirst = true;
        int v1Ptr = 0;
        int v2Ptr = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            int rez = -1;

            boolean canTakeFromV1 = !v1.isEmpty() && v1Ptr < v1.size();
            boolean canTakeFromV2 = !v2.isEmpty() && v2Ptr < v2.size();

            if(canTakeFromV1 && !canTakeFromV2){
                rez = v1.get(v1Ptr++);
            } else if (!canTakeFromV1 && canTakeFromV2) {
                rez = v2.get(v2Ptr++);
            } else {
                if(takeFromFirst) {
                    rez = v1.get(v1Ptr++);
                    takeFromFirst = false;
                } else {
                    rez = v2.get(v2Ptr++);
                    takeFromFirst = true;
                }
            }

            return rez;
        }

        public boolean hasNext() {
            return v1Ptr < v1.size() || v2Ptr < v2.size();
        }
    }
}
