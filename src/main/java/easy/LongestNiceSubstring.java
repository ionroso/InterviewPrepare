package easy;

import java.util.*;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().longestNiceSubstring("YazaAay"));
        }

        class Solution {
            Solution() {

            }

            public String longestNiceSubstring(String s) {
                for (int size = s.length(); size >=2 ; size--) {
                    for (int j = 0; j + size <= s.length(); j++) {
                        String sub = s.substring(j, j+size);
                        if(checkNiceSubstring(sub)){
                            return sub;
                        }
                    }
                }

                return null;
            }

            private boolean checkNiceSubstring(String sub) {
                Set<Character> set = new HashSet<>();

                char[] chars = sub.toCharArray();
                for (char c: chars) {
                    set.add(c);
                }

                for (char c: chars) {
                    boolean lowerCase = Character.isLowerCase(c);

                    if((lowerCase && !set.contains(Character.toUpperCase(c))) || (!lowerCase && !set.contains(Character.toLowerCase(c)))){
                        return false;
                    }
                }

                return true;
            }
        }
    }
}
