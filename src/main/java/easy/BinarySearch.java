package easy;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3}, 2));
    }

    public static int search(int[] nums, int target) {
        return searchRec(nums, 0, nums.length-1, target);
    }
    public static int searchRec(int[] nums, int l, int r, int target) {
        if(l<=r){
            int mid = l+(r-l-1)/2;
            if(nums[mid] == target){
                return mid;
            }

            return target <= nums[mid] ? searchRec(nums, l, mid, target) : searchRec(nums, mid+1, r, target);
        }

        return -1;
    }
}
