package easy;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] out = new SortArrayByIncreasingFrequency().frequencySort(new int[]{1,1,2,2,2,3});
        for (int j = 0; j < out.length; j++) {
            System.out.print(out[j] + " ");
        }
    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            int f = numFreq.getOrDefault(num, 0);
            numFreq.put(num, f+1);
        }

        SortedMap<Integer, SortedSet<Integer>> freq = new TreeMap<>((o1, o2) -> o2-o1);
        for (Map.Entry<Integer, Integer> entry : numFreq.entrySet()) {
            SortedSet<Integer> set = freq.getOrDefault(entry.getValue(), new TreeSet<>((o1, o2) -> o2-o1));
            set.add(entry.getKey());
            freq.put(entry.getValue(), set);
        }

        int i = 0;
        int[] output = new int[nums.length];
        for (Map.Entry<Integer, SortedSet<Integer>> e : freq.entrySet()) {
            SortedSet<Integer> set = e.getValue();
            for (Integer integ : set) {
                for (int j = 0; j < e.getKey(); j++) {
                    output[i++] = integ;
                }
            }
        }

        return output;
    }
}
