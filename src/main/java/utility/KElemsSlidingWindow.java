package utility;

// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

import easy.MinimumDifferenceBetweenHighestAndLowestOfKScores;

import java.util.Arrays;
import java.util.Stack;

public class KElemsSlidingWindow {

    public static void main(String[] args) {
        new Test().test();
    }
    private static class Test {
        public void test() {
            System.out.println(new Solution().minimumDifference(new int[]{0, 1, 2, 3, 4}, 3));
        }

        class Solution {
            Solution() {

            }

            public int minimumDifference(int[] nums, int k) {
                int n = nums.length;
                Stack<Integer> stack = new Stack<>();
                stack.push(0);

                while (!stack.isEmpty()) {
                    if(stack.size() < k){
                        stack.push( stack.peek() + 1);
                        continue;
                    }

                    print(stack);

                    if(stack.peek() < n-1) {
                        stack.push(stack.pop() + 1);
                        continue;
                    }

                    while(!stack.isEmpty()) {
                        int room = k - stack.size();
                        int numsLeft = n - stack.peek() -1;

                        if(room <= 0 || numsLeft <= 0 || numsLeft < room){
                            stack.pop();
                            if(!stack.isEmpty())
                                stack.push(stack.pop() + 1);
                        } else {
                            break;
                        }
                    }
                }

                return 0;
            }

            private void print(Stack<Integer> stack) {
                for (Integer i : stack) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
    }
}
