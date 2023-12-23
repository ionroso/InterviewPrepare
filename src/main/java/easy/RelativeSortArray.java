package easy;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        SortedMap<Integer, Integer> freq = new TreeMap<>();
        for (int el : arr1) {
            int count = freq.getOrDefault(el, 0);
            freq.put(el, count+1);
        }

        int x=0;
        for (int i : arr2) {
            for (int j = 0; j < freq.get(i); j++) {
                arr1[x++] = i;
            }
            freq.remove(i);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            for (int j = 0; j < entry.getValue(); j++) {
                arr1[x++] = entry.getKey();
            }
        }

        return arr1;
    }
}
