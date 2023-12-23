package test;

import java.util.Arrays;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {

        sumRepresentationsOfANumber(4);
    }

    private static void sumRepresentationsOfANumber(int num)
    {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        int currVal = 1;

        while (!stack.isEmpty()){
            if(currVal < num){
                stack.add(1);
                currVal+=1;
            } else {
                printStack(stack);
                currVal -= stack.pop();
                if(stack.size() == 0){
                    break;
                }
                int temp = stack.pop();
                currVal -= temp;
                stack.add(temp+1);
                currVal += stack.peek();
            }
        }
    }

    private static void printStack(Stack<Integer> stack) {
        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int count = 0;
        int i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0;
            int maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }

    private static void testArrayChange(int[] at) {
        at[2] = 0;
    }

    public static int minJump(int arr[],int result[]){

        int []jump = new int[arr.length];
        jump[0] = 0;
        for(int i=1; i < arr.length ; i++){
            jump[i] = Integer.MAX_VALUE-1;
        }

        for(int i=1; i < arr.length; i++){
            for(int j=0; j < i; j++){
                if(arr[j] + j >= i){
                    if(jump[i] > jump[j] + 1){
                        result[i] = j;
                        jump[i] = jump[j] + 1;
                    }
                }
            }
        }

        return jump[jump.length-1];
    }



}
