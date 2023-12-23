package medium;

import java.util.*;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        class Node {
            public char c;
            public int count;

            Node(char c, int count){
                this.c = c;
                this.count = count;
            }
        }
        public void test() {
           TreeSet<Node> treeSet = new TreeSet<>((n1,n2)-> n1.count - n2.count);
           Node n_a = new Node('a', 1);
           Node n_b = new Node('b', 1);
           treeSet.add(n_a);
           treeSet.add(n_b);



//            System.out.println(new Solution().numKLenSubstrNoRepeats("slidingwindow", 5));
            System.out.println(new Solution().numKLenSubstrNoRepeats("havefunonleetcode", 5));
//            System.out.println(new Solution().numKLenSubstrNoRepeats("aaaaa", 2));
        }

        class Solution {
            Solution() {}

            public int numKLenSubstrNoRepeats(String s, int k) {
                int n = s.length();
                int count = 0;
                Set<Character> set = new HashSet<>();

                int l=0, r=0;
                while (r<n){

                    if(!set.contains(s.charAt(r))){
                        set.add(s.charAt(r));
                    } else {
                        while (s.charAt(l) != s.charAt(r)){
                            set.remove(s.charAt(l));
                            l++;
                        }
                        l++;
                    }

                    if(r-l+1 == k){
                        count++;
                        set.remove(s.charAt(l));
                        l++;
                    }

                    r++;
                }

                return count;
            }

            public int numKLenSubstrNoRepeats1(String s, int k) {
                int n = s.length();
                Map<Character, Integer> map = new HashMap<>();

                int count = 0;
                for (int i = 0; i < n; i++) {
                    char currChar = s.charAt(i);
                    if(i>=k){
                        char kthBackChar = s.charAt(i-k);
                        int kthBackCharCount = map.get(kthBackChar);
                        if(kthBackCharCount==1){
                            map.remove(kthBackChar);
                        } else {
                            map.put(kthBackChar, kthBackCharCount-1);
                        }
                    }

                    int freq = map.getOrDefault(currChar, 0);
                    map.put(currChar, freq+1);

                    if(map.size()==k){
                        count++;
                    }
                }

                return count;
            }
        }

    }
}
