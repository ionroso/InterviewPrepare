package easy;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
       String num1 = Integer.toBinaryString(x);
       String num2 = Integer.toBinaryString(y);

       StringBuilder longer = new StringBuilder(num1.length() > num2.length() ? num1 : num2);
       StringBuilder shorter = new StringBuilder(num1.length() > num2.length() ? num2 : num1);

       int delta = longer.length() - shorter.length();
       int hdist = 0;
       int j = 0;
        for (int i = 0; i < longer.length(); i++) {
            if(i<delta){
                hdist += longer.charAt(i) == '1' ? 1 : 0;
            } else {
                hdist += longer.charAt(i+delta) == shorter.charAt(j) ? 0 : 1;
                j++;
            }
        }

        return hdist;
    }
}
