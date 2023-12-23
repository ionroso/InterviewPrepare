package medium;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterTest {
    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);       // hit at timestamp 1.
        hitCounter.hit(2);       // hit at timestamp 2.
        hitCounter.hit(3);       // hit at timestamp 3.
        System.out.println(hitCounter.getHits(4));   // get hits at timestamp 4, return 3.
        hitCounter.hit(300);     // hit at timestamp 300.
        System.out.println(hitCounter.getHits(300)); // get hits at timestamp 300, return 4.
        System.out.println(hitCounter.getHits(301)); // get hits at timestamp 301, return 3.
    }



    static
    class HitCounter {

        private final static Integer FIVE_MIN_IN_SEC = 300;

        LinkedList<Integer> queue;


        public HitCounter() {
            queue = new LinkedList<>();
        }

        public void hit(int timestamp) {
            queue.addLast(timestamp);
        }

        public int getHits(int timestamp) {
            if(timestamp<FIVE_MIN_IN_SEC){
                return queue.size();
            }

            while (timestamp - queue.peek() >= FIVE_MIN_IN_SEC){
                queue.removeFirst();
            }

            return queue.size();
        }
    }

}
