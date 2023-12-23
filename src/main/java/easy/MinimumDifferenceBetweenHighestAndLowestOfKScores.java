package easy;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().minimumDifference(new int[]{9,4,1,7}, 2));
        }

        class Solution {
            Solution() {

            }

            // 1, 4, 7, 9
            public int minimumDifference(int[] nums, int k) {
                int n = nums.length;
                Arrays.sort(nums);

                int min = Integer.MAX_VALUE;
                for (int i = 0; i <= n-k; i++) {
                    min = Math.min(min, nums[i+k-1] - nums[i]);
                }
                return min;
            }
        }
    }
}
