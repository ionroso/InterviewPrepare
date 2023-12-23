package medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
//            String s = "EOEMQLLQTRQDDCOERARHGAAARRBKCCMFTDAQOLOKARBIJBISTGNKBQGKKTALSQNFSABASNOPBMMGDIOETPTDICRBOMBAAHINTFLH";
//            for (int i = 0; i < s.length() - 11; i++) {
//                Map<Character, Integer> map = new HashMap<>();
//                char[] cc = s.substring(i, i+11).toCharArray();
//                for (char c : cc) {
//                    int count = map.getOrDefault(c, 0);
//                    map.put(c, count+1);
//                }
//
//                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                    if(entry.getValue()==4){
//                        System.out.println(s.substring(i, i+11).toCharArray());
//                    }
//                }
//            }


            System.out.println(new Solution().characterReplacement("ABAA", 0));
        }

        class Item {
            Character c;
            int count;

            public Item(Character c, int count) {
                this.c = c;
                this.count = count;
            }
        }

        class Solution {
            public int characterReplacement(String s, int k) {
                int n = s.length();
                if(n==0){
                    return 0;
                }

                if(n == 1){
                    return 1;
                }

                Map<Character, Item> charToItem = new HashMap<>();
                PriorityQueue<Item> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);

                int max = -1;
                for (int left = 0, right = 0; right < n; right++) {
                    Item item = charToItem.getOrDefault(s.charAt(right), new Item(s.charAt(right), 0));
                    if(pq.contains(item)){
                        pq.remove(item);
                    }

                    item.count++;
                    pq.offer(item);
                    charToItem.put(item.c, item);

                    while (!pq.isEmpty() &&  (right-left +1) + -pq.peek().count > k && left <= right) {
                        Item first = charToItem.get(s.charAt(left));
                        pq.remove(first);
                        charToItem.remove(s.charAt(left));

                        if(first.count != 1) {
                            first.count--;
                            pq.offer(first);
                            charToItem.put(first.c, first);
                        }

                        left++;
                    }

                    max = Math.max(max, right - left + 1);
                }

                return max;
            }
        }
    }

}
