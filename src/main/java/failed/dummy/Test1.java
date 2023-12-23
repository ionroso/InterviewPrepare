package failed.dummy;

import java.util.PriorityQueue;

public class Test1 {

    public static void main(String[] args) {
        new Test1().dummyDev();
    }

    void dummyDev(){

        boolean[] test1 = new boolean[]{false,false,false,false,true,false,false,false,false,false};

        boolean[] test2 = new boolean[]{false,false,true,false,true,false,false,false,false,false};

        boolean[] test3 = new boolean[]{false,true,true,false,false,false,false,false,false,false};

        boolean[] test4 = new boolean[]{true,false,false,false,false,false,false,false,false,false};

        boolean[] test5 = new boolean[]{false,false,false,false,false,false,false,false,false,true};

        boolean[] test6 = new boolean[]{true,false,true,true,false,false,true,false,false,true};

        boolean[] test7 = new boolean[]{true,false,false,false,false,false,false,false,false,true};

        boolean[] test8 = new boolean[]{true,true,true,true,true,true,true,true,true,true};

        boolean[] test9 = new boolean[]{false,false,false,false,false,false,false,false,false,false};

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> (o2[1] - o2[0]) - (o1[1] - o1[0])));

        boolean[] test = test9;
        int n = test.length;

        int len = 0;
        for (int i = 0; i < n; i++) {
            if(!test[i]){
                len++;

                if(i == n-1){
                    int end = n-1;
                    int start = end - len + 1;
                    pq.add(new int[]{start, end});
                }
                continue;
            }

            if(len > 0){
                int end = i-1;
                int start = end - len + 1;
                pq.add(new int[]{start, end});
                len = 0;
            }
        }

        System.out.println();
    }
}
