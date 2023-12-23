package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedListWeightSum {

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // Set this NestedInteger to hold a single integer.
     public void setInteger(int value);

     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     public void add(NestedInteger ni);

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}
    public int depthSum(List<NestedInteger> nestedList) {
        Map<Integer, Integer> levelSum = new HashMap<>();
        for (NestedInteger nestedInteger : nestedList) {
            addUpSumEachLevel(levelSum, nestedInteger, 0);
        }

        int output = 0;
        for (Map.Entry<Integer, Integer> entry : levelSum.entrySet()) {
            output+=entry.getKey()*entry.getValue();
        }

        return output;
    }

    private void addUpSumEachLevel(Map<Integer, Integer> levelSum, NestedInteger nestedInteger, int l) {
            if(nestedInteger.isInteger()){
               int sum = levelSum.getOrDefault(l, 0);
               levelSum.put(l, sum + nestedInteger.getInteger());
               return;
            }

            for (NestedInteger ni : nestedInteger.getList()) {
                addUpSumEachLevel(levelSum, ni, l+1);
            }
    }
}
