package easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("9,8"));
//        System.out.println(Character.toLowerCase('9'));
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;

        while (l<r)
        {
            boolean validLeftChar = isValidChar(s.charAt(l));
            if(!validLeftChar){
                l++;
                continue;
            }

            boolean validRightChar = isValidChar(s.charAt(r));
            if(!validRightChar){
                r--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
            {
                return false;
            }

            l++;
            r--;
        }



        return true;
    }

    public boolean isValidChar(char c){
        return (c - 'a' >= 0 && c - 'a' < 26) || (c - 'A' >= 0 && c - 'A' < 26) || (c - '0' >= 0 && c - '0' <= 9);
    }

}
