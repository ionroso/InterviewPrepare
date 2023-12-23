package easy;

public class PalindromeNumber {
    boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));

        for (int i = 0; i < sb.length()/2; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}
