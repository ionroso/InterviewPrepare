package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        }

        class Solution {
            public int lengthOfLongestSubstring(String s) {
                if(s.isEmpty()) return 0;

                int n = s.length();
                Set<Character> set = new HashSet<>();
                int left = 0, right = 0;
                int max = Integer.MIN_VALUE;

                while (right < n) {
                    char c = s.charAt(right);
                    if(set.contains(c)){
                        while (s.charAt(left) != c){
                            set.remove(s.charAt(left));
                            left++;
                        }

                        set.remove(s.charAt(left));
                        left++;
                    }

                    set.add(c);

                    max = Math.max(max, right - left + 1);

                    right++;
                }

                return max;
            }
        }
    }

}
