package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignCompressedStringIterator {
    public static void main(String[] args) {
        String compressedString = "L12e2t1C1o1d1e1";
        int[] nums = Arrays.stream(compressedString.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();
        String[] chars = compressedString.split("[0-9]+");

        StringIterator si = new StringIterator("x6");
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.hasNext());
        System.out.println(si.next());
        System.out.println(si.next());
        System.out.println(si.next());

        System.out.println(si.next());
        System.out.println(si.next());
    }
    static class StringIterator {
        private Integer leftCount;
        private Integer currIndex;
        private List<Character> letters;
        private List<Integer> counts;

        public StringIterator(String compressedString) {
            this.letters = new ArrayList<>();
            this.counts = new ArrayList<>();
            parse(compressedString);

            this.currIndex = 0;
            this.leftCount = counts.get(this.currIndex);
        }

        public char next() {
            boolean takeNext = true;
            if(this.leftCount == 0){
                if(this.currIndex < this.letters.size()-1){
                    this.currIndex++;
                    this.leftCount = counts.get(this.currIndex);
                } else {
                    takeNext = false;
                }
            }

            char c = ' ';
            if(takeNext) {
                c = this.letters.get(this.currIndex);
            }

            if(hasNext()){
                this.leftCount--;
            }

            return c;
        }

        public boolean hasNext() {
            return !(this.currIndex == this.letters.size()-1 && this.leftCount == 0);
        }

        private void parse(String s){
            int i=0;
            StringBuilder sb = new StringBuilder();
            while (i<s.length()){
                char c = s.charAt(i);
                if(Character.isLetter(c)){
                    this.letters.add(c);
                    if(!sb.isEmpty()){
                        this.counts.add(Integer.parseInt(sb.toString()));
                        sb.setLength(0);
                    }
                } else {
                    sb.append(c);
                }

                i++;
            }

            this.counts.add(Integer.parseInt(sb.toString()));

            if(this.letters.size() != this.counts.size()) {
                throw new IllegalArgumentException("mismatch");
            }
        }
    }
}
