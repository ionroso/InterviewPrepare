package medium;

public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        }

        class Solution {
            public int longestSubarray(int[] nums) {
                int n = nums.length;
                int max = Integer.MIN_VALUE;
                int left = 0, right = 0;
                int countZero = 0;
                while (right < n){
                    if(nums[right] == 0) {
                        countZero++;
                    }

                    if(countZero == 2){
                        while (nums[left] != 0){
                            left++;
                        }
                        countZero--;
                        left++;
                    }
                    max = Math.max(max, right - left + 1);
                    right++;
                }

                return max - 1;
            }
        }

    }

}
