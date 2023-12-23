package easy;

public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,0,0}));
    }
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] l_to_r = new int[n];
        int[] r_to_l = new int[n];

        l_to_r[0] = nums[0];
        for (int i = 1; i <= n-1; i++) {
            l_to_r[i] = l_to_r[i-1]+nums[i];
        }

        r_to_l[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            r_to_l[i] = r_to_l[i+1]+nums[i];
        }

        int idx = -1;
        for (int i = 0; i < n; i++) {
          if(l_to_r[i] == r_to_l[i]){
              idx=i;
              break;
          }
        }

        return idx;
    }
}
