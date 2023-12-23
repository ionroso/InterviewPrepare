package easy;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {
    public static void main(String[] args) {

    }

    static
    class OrderedStream {
        private String[] array;
        private int ptr = 0;
        private int n;

        public OrderedStream(int n) {
            this.n = n;
            this.array = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            array[idKey] = value;

            List<String> output = new ArrayList<>();
            if(idKey == ptr){
                while (ptr < n && array[ptr] != null){
                    output.add(array[ptr]);
                    ptr++;
                }
            }

            return output;
        }
    }

}
