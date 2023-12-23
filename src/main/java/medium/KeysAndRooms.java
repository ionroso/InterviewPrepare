package medium;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.addAll(rooms.get(0));
        seen.add(0);

        int i = 0;
        while (!queue.isEmpty()) {
            int room = queue.poll();
            if(seen.contains(room)) continue;
            for (Integer r : rooms.get(room)) {
                if(seen.contains(r)) continue;
                queue.offer(r);
            }
            seen.add(room);
        }

        return seen.size() == rooms.size();
    }
}
