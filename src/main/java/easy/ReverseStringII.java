package easy;

public class ReverseStringII {
    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefabcdef", 3));
    }
    public String reverseStr(String s, int k) {
        int n = s.length();
        k =  Math.min(k, n);

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i<n){
            for (int j = k-1; j >= 0; j--) {
                sb.append(s.charAt(i+j));
            }

            for (int j = k; j < 2*k; j++) {
                sb.append(s.charAt(i+j));
            }


            i+=2*k;
        }

        return sb.toString();
    }
}
