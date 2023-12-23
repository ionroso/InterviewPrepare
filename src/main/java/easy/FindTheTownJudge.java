package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap();
        for (int[] ints : trust) {
            set.add(ints[0]);
            int c = map.getOrDefault(ints[1],0);
            map.put(ints[1],c+1);
        }

        for (int[] ints : trust) {
           if(!set.contains(ints[1]) && map.containsKey(ints[1]) && map.get(ints[1]) == n-1) return ints[1];
        }

        return -1;
    }
}
