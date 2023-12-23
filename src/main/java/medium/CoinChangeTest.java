package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeTest {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution(). coinChange(new int[]{186,419,83,408}, 6249));
//            System.out.println(new Solution(). coinChange(new int[]{1,3,5}, 5));

        }

        private
        class Solution {

            public int coinChange(int[] coins, int amount) {
                if (amount < 1) return 0;
                return coinChange(coins, amount, new HashMap<>());
            }

            private int coinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
                if (amount < 0) return -1;
                if (amount == 0) return 0;
                if (memo.containsKey(amount - 1) && memo.get(amount - 1) != 0) return memo.get(amount - 1);
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    int res = coinChange(coins, amount - coin, memo);
                    if (res >= 0 && res < min)
                        min = 1 + res;
                }
                memo.put(amount - 1, (min == Integer.MAX_VALUE) ? -1 : min);
                return memo.get(amount - 1);
            }
        }

        private
        class Solution1 {
            public int coinChange(int[] coins, int amount) {
                Arrays.sort(coins);
                int n = coins.length;
                int[] counts = new int[n];

                int tempAmount = amount;
                for (int i = n-1; i>=0; i--){
                    if(coins[i]<tempAmount){
                        counts[i] = tempAmount / coins[i];
                        tempAmount -= tempAmount % coins[i];
                    }
                }

                while(true){
                    for(int i = n-1; i >= 0; i--){
                       if(counts[i] != 0){
                           counts[i]--;
                           for (int j = i-1; j>=0; j--){
                               if(coins[j]<tempAmount){
                                   counts[j] = tempAmount / coins[j];
                                   tempAmount -= tempAmount % coins[j];
                               }
                           }
                       }
                    }
                }


            }

            public int coinChangeRec(int[] coins, int n, int count, int amount) {
                if(amount == 0){
                    return count;
                }


                if(n == -1){
                    return 0;
                }

                int min = Integer.MAX_VALUE;
                for(int i = n; i>=0; i--){
                    if(coins[i] <= amount){
                        int c = amount / coins[i];
                        for(int j = c; j>0; j--){
                          int rez =  coinChangeRec(coins, n-1, count+j, amount - j * coins[i]);
                          if(rez > 0 && min > rez ){
                              min = rez;
                          }
                        }
                    }
                }

                return min;
            }

            //
//            public int coinChange1(int[] coins, int amount) {
//                Arrays.sort(coins);
//
//                int n = coins.length;
//
//                int i = n-1, totalCoins = 0;
//                while (i>=0 && amount>0){
//                    if(coins[i]<=amount){
//                        totalCoins += amount / coins[i];
//                        amount = amount % coins[i];
//                    }
//
//                    i--;
//                }
//
//                return totalCoins;
//            }

        }
    }


}
