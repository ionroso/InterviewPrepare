package easy;

import java.util.Arrays;
import java.util.Map;

public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
//            int[] rez = new Solution().shortestToChar("loveleetcode", 'e');
            int[] rez = new Solution().shortestToChar("loveleetcode", 'e');
            Arrays.stream(rez).forEach(e-> System.out.print(e +" "));
        }

        class Solution {

            private static int MAX = Integer.MAX_VALUE;
            Solution() {}

            public int[] shortestToChar(String s, char c) {

                int n = s.length();
                int[] rez = new int[n];
                Arrays.fill(rez, MAX);

                for (int i = 0; i < s.length(); i++) {
                    int leftPtr = i;
                    int rightPtr = n-1-i;

                    if(s.charAt(leftPtr) == c){
                        rez[leftPtr] = 0;
                    } else if(leftPtr!=0){
                        rez[leftPtr] = Math.min(rez[leftPtr], rez[leftPtr-1] != MAX ? rez[leftPtr-1] + 1 : MAX);
                    }

                    if(s.charAt(rightPtr) == c){
                        rez[rightPtr] = 0;
                    } else if(rightPtr!=n-1){
                        rez[rightPtr] = Math.min(rez[rightPtr], rez[rightPtr+1] != MAX ? rez[rightPtr+1] + 1 : MAX);
                    }
                }

                return rez;
            }
        }
    }
}
