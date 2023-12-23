package easy;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2));
    }
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c) || Character.isDigit(c))
                sb.append(Character.toUpperCase(c));
        }

        int n = sb.length();

        int l = n%k != 0? n%k : k;
        int offset = 0;
        for (int i = l; i < n ; i+=k) {
            sb.insert(i+offset,"-");
            offset++;
        }

        return sb.toString();
    }
}
