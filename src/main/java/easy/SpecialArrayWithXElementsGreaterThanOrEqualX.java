package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        System.out.println(new SpecialArrayWithXElementsGreaterThanOrEqualX().specialArray(new int[]{3}));
    }

    public int specialArray(int[] nums) {
        int n = nums.length;
        if(n==0) return -1;

        if(n==1 && nums[0] != 0) return 1;

        Arrays.sort(nums);

        int i=0;
        while (i<n && nums[i]==0) i++;

        if(i == n)
            return -1;

        for (int j = i; j < n; j++) {
            int m = n-j;
            if(nums[j] == m) {
                if(j == 0){
                    return m;
                } else if(j-1 >= 0 && nums[j-1] != m) {
                    return m;
                }
            }
            else if(nums[j] > m){
                if(j == 0){
                    return m;
                } else if(j-1 >= 0 && nums[j-1] < m) {
                    return m;
                }
            }
        }

        return -1;
    }
}
