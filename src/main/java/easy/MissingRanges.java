package easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
        List<List<Integer>> rez = new MissingRanges().findMissingRanges(new int[]{0,1,3,50,75}, 0 , 99);
    }
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> output = new ArrayList<>();
        int l = lower-1;
        int l0, l1;
        for (int num : nums) {
            l0 = l+1;
            l1 = num-1;
            if(l0<=l1){
                List<Integer> temp = new ArrayList<>();
                temp.add(l0);
                temp.add(l1);
                output.add(temp);
                l = num;
            }
        }

        l0 = nums[nums.length-1]+1;
        l1 = upper;
        if(l0<=l1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(l0);
            temp.add(l1);
            output.add(temp);
        }

        return output;
    }
}
