package easy;

import java.util.*;

public class WordDistance_rem {
    public static void main(String[] args) {

    }
    class WordDistance {

        Map<String, List> map;

        public WordDistance(String[] wordsDict) {

            map = new HashMap<>();

            for (int i =0; i< wordsDict.length; i++){
                map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1List = map.get(word1);
            List<Integer> word2List = map.get(word2);

            int idx1 = 0;
            int idx2 = word2List.size()-1;

            while (word1List.get(idx1)<idx2){

            }


            return 0;


        }
    }
}
