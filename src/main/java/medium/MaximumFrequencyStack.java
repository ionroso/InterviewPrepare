package medium;

import java.util.*;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(7); // The stack is [5,7]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }


    static
    class FreqStack {
        public void push(int val) {
            count.merge(val, 1, Integer::sum);
            countToStack.putIfAbsent(count.get(val), new ArrayDeque<>());
            countToStack.get(count.get(val)).push(val);
            maxFreq = Math.max(maxFreq, count.get(val));
        }

        public int pop() {
            final int val = countToStack.get(maxFreq).pop();
            count.merge(val, -1, Integer::sum);
            if (countToStack.get(maxFreq).isEmpty())
                --maxFreq;
            return val;
        }

        private int maxFreq = 0;
        private Map<Integer, Integer> count = new HashMap<>();
        private Map<Integer, Deque<Integer>> countToStack = new HashMap<>();
    }



    static
    class FreqStack2 {
        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack2() {
            freq = new HashMap();
            group = new HashMap();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq)
                maxfreq = f;

            group.computeIfAbsent(f, z-> new Stack()).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }

    static
    class FreqStack1 {
        List<Integer> stack;
        Map<Integer, Integer> numToFreq;
        Map<Integer, Set<Integer>> freqToNums;
        int maxFreq;

        public FreqStack1() {
            stack = new ArrayList<>();
            numToFreq = new HashMap<>();
            freqToNums = new HashMap<>();
        }

        public void push(int val) {
            stack.add(0, val);

            if(!numToFreq.containsKey(val)){
                addFreq(val, 1);

                return;
            }

            int currFreq = numToFreq.get(val);
            removeFromFreqToNums(currFreq, val);

            currFreq++;

            addFreq(val, currFreq);
        }

        private void addFreq(int val, int freq) {
            maxFreq = Math.max(maxFreq, freq);
            numToFreq.put(val, freq);
            freqToNums.computeIfAbsent(freq, k -> new HashSet()).add(val);
        }

        public int pop() {

           Set<Integer> set = freqToNums.get(maxFreq);

            ListIterator<Integer> iter = stack.listIterator();
            int output = -1;
            while(iter.hasNext()){
                output = iter.next();
                if(set.contains(output)){
                    iter.remove();
                    break;
                }
            }

            if(output == -1){
                return output;
            }

            removeFromFreqToNums(maxFreq, output);

            addFreq(output, maxFreq-1);

            if(freqToNums.get(maxFreq).size() == 0){
                maxFreq = maxFreq -1;
            }

            return output;
        }

        private void removeFromFreqToNums(int maxFreq, int output) {
            freqToNums.get(maxFreq).remove(output);
            if(freqToNums.get(maxFreq).size() == 0){
                freqToNums.remove(maxFreq);
            }
        }
    }
}
