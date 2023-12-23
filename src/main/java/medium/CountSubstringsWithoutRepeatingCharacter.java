package medium;

import java.util.HashSet;
import java.util.Set;

public class CountSubstringsWithoutRepeatingCharacter {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().numberOfSpecialSubstrings("abcd"));
        }

        class Solution {
            Solution() {}

            public int numberOfSpecialSubstrings(String s) {
                int n = s.length();
                int count = n;

                for (int i = n; i >= 2; i--) {
                    int c = numKLenSubstrNoRepeats(s, i);
                    count+= c;
                }

                return count;
            }

            public int numKLenSubstrNoRepeats(String s, int k) {
                int n = s.length();
                int count = 0;
                Set<Character> set = new HashSet<>();

                int l=0, r=0;
                while (r<n){

                    if(!set.contains(s.charAt(r))){
                        set.add(s.charAt(r));
                    } else {
                        while (s.charAt(l) != s.charAt(r)){
                            set.remove(s.charAt(l));
                            l++;
                        }
                        l++;
                    }

                    if(r-l+1 == k){
                        count++;
                        set.remove(s.charAt(l));
                        l++;
                    }

                    r++;
                }

                return count;
            }
        }
    }

}
