package easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {

    }
    public int[] sortedSquares(int[] nums) {
            return
                Arrays.stream(nums)
                .map(p -> (int)Math.pow(p, 2))
                .sorted()
                .toArray();
    }
}
