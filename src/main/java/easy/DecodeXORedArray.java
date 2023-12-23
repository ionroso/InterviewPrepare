package easy;

public class DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int[] output = new int[encoded.length+1];
        output[0] = first;
        for (int i = 1; i < encoded.length; i++) {
            output[i] = encoded[i-1] ^ output[i-1];
        }
        return output;
    }

    public static void main(String[] args) {

    }
}
