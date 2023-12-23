package easy;

import java.util.*;

public class RingsAndRods {
    public static void main(String[] args) {
        System.out.println(countPoints("G3R3R7B7R5B1G8G4B3G6"));
    }
    static public int countPoints(String rings) {
        Map<Integer, Set<Character>> rods = new HashMap<>();
        for (int i = 1; i < rings.length(); i+=2) {
            int poz = rings.charAt(i) - '0';
            Set<Character> colors = rods.getOrDefault(poz, new HashSet<>());
            colors.add(rings.charAt(i-1));
            rods.put(poz, colors);
        }

        int count = 0;
        for (Set<Character> value : rods.values()) {
            if(value.size() == 3){
                count++;
            }
        }

        return count;
    }
}
