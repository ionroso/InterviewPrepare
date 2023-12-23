package easy;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{3,0,1}));
    }

    public int missingNumber(int[] nums) {
        boolean[] presentOrNotArr = new boolean[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            presentOrNotArr[nums[i]] = true;
        }

        int missing = 0;
        for (int i = 0; i < presentOrNotArr.length; i++) {
            if(!presentOrNotArr[i]){
                missing = i;
                break;
            }
        }

        return missing;
    }
}
