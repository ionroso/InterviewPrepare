package easy;

import java.util.*;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{-2,0,10,-19,4,6,-8}));
    }

    public boolean checkIfExist(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        for (int key : map.keySet()) {
            if(key == 0) {
                if (map.get(key).size() == 1) continue;
                return true;
            }

            if (key % 2 == 0 && map.containsKey(key / 2)) {
                return true;
            }
        }

        return false;
    }
}
