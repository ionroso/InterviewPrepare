package medium;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
        }

        class Solution {

            public List<List<Integer>> threeSum(int[] nums) {

                Arrays.sort(nums);

                List<List<Integer>> output = new ArrayList<>();
                Set<String> set = new HashSet<>();



                for (int i = 0; i< nums.length-2;i++){
                    if(nums[i]>0){
                        break;
                    }

                    for (int j = i+2; j < nums.length; j++) {
                        int k = bs(nums, 0 - (nums[i] + nums[j]), i+1, j-1);
                        if(k != -1 && !set.contains(nums[i]+","+nums[k]+","+nums[j])){
                            output.add(Arrays.asList(nums[i],nums[k],nums[j]));
                            set.add(nums[i]+","+nums[k]+","+nums[j]);
                        }
                    }
                }

                return output;
            }

            private int bs(int[] nums, int sum, int l, int r) {
                if(l==r && nums[l]==sum){
                    return l;
                }

                while (l<r-1){
                    int mid = l+(r-l)/2;
                    if(nums[mid] == sum){
                        return mid;
                    } else if(nums[mid] > sum){
                        r = mid;
                    } else {
                        l = mid;
                    }
                }

                if(nums[l] == sum){
                    return l;
                }

                if(nums[r] == sum){
                    return r;
                }

                return -1;
            }
        }
    }
}
