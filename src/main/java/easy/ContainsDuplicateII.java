package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        }

        class Solution {
            Solution() {}

            public boolean containsNearbyDuplicate(int[] nums, int k) {
                if(k==0){
                    return false;
                }

                int n = nums.length;
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if(set.contains(nums[i]))
                        return true;

                    if(i>=k){
                        set.remove(nums[i-k]);
                    }

                    set.add(nums[i]);
                }

                return false;
            }
        }
    }
}
