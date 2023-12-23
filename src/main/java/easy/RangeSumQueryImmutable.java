package easy;

import java.util.Arrays;
import java.util.Stack;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        RangeSumQueryImmutable.NumArray rsqi = new RangeSumQueryImmutable.NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(rsqi.sumRange(0,2));
    }


    static
    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }


        public int sumRange(int left, int right) {
            int sum = 0;
            for (int i = left; i < right ; i++) {
                sum+=nums[i];
            }

            return sum;
        }
    }
}
