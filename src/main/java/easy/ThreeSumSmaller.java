package easy;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().threeSumSmaller(new int[]{-1,1,-1,0}, -1));
        }

        class Solution {
            Solution() {

            }

            public int threeSumSmaller(int[] nums, int target) {
                Arrays.sort(nums);
                int n = nums.length;

                if(n<3){
                    return 0;
                }

                int count = 0;
                for (int i = 0; i < n - 2; i++) {
                    for (int k = i+2; k < n; k++) {
                        int j = i+1;
                        while (j<k && nums[i] + nums[j] + nums[k] < target){
                            count++;
                            j++;
                        }
                    }
                }

                return count;
            }
        }
    }
}
