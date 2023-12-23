package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
           set.add(num);
        }

        List<Integer> output = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if(!set.contains(i)) {
                output.add(i);
            }
        }

        return output;
    }
}
