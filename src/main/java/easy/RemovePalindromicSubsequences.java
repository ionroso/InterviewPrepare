package easy;

import java.util.ArrayList;
import java.util.List;

public class RemovePalindromicSubsequences {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().removePalindromeSub("ababb"));
        }

        class Solution {
            Solution() {

            }

            public int removePalindromeSub(String s) {
                if(s==null || s.isEmpty()){
                    return 0;
                }

                int n = s.length();
                if(n==1){
                    return 1;
                }

                int l = 0, r = n-1;
                int count = 1;
                while (l<r){
                    if(s.charAt(l) == s.charAt(r)){
                        l++;
                        r--;
                        continue;
                    }

                    if(l+1<=r && s.charAt(l+1) == s.charAt(r)){
                        l++;
                    } else {
                        r--;
                    }

                    l++;
                    r--;

                    count++;
                }

                return count;
            }
        }
    }
}
