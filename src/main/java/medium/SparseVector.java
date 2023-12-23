package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class SparseVector {
    public Map<Integer, Integer> currentSV;

    SparseVector(int[] nums) {
        currentSV = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0)
            {
                currentSV.put(i, nums[i]);
            }
        }
    }

    public static void main(String[] args) {

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int prod=0;
        for (Map.Entry<Integer, Integer> entry : currentSV.entrySet()) {
            if(currentSV.containsKey(entry.getKey()))
            {
                prod+=currentSV.get(entry.getKey())* entry.getValue();
            }
        }

        return prod;
    }

}
