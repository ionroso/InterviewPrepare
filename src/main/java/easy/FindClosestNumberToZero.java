package easy;

public class FindClosestNumberToZero {
    public int findClosestNumber(int[] nums) {

        int minDist = Integer.MAX_VALUE;
        int minLargestVal = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int dist = Math.abs(nums[i]);
            if(dist<minDist){
                minDist = dist;
                minLargestVal = Math.max(minLargestVal, nums[i]);
            }
        }

        return minLargestVal;
    }
}
