package medium;

import java.util.*;

public class CoinChangeII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {

        public void test() {
            System.out.println(new Solution().change(1, new int[]{1,2}));
        }

        class Solution {
            int[][] memo;
            int[] coins;

            public int numberOfWays(int i, int amount) {
                if (amount == 0) {
                    return 1;
                }
                if (i == coins.length) {
                    return 0;
                }
                if (memo[i][amount] != -1) {
                    return memo[i][amount];
                }

                if (coins[i] > amount) {
                    return memo[i][amount] = numberOfWays(i + 1, amount);
                }

                memo[i][amount] = numberOfWays(i, amount - coins[i]) + numberOfWays(i + 1, amount);
                return memo[i][amount];
            }

            public int change(int amount, int[] coins) {
                this.coins = coins;
                memo = new int[coins.length][amount + 1];
                for (int[] row : memo) {
                    Arrays.fill(row, -1);
                }

                return numberOfWays(0, amount);
            }
        }
        class Solution1 {
            public int change(int amount, int[] coins) {
                return changeRec(coins, amount, new HashSet<>(), new LinkedList<>());
            }

            public int changeRec(int[] coins, int amount, Set<String> memo, Deque<Integer> stack) {
                if(amount < 0) {
                    return 0;
                }

                if (amount == 0){
                    int[] array = new int[stack.size()];
                    Arrays.sort(array);
                    String key = Arrays.toString(array);
                    if(memo.contains(key)){
                        return 0;
                    }
                    memo.add(key);
                    return 1;
                }

                int count = 0;
                for(int i = 0; i < coins.length; i++){
                    stack.addLast(coins[i]);
                    count += changeRec(coins, amount - coins[i], memo, stack);
                    stack.removeLast();
                }

                return count;
            }
        }

    }
}
