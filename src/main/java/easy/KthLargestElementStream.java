package easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementStream {
    class KthLargest {
        int k;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
        public KthLargest(int k, int[] nums) {
            this.k = k;
            Arrays.sort(nums);
            for (int i = 0; i < Math.min(k, nums.length); i++) {
                minHeap.offer(nums[nums.length-1-i]);
            }
        }

        public int add(int val) {
            if(minHeap.size()<k)
            {
                minHeap.offer(val);
            } else if(val > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(val);
            }

            return minHeap.peek();
        }
    }
}
