package easy;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().reverseWords("abc  ab"));
        }

        class Solution {
            public String reverseWords(String s) {
                int n = s.length();
                StringBuilder sb = new StringBuilder(s);
                int prev = 0;
                for (int i = 0; i < n; i++) {
                    if(sb.charAt(i) == ' ' || i == n-1){
                        if(i == n-1){
                          i++;
                        }

                        int len = i - prev + 1;
                        int offset = 0;
                        while (offset < len/2){
                            char temp = sb.charAt(prev+offset);
                            sb.setCharAt(prev+offset, sb.charAt(i - 1 -offset));
                            sb.setCharAt(i -1 -offset, temp);

                            offset++;
                        }
                        prev = i+1;
                    }
                }

                return sb.toString();
            }
        }
    }
}
