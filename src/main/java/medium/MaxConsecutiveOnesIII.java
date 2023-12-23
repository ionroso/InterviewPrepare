package medium;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        }

        class Solution {

            public int longestOnes(int[] nums, int k) {

                int n = nums.length;

                int max = Integer.MIN_VALUE;
                int left = 0, right = 0;

                int zerosCount = 0;
                while (right < n) {
                    if (nums[right] == 0) {
                        zerosCount++;
                    }

                    if (zerosCount <= k) {
                        max = Math.max(max, right - left + 1);
                    } else {
                        while (zerosCount > k) {
                            if (nums[left] == 0) {
                                zerosCount--;
                            }
                            left++;
                        }
                    }

                    right++;
                }

                return max != Integer.MIN_VALUE ? max : 0;
            }
        }
    }


}
