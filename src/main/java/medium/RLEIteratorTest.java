package medium;

public class RLEIteratorTest {
    public static void main(String[] args) {
        RLEIterator rLEIterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5}); // This maps to the sequence [8,8,8,5,5].
        rLEIterator.next(2); // exhausts 2 terms of the sequence, returning 8. The remaining sequence is now [8, 5, 5].
        rLEIterator.next(1); // exhausts 1 term of the sequence, returning 8. The remaining sequence is now [5, 5].
        rLEIterator.next(1); // exhausts 1 term of the sequence, returning 5. The remaining sequence is now [5].
        rLEIterator.next(2); // exhausts 2 terms, returning -1. This is because the first term exhausted was 5, but the second term did not exist. Since the last term exhausted does not exist, we return -1.

    }

    static
    class RLEIterator {

        private int currTerm;
        private final int[] encoding;
        public RLEIterator(int[] encoding) {
            this.encoding = encoding;
        }

        public int next(int n) {
            int output = -1;
            boolean found = false;
            while (!found && currTerm < encoding.length-1){
                encoding[currTerm] -= n;

                if(encoding[currTerm] > 0){
                    output = encoding[currTerm+1];
                    found = true;
                } else if (encoding[currTerm] == 0) {
                    output = encoding[currTerm+1];
                    currTerm +=2;
                    found = true;
                } else {
                    n = -1 * encoding[currTerm];
                    currTerm +=2;
                }
            }

            return output;
        }
    }
}
