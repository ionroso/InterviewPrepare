package medium;

import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInEachSubarray {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().distinctNumbers(new int[]{1,2,3,2,2,1,3}, 3));
        }

        class Solution {
            Solution() {}

            public int[] distinctNumbers(int[] nums, int k) {
                int n = nums.length;
                int[] rez = new int[n-k+1];

                int index = 0;
                Map<Integer, Integer> numCounts = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int num = nums[i];

                    int count = numCounts.getOrDefault(num, 0);
                    numCounts.put(num, count+1);

                    if(i<k-1){
                        continue;
                    }

                    if(i>=k){
                        int numToRemove = nums[i-k];
                        int numToRemoveCount = numCounts.get(numToRemove);
                        if(numToRemoveCount == 1){
                            numCounts.remove(numToRemove);
                        } else {
                            numCounts.put(numToRemove, numToRemoveCount-1);
                        }
                    }

                    rez[index++] = numCounts.size();
                }

                return rez;
            }
        }
    }

}
