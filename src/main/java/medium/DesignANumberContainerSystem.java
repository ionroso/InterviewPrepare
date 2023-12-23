package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignANumberContainerSystem {

    public static void main(String[] args) {

    }
    class NumberContainers {

        Map<Integer, Integer> indexToNumber;

        Map<Integer, PriorityQueue<Integer>> numberIndexPQ;


        public NumberContainers() {
            indexToNumber = new HashMap<>();
            numberIndexPQ = new HashMap<>();
        }

        public void change(int index, int number) {
            if(!indexToNumber.containsKey(index)){
                indexToNumber.put(index, number);
                numberIndexPQ.computeIfAbsent(number, k->new PriorityQueue<>()).offer(index);
            } else {
                int numAtIndex = indexToNumber.get(index);
                PriorityQueue numAtIndexPQ = numberIndexPQ.get(numAtIndex);
                numAtIndexPQ.remove(Integer.valueOf(index));

                indexToNumber.put(index,number);
                numberIndexPQ.computeIfAbsent(number, k->new PriorityQueue<>()).offer(index);
            }
        }

        public int find(int number) {
            if(!numberIndexPQ.containsKey(number)){
                return -1;
            }

            return numberIndexPQ.get(number).peek();
        }
    }

}
