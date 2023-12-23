package easy;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = new int[]{4,5};
//        int k = removeElement(nums, 5);

        int[] nums = new int[]{3,2,2,3};
        int k = removeElement(nums, 3);


        System.out.println(k);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n==1) {
           if (nums[0] == val) return 0;
           return 1;
        }


        int start = 0, end = n-1;
        while (start < end){
            if(nums[start] == val && nums[end] == val) {
                end--;
            } else if(nums[start] == val && nums[end] != val){
                nums[start] = nums[end];
                nums[end] = val;
            } else {
                start++;
            }
        }

        int k = 0;
        while (k<n && nums[k]!=val) k++;
        return k;
    }
}
