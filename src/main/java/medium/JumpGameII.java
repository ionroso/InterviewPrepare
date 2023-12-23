package medium;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
        }

        class Solution {
            public int jump(int[] nums) {
                int n = nums.length;
                int[] jumps = new int[n];
                Arrays.fill(jumps, n);
                jumps[0]=0;

                for(int i = 0; i < n; i++){
                    if(i==n-1){
                        continue;
                    }

                    for(int j = i+1; j <= Math.min(n-1, i+nums[i]); j++){
                        jumps[j] = Math.min(jumps[j], jumps[i]+1);
                    }
                }

                return jumps[n-1];
            }
        }
    }
}
