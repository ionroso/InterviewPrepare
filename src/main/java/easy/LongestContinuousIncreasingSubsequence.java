package easy;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{3,1,3,1,5,0,7}));
    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;

        int i = 1;
        int lcis = 1;
        int max = -1;
        while (i < nums.length){
            if(nums[i-1]<nums[i]){
                lcis++;
            } else {
                max = Math.max(max, lcis);
                lcis = 1;
            }
            i++;
        }

        max = Math.max(max, lcis);

        return max;
    }
}
