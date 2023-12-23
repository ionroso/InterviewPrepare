package easy;

import java.util.Arrays;

public class LongestEvenOddSubarrayWithThreshold {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
//            System.out.println(new Solution().longestAlternatingSubarray(new int[]{1,2}, 2));
//            System.out.println(new Solution().longestAlternatingSubarray(new int[]{2,3,4,5}, 4));
            System.out.println(new Solution().longestAlternatingSubarray(new int[]{4,10,3}, 10));
//            System.out.println(new Solution().longestAlternatingSubarray(new int[]{3,2,5,4}, 5));
        }

        class Solution {
            Solution() {}

            public int longestAlternatingSubarray(int[] nums, int threshold) {

                int n = nums.length;
                int max = 0, len = -1;
                for (int i = 0; i < n; i++) {
                    if(nums[i]>threshold){
                        len = -1;
                        continue;
                    }

                    if(len == -1 && nums[i]%2 == 0) {
                        len = 1;
                    } else if(len != -1 && nums[i-1] % 2 != nums[i] % 2) {
                        len++;
                    } else if(nums[i]%2 == 0) {
                        len = 1;
                    } else {
                        len = -1;
                    }

                    max = Math.max(max, len);
                }

                return max;
            }
        }
    }

}
