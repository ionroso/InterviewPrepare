package easy;

import java.util.*;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> position = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = position.getOrDefault(arr[i], new ArrayList<>());
            if(!position.containsKey(arr[i])){
                pq.offer(arr[i]);
            }

            list.add(i);
            position.put(arr[i], list);
        }

        int rank = pq.size();
        while (!pq.isEmpty()){
            int elem = pq.poll();
            List<Integer> list = position.get(elem);
            for (Integer poz : list) {
                arr[poz] = rank;
            }
            rank--;
        }


        return arr;
    }
}
