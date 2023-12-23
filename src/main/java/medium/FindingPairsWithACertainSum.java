package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FindingPairsWithACertainSum {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[] {1, 4, 5, 2, 5, 4});
            System.out.println(findSumPairs.count(7));  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
            findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
            System.out.println(findSumPairs.count(8));  // return 2; pairs (5,2), (5,4) make 3 + 5
            System.out.println(findSumPairs.count(4));  // return 1; pair (5,0) makes 3 + 1
            findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
            findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
            System.out.println(findSumPairs.count(7));  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4

            
        }

        class FindSumPairs {
            int[] nums2;
            TreeMap<Integer, Integer> nums1OrderedCounts;
            Map<Integer, Integer> nums2OrderedCounts;

            public FindSumPairs(int[] nums1, int[] nums2) {
                this.nums2 = nums2;

                this.nums1OrderedCounts = new TreeMap<>();
                this.nums2OrderedCounts = new HashMap<>();

                for (int num : nums1) {
                   int n = nums1OrderedCounts.getOrDefault(num, 0);
                    nums1OrderedCounts.put(num, n+1);
                }

                for (int num : nums2) {
                   int n = nums2OrderedCounts.getOrDefault(num, 0);
                   nums2OrderedCounts.put(num, n+1);
                }

            }

            public void add(int index, int val) {
                int currArrayValAtIndex = nums2[index];
                int newArrayValAtIndex = nums2[index] + val;

                int currMapValAtIndex = nums2OrderedCounts.remove(currArrayValAtIndex);
                if(--currMapValAtIndex>0) {
                    nums2OrderedCounts.put(currArrayValAtIndex, currMapValAtIndex);
                }


                nums2[index]=newArrayValAtIndex;
                int newMapValAtIndex = nums2OrderedCounts.getOrDefault(newArrayValAtIndex, 0);
                nums2OrderedCounts.put(newArrayValAtIndex, ++newMapValAtIndex);
            }

            public int count(int tot) {
                AtomicInteger count = new AtomicInteger();
                SortedMap<Integer, Integer> sortedMap = nums1OrderedCounts.headMap(tot);
                if(sortedMap.isEmpty()){
                   return count.get();
                }


                sortedMap.entrySet().stream()
                        .forEach(e->{
                            int remainer = tot-e.getKey();
                            if(nums2OrderedCounts.containsKey(remainer)){
                                count.addAndGet(e.getValue() * nums2OrderedCounts.get(remainer));
                            }
                        });

                return count.get();
            }
        }
    }
}
