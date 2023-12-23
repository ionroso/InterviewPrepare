package easy;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(3));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        int l = sb.length();
        for (int i = 0; i < l / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(l - 1 - i));
            sb.setCharAt(l - 1 - i, temp);
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}
