package easy;

import java.util.Arrays;
import java.util.Stack;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(0));
    }
    public int addDigits(int num) {
        int[] rez = getDigit(num);
        while (rez.length != 1){
            num = Arrays.stream(rez).sum();
            rez = getDigit(num);
        }

        return rez[0];
    }

    private int[] getDigit(int number) {

        Stack<Integer> stack = new Stack<>();

        while (number > 0) {
            int remainder = number % 10;
            stack.add(remainder);
            number = number / 10;
        }

        int[] arr = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()){
            arr[i++] = stack.pop();
        }

        return arr;
    }

}
