import java.util.Arrays;

public class Binary {
    public static void main(String[] args) {
//        System.out.println(findComplement(5));

    }

    public int[] countBits(int n) {
        int[] output = new int[n+1];

        for (int i = 0; i <= n; i++) {
            output[i] = countOnes(Integer.toBinaryString(i));
        }
        return output;
    }

    private int countOnes(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == 1){
                count++;
            }
        }

        return count;
    }
    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(5);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            sb.append(binary.charAt(i) == '0' ? 1 : 0);
        }

        return Integer.parseInt(sb.toString(),2);
    }
}
