package easy;

import java.util.Stack;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int passOver = 1;
        for (int i = digits.length -1; i >=0; i--) {
            if(digits[i] == 9 && passOver == 1) {
                stack.add(0);
            } else {
                stack.add(digits[i] + passOver);
                passOver = 0;
            }
        }

        if(stack.peek() == 0){
            stack.add(1);
        }

        int[] output = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            output[i++] = stack.pop();
        }

        return output;
    }
}
