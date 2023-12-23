package medium;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            TimeMap timeMap = new TimeMap();
            timeMap.set("a","bar",1);
            timeMap.set("x","b",3);
            timeMap.get("b",3);
            timeMap.set("foo","bar2",4);
            timeMap.get("foo",4);
            timeMap.get("foo",5);
        }

        class TimeMap {
                Map<String, TreeMap<Integer, String>> map;

            public TimeMap() {
                this.map = new HashMap<>();
            }

            public void set(String key, String value, int timestamp) {
                map.computeIfAbsent(key, k->new TreeMap<>()).put(timestamp, value);
            }

            public String get(String key, int timestamp) {
                if(!map.containsKey(key)) {
                    return null;
                }

                TreeMap<Integer, String> tm =  map.get(key);

                Integer floorKey = tm.floorKey(timestamp);
                return floorKey != null ? tm.get(floorKey) : "";
            }
        }

    }
}
