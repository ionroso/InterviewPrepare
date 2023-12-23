package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            List<Integer> ll = new ArrayList<>();
            ll.add(3);
            ll.add(2);
            ll.add(1);
            System.out.println(new Solution().countPairs(ll, 3));
        }

        class Solution {
            public int countPairs(List<Integer> nums, int target) {
                int n = nums.size();
                Collections.sort(nums);

                int left=0, right = 0, count = 0;
                while(left < n-1 && nums.get(left) < target) {
                    right = left + 1;
                    while (right < n && nums.get(left) + nums.get(right) < target){
                        right++;
                        count++;
                    }

                    left++;
                }


                return count;
            }
        }
    }

}
