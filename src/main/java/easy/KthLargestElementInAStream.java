package easy;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Stream;

public class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[] {4,5,8,2});
        System.out.println(kl.add(3));
        System.out.println(kl.add(5));
        System.out.println(kl.add(10));
        System.out.println(kl.add(9));
        System.out.println(kl.add(4));
    }

    static
    class KthLargest {
        PriorityQueue<Integer> pq;
        int size;

        public KthLargest(int k, int[] nums) {
            this.size = k;
            this.pq = new  PriorityQueue<>();

            Arrays.stream(nums).sorted().skip(nums.length>k? nums.length - k : 0).forEach(e -> { pq.offer(e); } );

        }

        public int add(int val) {
            if(val>=pq.peek()){
                pq.poll();
                pq.offer(val);
            }

            return pq.peek();
        }
    }
}
