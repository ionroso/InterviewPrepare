package medium;

import java.util.*;

public class FindConsecutiveIntegersFromADataStream {
    public static void main(String[] args) {
        new Test().test();
    }


    private static class Test {
        public void test() {
            DataStream ds = new DataStream(4,3);
            System.out.println(ds.consec(4));
            System.out.println(ds.consec(4));
            System.out.println(ds.consec(4));
            System.out.println(ds.consec(3));
        }

        class DataStream {
            int value, k;
            LinkedList<Integer> ll;
            int counter;

            public DataStream(int value, int k) {
                this.value = value;
                this.k = k;

                this.ll = new LinkedList();
            }

            public boolean consec(int num) {
                if(ll.size()>=k){
                    int val = ll.removeFirst();
                    counter -= value==val ? 1 : 0;
                }

                counter += num==value ? 1 : 0;

                ll.addLast(num);

                return allEqValue();
            }

            private boolean allEqValue() {
                return counter == k;
            }
        }
    }
}
