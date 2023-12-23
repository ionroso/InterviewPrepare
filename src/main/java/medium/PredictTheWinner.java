package medium;

public class PredictTheWinner {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().predictTheWinner(new int[]{1,5,233,7}));
        }

        class Solution {
            public boolean predictTheWinner(int[] nums) {
                return predictTheWinnerRec(nums, 0, nums.length-1, true,0, 0);
            }

            private boolean predictTheWinnerRec(int[] nums, int l, int r, boolean first, int firstSum, int secondSum) {
                if(l==r) {
                    return first ? (firstSum + nums[l] > secondSum ) : (firstSum > secondSum + nums[l]);
                }

                if(first){
                    return predictTheWinnerRec(nums,l+1, r, false, firstSum + nums[l], secondSum) && predictTheWinnerRec(nums, l, r-1, false, firstSum + nums[r], secondSum);
                } else {
                    return predictTheWinnerRec(nums,l+1, r, true, firstSum, secondSum+  nums[l]) && predictTheWinnerRec(nums, l, r-1, true, firstSum, secondSum + nums[r]);
                }
            }
        }
    }
}
