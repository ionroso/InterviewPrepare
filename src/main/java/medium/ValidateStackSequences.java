package medium;

import java.util.Stack;

public class ValidateStackSequences {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
        }

        class Solution {
            Solution() {
            }

            public boolean validateStackSequences(int[] pushed, int[] popped) {
                Stack<Integer> stack = new Stack<>();
                int pushPtr = 0, popPtr = 0;


                // Start
                stack.push(pushed[++pushPtr]);

                while (pushPtr<pushed.length && popPtr < popped.length){
                    while (stack.peek() == popped[popPtr]){
                        stack.pop();
                        popPtr++;
                    }

                    stack.push(pushed[++pushPtr]);
                }

                return stack.isEmpty();
            }
        }
    }
}
