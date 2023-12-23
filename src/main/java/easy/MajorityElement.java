package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();

        int majNum=-1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer currFreq  = freq.get(num);
            int newFreq = 1;
            if(currFreq == null)
            {
                freq.put(nums[i], newFreq);
            } else {
                newFreq = currFreq+1;
                freq.put(num, newFreq);
            }

            if(currFreq + 1 == nums.length/2){
                majNum = num;
                break;
            }
        }

        return majNum;
    }
}
