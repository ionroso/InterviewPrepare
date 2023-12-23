package easy;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i=0, j=0;
        while (j<nums.length){
            while (j<nums.length && nums[j]%2!=0){
                j++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }
}
