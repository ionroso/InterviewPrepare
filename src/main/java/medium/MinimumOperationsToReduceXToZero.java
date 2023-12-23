package medium;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.Arrays;

public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().minOperations(new int[]{1,1,4,2,3}, 5));
        }



        class Solution {
            public int minOperations(int[] nums, int x) {
                int n = nums.length;
                int sum=0;
                for(int i:nums) sum+=i;

                int wsize=-1,target=sum-x;
                int fir =0;
                for(int l=0,r=0;r<n;r++){
                    fir +=nums[r];
                    while( fir>target &&l<=r)
                        fir -=nums[l++];

                    if(fir==target) wsize=Math.max(wsize,r-l+1);
                }
                return wsize!=-1?n-wsize:-1;
            }
        }

        class Solution2 {
            public int minOperations(int[] nums, int x) {
                int subTotal = Arrays.stream(nums).sum() - x;

                int n = nums.length;
                int max = -1;
                int left = 0;
                int current = 0;

                for (int right = 0; right < n; right++) {
                    // sum([left ,..., right]) = total - x
                    current += nums[right];
                    // if larger, move `left` to left
                    while (current > subTotal && left <= right) {
                        current -= nums[left];
                        left ++;
                    }
                    // check if equal
                    if (current == subTotal) {
                        max = Math.max(max, right - left + 1);
                    }
                }
                return max != -1 ? n - max : -1;
            }
        }

        class Solution1 {
            public int minOperations(int[] nums, int x) {
                int n = nums.length;

                int subTotal = Arrays.stream(nums).sum() - x;
                if(subTotal < 0) {
                    return -1;
                }

                int max = Integer.MIN_VALUE;
                int left = 0, right = 0;
                int temp = 0;
                while (right < n){

                    temp+=nums[right];

                    if(temp > subTotal){
                        while (temp>subTotal) {
                            temp-= nums[left];
                            left++;
                        }
                    }

                    if(temp == subTotal) {
                        max = Math.max(max, right - left + 1);
                    }

                    right++;
                }


                return max != Integer.MIN_VALUE ? n - max : -1;
            }
        }
    }

}
