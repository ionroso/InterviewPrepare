package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().maxSubArrayLen(new int[]{1,-1,5,-2,3}, 3));
        }

        class Solution {
            public int maxSubArrayLen(int[] nums, int k) {

                Map<Integer, Integer> map = new HashMap<>();
                int ans = 0;
                int sum = 0;
                map.put(0, -1);

                for(int i = 0; i < nums.length; ++i) {
                    sum += nums[i];
                    if(map.containsKey(sum - k)) {
                        ans = Math.max(ans, i - map.get(sum - k));
                    }

                    if(!map.containsKey(sum)) {
                        map.put(sum, i);
                    }
                }


                return ans;
            }
        }
    }
}
