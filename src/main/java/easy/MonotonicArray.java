package easy;

public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{6,5,4,4}));
    }

    public boolean isMonotonic(int[] nums) {
        if(nums.length == 0) return false;
        if(nums.length == 1) return true;

        int j=1;
        while(j < nums.length && nums[0] == nums[j]){
            j++;
        }

        if(j==nums.length) {
            j--;
        }

        int s = nums[0] - nums[j] > 0 ? 1 : -1;

        for(int i = 1; i < nums.length; i++){
            if(s * (nums[i-1] - nums[i]) < 0) return false;
        }


        return true;
    }
}
