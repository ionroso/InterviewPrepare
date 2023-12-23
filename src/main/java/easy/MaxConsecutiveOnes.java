package easy;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,0,1,1}));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCons = 0;
        int i = 0;
        while (i< nums.length)
        {
            if(nums[i] != 1){
                i++;
                continue;
            }
            int j = i;
            while (j<nums.length && nums[j] == 1)
            {
                j++;
            }

            maxCons = Math.max(maxCons, j-i);
            i=j;
        }

        return maxCons;
    }
}
