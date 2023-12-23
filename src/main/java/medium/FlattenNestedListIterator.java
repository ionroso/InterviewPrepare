package medium;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FlattenNestedListIterator {
    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    public class NestedIterator implements Iterator<Integer> {
        Queue<Integer> numbers = new LinkedList<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            processTree(nestedList);
        }

        private void processTree(List<NestedInteger> nestedList) {
            for (NestedInteger ni : nestedList) {
                if(ni.isInteger()){
                    numbers.offer(ni.getInteger());
                    continue;
                }

                processTree(ni.getList());
            }
        }

        @Override
        public Integer next() {
            if(hasNext()) {
                return numbers.poll();
            }

            return null;
        }

        @Override
        public boolean hasNext() {
            return !numbers.isEmpty();
        }
    }
}
