package medium;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    class HitCounter {
        class Hit {
            int timestamp;
            int count;

            public Hit(int timestamp, int count) {
                this.timestamp = timestamp;
                this.count = count;
            }
        }
        Queue<Hit> queue;

        Hit last;

        public HitCounter() {
            queue = new LinkedList<>();
        }

        public void hit(int timestamp) {
            if(last == null){
                last = new Hit(timestamp,1);
                queue.offer(last);
            } else if(last.timestamp == timestamp) {
                last.count++;
            } else {
                last = new Hit(timestamp, 1);
                queue.offer(last);

                while (!queue.isEmpty() && last.timestamp - queue.peek().timestamp > 300) {
                    queue.poll();
                }
            }
        }

        public int getHits(int timestamp) {
            int count = 0;
            for (Hit hit : queue) {
                if ( hit.timestamp > timestamp - 300 && hit.timestamp <= timestamp){
                    count += hit.count;
                }
                if(hit.timestamp > timestamp) {
                    break;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {

    }

}
