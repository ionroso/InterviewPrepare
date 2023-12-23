package easy;

public class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().totalMoney(10));
        }

        class Solution {
            Solution() {

            }

            public int totalMoney(int n) {
                int numWeeks = n/7;
                int remainingDays = n%7;

                int totalMoney = 28 * numWeeks + 7 * (numWeeks-1);


                for (int i = 0; i < remainingDays; i++) {
                    totalMoney+=(numWeeks+i+1);
                }

                return totalMoney;
            }
        }
    }
}
