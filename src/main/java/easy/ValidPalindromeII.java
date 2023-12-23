package easy;

public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(new StringBuilder("eeccccbebaeeabebccceea").reverse());
        //System.out.println(new ValidPalindromeII().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindromeRec(String s, int l, int r, boolean alreadyChecked) {
        if(l == r){
            return true;
        }

        if(s.charAt(l) == s.charAt(r)){
            return validPalindromeRec(s, l+1, r-1, false);
        }

        if (alreadyChecked) {
            return false;
        }

        if(l+1 <= r && s.charAt(l+1) == s.charAt(r)){
            validPalindromeRec(s, l+1, r, true);
        }

        if(l <= r-1 && s.charAt(l) == s.charAt(r-1) && !alreadyChecked){
            validPalindromeRec(s, l, r-1, true);
        }

        return false;
    }

        public boolean validPalindrome(String s) {
        int l=0, r=s.length()-1;

        boolean alreadyChecked = false;
        while (l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
                continue;
            }

            if(l+1 <= r && s.charAt(l+1) == s.charAt(r) && !alreadyChecked){
                l++;
                alreadyChecked = true;
                continue;
            }

            if(l <= r-1 && s.charAt(l) == s.charAt(r-1) && !alreadyChecked){
                r--;
                alreadyChecked = true;
                continue;
            }

            return false;
        }

        return true;
    }
}
