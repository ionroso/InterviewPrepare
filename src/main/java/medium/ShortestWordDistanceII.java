package medium;

import java.util.*;

public class ShortestWordDistanceII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {

        }

        class WordDistance {

            Map<String, NavigableSet<Integer>> map;

            public WordDistance(String[] wordsDict) {

                map = new HashMap<>();

                for (int i =0; i< wordsDict.length; i++){
                    map.computeIfAbsent(wordsDict[i], entry -> new TreeSet<>()).add(i);
                }
            }

            public int shortest(String word1, String word2) {
                NavigableSet<Integer> word1Indexes = map.get(word1);
                NavigableSet<Integer> word2Indexes = map.get(word2);

                if(word1Indexes.isEmpty() || word1Indexes.isEmpty()) {
                    return -1;
                }

                if(word1Indexes.last() < word2Indexes.first()) {
                    return word2Indexes.first() - word1Indexes.last();
                }

               return word1Indexes.size() < word2Indexes.size() ? minDist(word1Indexes, word2Indexes) :  minDist(word2Indexes, word1Indexes);
            }

            private int minDist(NavigableSet<Integer> list1, NavigableSet<Integer> list2) {
                int min = Integer.MAX_VALUE;
                for (Integer l1 : list1) {
                    if(list2.floor(l1) != null){
                        min = Math.min(min, l1-list2.floor(l1));
                    }

                    if(list2.ceiling(l1) != null){
                        min = Math.min(min, list2.ceiling(l1))-l1;
                    }
                }
                return min;
            }
        }
    }
}
