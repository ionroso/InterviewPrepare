package easy;

import java.util.Arrays;
import java.util.OptionalInt;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        System.out.println(new CheckIfArrayIsSortedAndRotated().check(new int[]{7,9,1,1,1,3}));
    }

    public boolean check(int[] nums) {
        int n = nums.length;
        if(n == 0){ return false; }
        if(n == 1){ return true; }

        int minIndex = 0;
        int minValue = nums[minIndex];

        for (int i = 1; i < nums.length; i++) {
            if(minValue>=nums[i]){
                minValue = nums[i];
                minIndex = i;
            }
        }

        int j = (minIndex + 1 != nums.length) ? minIndex + 1 : 0;

        int prev = minValue;
        int curr = nums[j];
        while (j != minIndex && prev <= curr){
            prev = curr;
            j = j+1 != nums.length ? j+1 : 0;
            curr = nums[j];
        }

        return j == minIndex;
    }
}
