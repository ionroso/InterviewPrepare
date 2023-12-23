package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class JumpGameVI {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
           System.out.println(new Solution().maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
        }


        class Score {
            int score;
            int index;

            public Score(int index, int score) {
                this.index = index;
                this.score = score;
            }
        }
        class Solution {
            public int maxResult(int[] nums, int k) {
                int n = nums.length;
                int score = nums[0];
                Deque<Score> dq = new LinkedList<>();
                dq.offerLast(new Score(0, score));
                for (int i = 1; i < n; i++) {
                    // pop the old index
                    while (dq.peekFirst() != null && dq.peekFirst().index < i - k) {
                        dq.pollFirst();
                    }
                    score = dq.peek().score + nums[i];
                    // pop the smaller value
                    while (dq.peekLast() != null && score >= dq.peekLast().score) {
                        dq.pollLast();
                    }
                    dq.offerLast(new Score(i, score));
                }
                return score;
            }
        }


        class SolutionPriorityQueue {
            public int maxResult(int[] nums, int k) {
                int n = nums.length;
                int[] score = new int[n];
                score[0] = nums[0];
                PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
                priorityQueue.add(new int[] { score[0], 0 });
                for (int i = 1; i < n; i++) {
                    // pop the old index
                    while (priorityQueue.peek()[1] < i - k) {
                        priorityQueue.poll();
                    }
                    score[i] = score[priorityQueue.peek()[1]] + nums[i];
                    priorityQueue.add(new int[] { score[i], i });
                }
                return score[n - 1];
            }
        }


        class Solution1 {
            public int maxResult(int[] nums, int k) {
                int n = nums.length;
                int[] score = new int[n];
                score[0] = nums[0];
                PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
                priorityQueue.add(new int[] { nums[0], 0 });
                for (int i = 1; i < n; i++) {
                    // pop the old index
                    while (priorityQueue.peek()[1] < i - k) {
                        priorityQueue.remove();
                    }
                    score[i] = nums[i] + score[priorityQueue.peek()[1]];
                    priorityQueue.add(new int[] { score[i], i });
                }
                return score[n - 1];
            }
        }

        class SolutionMy_TimeLimitedExcited {
            public int maxResult(int[] nums, int k) {
                int n = nums.length;
                int[] score = new int[n];
                boolean[] computed = new boolean[n];
                score[0] = nums[0];
                computed[0] = true;

                for(int i = 0; i < n-1; i++){
                    for(int j = i + 1; j <= Math.min(n-1, i + k); j++){
                        if(!computed[j]) {
                            score[j] = score[i] + nums[j];
                            computed[j] = true;
                            continue;
                        }

                        score[j] = Math.max(score[j], score[i] + nums[j]);
                    }
                }
                return score[n-1];
            }
        }
    }
}
