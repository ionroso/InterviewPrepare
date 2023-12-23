package easy;

public class AddBinary {
    public static void main(String[] args) {
        int i = '1' - 48;
        System.out.println(i);
    }
    public String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength, bLength);


        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < maxLength; i++)
        {
            int aBit = i<aLength ? a.charAt(aLength-1-i) - '0' : 0;
            int bBit = i<bLength ? b.charAt(bLength-1-i) - '0' : 0;

            int sum = aBit+bBit+carry;
            carry = sum > 1 ? 1: 0;
            sb.insert(0,sum % 2);
        }
        if(carry==1){
            sb.insert(0,1);
        }

        return sb.toString();
    }
}
