package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (Integer i : pq) {
           pq.offer(i);
        }

        while (pq.size()!=1){
            int x = pq.poll();
            int y = pq.poll();
            if(x!=y){
                pq.offer(Math.abs(x-y));
            }
        }


        return pq.poll();
    }
}
