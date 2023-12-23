package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,1};
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> freqs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(freqs.contains(nums[i])){
                return true;
            }
            freqs.add(nums[i]);
        }

        return false;
    }
}
