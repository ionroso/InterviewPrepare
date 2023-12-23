package easy;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        if(s == null || s.isEmpty()) return 0;

        if(s.length() == 1) return 1;

        int consChar = Integer.MIN_VALUE, current = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                current++;
            } else {
                consChar = Math.max(consChar, current);
            }
        }

        return consChar;
    }
}
