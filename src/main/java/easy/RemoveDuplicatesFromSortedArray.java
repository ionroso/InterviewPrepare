package easy;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }

    static public int removeDuplicates(int[] nums) {


        int s = 0, f = 1;
        while (f < nums.length) {
            if(nums[f-1]==nums[f]){
                f++;
                continue;
            }

            if(nums[f] != nums[f-1] && nums[s] == nums[f-1]){
                nums[++s] = nums[f];
            } else {
                s++;
            }
            f++;
        }


        return s;
    }
}
