package easy;

public class DietPlanPerformance {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().dietPlanPerformance(new int[]{1,2,3,4,5}, 1, 3, 3));
        }

        class Solution {
            Solution() {
            }

            public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
                int n = calories.length;

                int score = 0;
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (i < k) {
                        sum += calories[i];
                        continue;
                    }

                    score += (sum < lower ? 1 : 0);
                    score += (sum > upper ? 1 : 0);

                    sum += calories[i];
                    sum -= calories[i - k];
                }

                score += (sum < lower ? 1 : 0);
                score += (sum > upper ? 1 : 0);

                return score;
            }
        }
    }
}
