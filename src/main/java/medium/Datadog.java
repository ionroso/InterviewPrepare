package medium;

public class Datadog {
    public static void main(String[] args) {
        int[] input = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < input.length; i++) {
            System.out.println(i  + " " + input[i] + " " + input[i] / 2 + " " + input[i] % 2);
        }
    }
}
