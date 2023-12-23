package easy;

/*
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(new MaximumAverageSubarrayI().findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    public double findMaxAverage(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i=0; i < nums.length; i++) {
            if(i<k){
                sum+=nums[i];
                continue;
            }

            sum-=nums[i-k];
            sum+=nums[i];
            max=Math.max(max, sum);
        }

        return max/k;
    }
}
