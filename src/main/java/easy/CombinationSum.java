package easy;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            List<List<Integer>> rez = new Solution().combinationSum(new int[]{1,2}, 3);
            System.out.println();
        }

        class Item {
            int index;
            int value;
            int count;

            public Item(int index, int value, int count) {
                this.index = index;
                this.value = value;
                this.count = count;
            }
        }

        class StackItem {
            int level;
            int sum;
            int[] array;
            StackItem(int l, int s, int[] a){
                level = l;
                sum = s;
                array = a;
            }
        }

        class Solution {
            Solution() {}

            public List<List<Integer>> combinationSum(int[] candidates, int target) {

                List<List<Integer>> output = new ArrayList<>();

                List<StackItem> rez = combinationSumRec(candidates, target);

                Set<String> set = new HashSet<>();
                for (StackItem stackItem : rez) {
                    if(stackItem.sum == target){
                        List<Integer> sol = new ArrayList<>();
                        for (int i = 0; i < stackItem.array.length; i++) {
                            for (int j = 0; j < stackItem.array[i]; j++) {
                                sol.add(candidates[i]);
                            }
                        }
                        output.add(sol);
                    }
                }

                return output;
            }
            
            public List<StackItem>  combinationSumRec(int[] candidates, int target) {
                List<StackItem> levels = new ArrayList<>();
                Queue<StackItem> stack = new LinkedList<>();
                int[] count = new int[candidates.length];

                StackItem si = new StackItem(0, 0, count);
                stack.offer(si);
                levels.add(si);
                while (!stack.isEmpty()){
                     StackItem pop = stack.poll();
                      for (int i = 0; i < candidates.length; i++) {
                          if(pop.sum + candidates[i] > target){
                              continue;
                          }

                         int[] copiedArray = Arrays.copyOf(pop.array, pop.array.length);
                         copiedArray[i]++;
                         StackItem temp = new StackItem(pop.level+1,pop.sum+candidates[i], copiedArray);
                         stack.offer(temp);
                         levels.add(temp);
                     }
                 }

                return levels;
            }
            
            
//            public List<List<Integer>> combinationSum(int[] candidates, int target) {
//                int n = candidates.length;
//
//                List<List<Integer>> output = new ArrayList<>();
//
//                int ptr = 0;
//                int sum = 0;
//
//                Stack<Item> stack = new Stack<>();
//
//                while (true){
//                    stack.add(new Item(ptr, candidates[ptr],1));
//                    sum+=candidates[ptr];
//
//                    if(sum == target){
//                        output.add(stack.stream().map(e->e.value).collect(Collectors.toList()));
//                        Item pop = stack.pop();
//                        sum-=pop.value* pop.count;
//                        ptr--;
//                    } else if(ptr == n-1){
//                        Item peek = stack.peek();
//                        peek.count++;
//                        sum+= peek.value;
//                    } else if(sum>target){
//                        Item pop = stack.pop();
//                        sum-=pop.value* pop.count;
//
//                        if(!stack.isEmpty()){
//                            Item peek = stack.peek();
//                            peek.count++;
//                            sum+= peek.value;
//                        }
//                    }
//
//                    ptr++;
//                }
//
//                return output;
//            }
        }
    }

}
