package medium;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public class LFUCacheTest {
    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);

        lfu.get(1);
        lfu.put(3, 3);

        lfu.get(2);
        lfu.get(3);
        lfu.put(4, 4);
        lfu.get(1);
        lfu.get(3);
        lfu.get(4);
    }

    static
    class LFUCache {

        private class CacheNode {
            private final long seqNum;
            int key, value, cnt;
            private final static AtomicLong seq = new AtomicLong();
            public CacheNode(int key, int value) {
                this.key = key;
                this.value = value;
                this.cnt = 1;
                this.seqNum = seq.getAndIncrement();
            }

            public CacheNode(int key, int value, int cnt) {
                this(key, value);
                this.cnt = cnt;
            }
        }

        private final int capacity;
        private Map<Integer, CacheNode> dict;
        private PriorityQueue<CacheNode> pq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.dict = new HashMap<>();
            this.pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.cnt != o2.cnt){
                    return o1.cnt - o2.cnt;
                }

                return o1.seqNum < o2.seqNum ? -1 : 1;
            });
        }

        public int get(int key) {
            if(!dict.containsKey(key)) {
                return -1;
            }

            CacheNode cacheNode = dict.get(key);

            remove(cacheNode);
            add(new CacheNode(cacheNode.key, cacheNode.value, cacheNode.cnt+1));

            return cacheNode.value;
        }

        public void put(int key, int value) {
            CacheNode node = dict.get(key);
            if(node == null) {
                node = new CacheNode(key, value);
            } else {
                remove(node);
                node = new CacheNode(key, value, node.cnt+1);
            }

            if(dict.size()>=capacity){
                CacheNode poll = pq.poll();
                dict.remove(poll.key);
            }

            add(node);
        }

        private void add(CacheNode node) {
            pq.offer(node);
            dict.put(node.key, node);
        }

        private void remove(CacheNode cacheNode) {
            pq.remove(cacheNode);
            dict.remove(cacheNode.key);
        }
    }
}
