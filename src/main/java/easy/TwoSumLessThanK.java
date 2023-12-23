package easy;

import java.util.Arrays;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60));
        }

        class Solution {
            public int twoSumLessThanK(int[] nums, int k) {
                Arrays.sort(nums);
                int l=0, r= nums.length-1;
                int max = -1;
                while (l<r){
                    int sum = nums[l]+nums[r];

                    if(sum>=k){
                        r--;
                        continue;
                    }

                    max = Math.max(max, sum);
                    l++;
                }

                return max;
            }
        }
    }
}
