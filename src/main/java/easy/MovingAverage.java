package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MovingAverage {
    public static void main(String[] args) {
        int size = 5;

        IntStream stream = IntStream.range(0, 100);

        // Displaying the elements in range
        // including the lower bound but
        // excluding the upper bound
        stream.forEach(e-> {
            int tail = (e) % size;
            System.out.print("e:" + e);
            System.out.print(" modulo:" + e % size);
            System.out.println(" division:" + e / size);
        });
    }
    class MovingAverageEducational1 {
        int size, head = 0, windowSum = 0, count = 0;
        int[] queue;
        public MovingAverageEducational1(int size) {
            this.size = size;
            queue = new int[size];
        }

        public double next(int val) {
            ++count;
            // calculate the new sum by shifting the window
            int tail = (head + 1) % size;
            windowSum = windowSum - queue[tail] + val;
            // move on to the next head
            head = (head + 1) % size;
            queue[head] = val;
            return windowSum * 1.0 / Math.min(size, count);
        }
    }
    private class MovingAverageMy {
        int capacity;
        int currentSize = 0;
        int currentSum = 0;
        Queue<Integer> queue = new LinkedList<>();

        public MovingAverageMy(int capacity) {
            this.capacity = capacity;
        }

        public double next(int val) {

            if(currentSize >= capacity) {
                currentSum-=queue.poll();
                currentSize--;
            }

            currentSize++;
            queue.offer(val);
            currentSum+=val;

            return (double)currentSum / currentSize;
        }
    }
}
