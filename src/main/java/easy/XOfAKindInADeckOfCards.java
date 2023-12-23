package easy;

import java.util.HashMap;
import java.util.Map;

public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        System.out.println(new XOfAKindInADeckOfCards().hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> groups = new HashMap<>();
        for(int el : deck){
            Integer count = groups.getOrDefault(el, 0);
            count++;
            groups.put(el, count);
        }


        int max = -1, min = deck.length + 1;
        for(int count  : groups.values()){
            max = Math.max(max, count);
            min = Math.min(min, count);
        }

        if(max != min) return false;

        return true;
    }
}
