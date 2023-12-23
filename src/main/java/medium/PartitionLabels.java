package medium;

import java.util.*;

public class PartitionLabels {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().partitionLabels("caedbdedda"));
        }

        class Solution {
            public List<Integer> partitionLabels(String s) {
                int n = s.length();


                List<Integer> output = new ArrayList<>();
                Map<Character, Integer> counts = new HashMap<>();

                char [] chars = s.toCharArray();
                for (char c : chars) {
                    int count = counts.getOrDefault(c, 0);
                    counts.put(c, count+1);
                }

                for(int left = 0, right = 0; right < n; right++){
                    char c = chars[right];
                    int count = counts.get(c);

                    if(count==1){
                        output.add(1);
                        left++;
                        continue;
                    }

                    Map<Character, Integer> tempCounts = new HashMap<>();
                    tempCounts.put(c, count);
                    while (right < n && !tempCounts.isEmpty()){
                        char tempChar = chars[right];

                        if(!tempCounts.containsKey(tempChar)){
                            if(counts.get(tempChar) != 1)
                            {
                                tempCounts.put(tempChar,  counts.get(tempChar)-1);
                            }
                        } else {
                            decreaseOrRemove(tempCounts, tempChar);
                        }

                        decreaseOrRemove(counts, tempChar);

                        if(right == n-1 || tempCounts.isEmpty()){
                            break;
                        }

                        right++;
                    }


                    output.add(right-left+1);
                    left=right+1;
                }

                return output;
            }

            private void decreaseOrRemove(Map<Character, Integer> map, char c){
                int count = map.getOrDefault(c, 0);
                if(count == 0){
                    return;
                }

                if(count == 1){
                    map.remove(c);
                } else {
                    map.put(c,  count-1);
                }
            }
        }
    }

}
