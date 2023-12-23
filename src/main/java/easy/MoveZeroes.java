package easy;

public class MoveZeroes {
    public static void main(String[] args) {

    }

    public static void moveZeroes(int[] nums) {
        int i=0;
        for (int k = 0; k < nums.length; k++) {
            if(nums[k]!=0) {
                nums[i++] = nums[k];
            }
        }

        for (int j = i; j < nums.length ; j++) {
            nums[j] = 0;
        }
    }
}
