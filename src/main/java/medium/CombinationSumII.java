package medium;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            List<List<Integer>> rez = new Solution().combinationSum2(new int[]{1,1,2,2}, 4);
            System.out.println();
        }

        class Solution {
            List<List<Integer>> rez;
            Set<String> set;

            Solution() {
                rez = new ArrayList<>();
                set = new HashSet<>();
            }

            public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                Arrays.sort(candidates);

                for (int i = 0; i < candidates.length; i++) {
                    combinationSum2(candidates, target, i, 0, new LinkedList<>());
                }

                return rez;
            }

            public void combinationSum2(int[] candidates, int target, int ptr, int sum, LinkedList<Integer> currentList) {
                if(ptr>=candidates.length || sum + candidates[ptr] > target){
                    return;
                }

                int num = candidates[ptr];
                currentList.addLast(num);
                sum+=num;

                if(sum == target){
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < currentList.size(); i++) {
                        sb.append(currentList.get(i)).append(",");
                    }
                    String temp = sb.toString();
                    if(!set.contains(temp)){
                        rez.add(new ArrayList<>(currentList));
                        set.add(temp);
                    }

                    currentList.removeLast();
                    return;
                }

                for (int i = ptr+1; i < candidates.length; i++) {
                    combinationSum2(candidates, target, i, sum, currentList);
                }

                currentList.removeLast();
            }
        }
    }
}
