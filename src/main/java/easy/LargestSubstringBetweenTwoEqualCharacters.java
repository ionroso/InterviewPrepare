package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            if(!list.isEmpty()){
                list.remove(list.size()-1);
            }
            list.add(i);
            map.put(s.charAt(i), list);
        }

        int max = Integer.MIN_VALUE;
        for (List<Integer> list : map.values()) {
            max = Math.max(max, list.get(list.size()-1) - list.get(0));
        }

        return max;
    }
}
