package medium;

import java.util.HashMap;
import java.util.Map;

public class MaximizeTheConfusionOfAnExam {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().maxConsecutiveAnswers("FFFTTFTTFT", 3));
        }


        class Solution {
            public int maxConsecutiveAnswers(String answerKey, int k) {
                int n = answerKey.length();
                int left = 0, right = n;

                while (left < right) {
                    int mid = (left + right + 1) / 2;

                    if (isValid(answerKey, mid, k)) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }

                return left;
            }

            private boolean isValid(String answerKey, int size, int k) {
                int n = answerKey.length();
                Map<Character, Integer> counter = new HashMap<>();

                for (int i = 0; i < size; i++) {
                    char c = answerKey.charAt(i);
                    counter.put(c, counter.getOrDefault(c, 0) + 1);
                }

                if (Math.min(counter.getOrDefault('T', 0), counter.getOrDefault('F', 0)) <= k) {
                    return true;
                }

                for (int i = size; i < n; i++) {
                    char c1 = answerKey.charAt(i);
                    counter.put(c1, counter.getOrDefault(c1, 0) + 1);
                    char c2 = answerKey.charAt(i - size);
                    counter.put(c2, counter.getOrDefault(c2, 0) - 1);

                    if (Math.min(counter.getOrDefault('T', 0), counter.getOrDefault('F', 0)) <= k) {
                        return true;
                    }
                }

                return false;
            }
        }



        class Solution1 {

            public int maxConsecutiveAnswers(String answerKey, int k) {
                int n = answerKey.length();

                int max = Integer.MIN_VALUE;
                int left = 0, right = 0;

                int trueCount = 0, falseCount = 0;
                while (right < n){
                    trueCount += (answerKey.charAt(right) == 'T' ? 1 : 0);
                    falseCount += (answerKey.charAt(right) == 'F' ? 1 : 0);

                    if(trueCount <= k || falseCount <= k){
                        max = Math.max(max, falseCount + trueCount);
                    } else {
                        while (trueCount>k && falseCount>k){
                            trueCount -= (answerKey.charAt(left) == 'T' ? 1 : 0);
                            falseCount -= (answerKey.charAt(left) == 'F' ? 1 : 0);

                            left++;
                        }
                    }

                    right++;
                }

                return max;
            }

            public int maxConsecutiveAnswers1(String answerKey, int k) {
                int n = answerKey.length();
                boolean foundSolution = false;
                int sw = n;
                for (; sw >= 2; sw--) {
                    int countTrue = 0;
                    int countFalse = 0;
                    for (int j = 0; j < n; j++) {
                        if (answerKey.charAt(j) == 'T') {
                            countTrue++;
                        } else {
                            countFalse++;
                        }

                        if (j < sw-1) {
                            continue;
                        }

                        if(j != sw - 1 ){
                            if (answerKey.charAt(j - sw) == 'T') {
                                countTrue--;
                            } else {
                                countFalse--;
                            }
                        }

                        if (countTrue == k || countTrue < k || countFalse == k || countFalse < k) {
                            foundSolution = true;
                            break;
                        }
                    }

                    if(foundSolution){
                        break;
                    }
                }

                return sw;
            }
        }

    }
}
