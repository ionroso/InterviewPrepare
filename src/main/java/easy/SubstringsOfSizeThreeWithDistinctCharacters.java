package easy;

import java.util.HashMap;
import java.util.Map;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().countGoodSubstrings("aababcabc"));
        }

        class Solution {
            public int countGoodSubstrings(String s) {
                if(s.length()<3) return 0;


                int goodSub = 0;
                for (int i = 2; i < 3; i++) {
                   goodSub += !(s.charAt(i-2) == s.charAt(i-1) && s.charAt(i-2) == s.charAt(i) && s.charAt(i-1) == s.charAt(i)) ? 1 : 0;
                }

                return goodSub;
            }
        }
    }
}
