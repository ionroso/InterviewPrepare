package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class ShortestWordDistanceIII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            new Solution().shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes");
        }

        class Solution {
            public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
                Map<String, NavigableSet<Integer>> map = new HashMap<>();

                for (int i = 0; i < wordsDict.length; i++) {
                    map.computeIfAbsent(wordsDict[i], entry -> new TreeSet<>()).add(i);
                }


                NavigableSet<Integer> word1Indexes = map.get(word1);
                NavigableSet<Integer> word2Indexes = map.get(word2);

                if (word1Indexes.isEmpty() || word1Indexes.isEmpty()) {
                    return -1;
                }

                if (word1Indexes.last() < word2Indexes.first()) {
                    return word2Indexes.first() - word1Indexes.last();
                }

                return word1Indexes.size() < word2Indexes.size() ? minDist(word1Indexes, word2Indexes) : minDist(word2Indexes, word1Indexes);

            }

            private int minDist(NavigableSet<Integer> list1, NavigableSet<Integer> list2) {

                boolean same = false;
                if(list1 == list2) {
                    same = true;
                }

                int min = Integer.MAX_VALUE;

                for (Integer l1 : list1) {
                    if(same){
                        Integer f = list2.lower(l1);
                        if (f != null && l1 != f) {
                            min = Math.min(min, l1 - f);
                        }

                        Integer c = list2.higher(l1);
                        if (c != null && l1 != c) {
                            min = Math.min(min, c - l1);
                        }
                    } else {
                        Integer f = list2.floor(l1);
                        if (f != null) {
                            min = Math.min(min, l1 - f);
                        }

                        Integer c = list2.ceiling(l1);
                        if (c != null) {
                            min = Math.min(min, c - l1);
                        }
                    }

                }
                return min;
            }
        }
    }
}
