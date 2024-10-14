package org.example;

import java.util.PriorityQueue;
import  java.util.concurrent.atomic.AtomicLong;
public class PriorityQueueTest {
    private  static class Test {
        int id;
        int val;

        private final long seqNum;
        private final static AtomicLong seq = new AtomicLong();

        public Test(int id, int val) {
            this.id = id;
            this.val = val;
            this.seqNum = seq.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Test> pq = new PriorityQueue<>((o1, o2) ->
        {
            if(o1.val != o2.val){
                return o1.val - o2.val;
            }

            return o1.seqNum < o2.seqNum ? -1 : 1;
        }

        );
        pq.offer(new Test(1,1));
        pq.offer(new Test(2,1));
        pq.offer(new Test(3,1));
        pq.offer(new Test(4,1));

        while (!pq.isEmpty()){
            System.out.println(pq.poll().id);
        }
    }
}
