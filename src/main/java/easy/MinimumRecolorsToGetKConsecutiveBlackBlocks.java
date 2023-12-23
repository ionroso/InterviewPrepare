package easy;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().minimumRecolors("BW", 1));
        }

        class Solution {
            Solution() {

            }

            public int minimumRecolors(String blocks, int k) {
                int n = blocks.length();

                int min = 0;
                for (int i = 0; i < Math.min(n, k); i++) {
                    if(blocks.charAt(i) == 'W'){
                        min++;
                    }
                }

                int count = min;
                for (int i = k; i < n; i++) {
                    if(blocks.charAt(i) == 'W'){
                        count++;
                    }

                    if(blocks.charAt(i-k) == 'W'){
                        count--;
                    }

                    min = Math.min(min, count);
                }
                return min;
            }
        }
    }


}
