package easy;

public class GuessNumberHigherOrLower {
    int n, g;

    public GuessNumberHigherOrLower(int g) {
        this.g = g;
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherOrLower(6).guessNumber(10));
    }

    public int guessNumber(int n) {
        int curr = n;
        int rez = -1;
        int lastMin = 0, lastMax = n-1;
        while((rez = guess(curr)) != 0){
            if(rez == -1) {
                lastMax = curr;
            } else {
                lastMin = curr;
            }

            curr = (lastMin + lastMin) / 2;
        }

        return curr;

    }

    public int guess(int n) {
        if(n == 6) return 0;

        if(n < 6) return 1;

        return -1;
    }

}
