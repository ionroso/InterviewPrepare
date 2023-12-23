package failed;

import java.util.*;

public class Snap {
    // total numbers n(from 0 to n-1), max consic seq length, and turn on array
    // given a number n(from 0 to n-1)
    // given a number maxConsLength
    // given array of numbers to turn on numbers [1,6,2,3]

    // wrong data struct picked


    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
//
//            NavigableSet<Integer> set = new TreeSet<>();
//            set.add(3);
//            set.add(7);
//            set.add(2);
//            set.add(1);
//            set.add(4);
//            set.add(8);
//            set.add(5);
//            set.add(9);
//
//            NavigableSet<Integer> headSet = set.headSet(5, false);
//            for (Integer i : headSet) {
//                System.out.print(i + " ");
//            }
//
//            System.out.println();
//            System.out.println();
//
//
//            Iterator<Integer> it = headSet.descendingIterator();
//            while (it.hasNext()) {
//                System.out.print(it.next() + " ");
//            }
//
//            System.out.println();
//            System.out.println();
//
//            SortedSet<Integer> tailSet = set.tailSet(5, false);
//            for (Integer i : tailSet) {
//                System.out.print(i + " ");
//            }
//
//            System.out.println();
//            System.out.println("higher: " + set.higher(5));
//            System.out.println("ceiling: " + set.lower(5));
//            System.out.println();
//
//            TreeMap<Integer, Integer> map = new TreeMap<>();
//            map.put(3, 0);
//            map.put(7, 0);
//            map.put(2, 0);
//            map.put(1, 0);
//            map.put(4, 0);
//            map.put(8, 0);
//            map.put(5, 0);
//            map.put(9, 0);
//
//            System.out.println();
//
//            NavigableMap<Integer, Integer> headMap = map.headMap(5, false);
//            for (Map.Entry<Integer, Integer> e : headMap.entrySet()) {
//                System.out.print(e.getKey() + " ");
//            }
//
//            System.out.println();
//
//            NavigableMap<Integer, Integer> tailMap = map.tailMap(5, false);
//            for (Map.Entry<Integer, Integer> e : tailMap.entrySet()) {
//                System.out.print(e.getKey() + " ");
//            }
//
//            System.out.println();
//            System.out.println("higher: " + map.higherKey(5));
//            System.out.println("ceiling: " + map.ceilingKey(5));
//            System.out.println();



            String testName = null;
            int n = 10;

//
//            NavigableSet<Integer> set = new TreeSet<>();
//            set.add(3);
//            set.add(7);
//            set.add(2);
//            set.add(1);
//            set.add(4);
//            set.add(8);
//            set.add(5);
//            set.add(9);
//            Solution tt = new Solution(n, 6, set);
//            tt.getLenIncludeMe(6);

            try {
                testName = "test1";
                Solution test1 = new Solution(n,  1);
                test(test1.numOperations(new int[]{0}) == 1);

                testName = "test2";
                Solution test2 = new Solution(n, 2);
                test(test2.numOperations(new int[]{0, 1}) == 2);

                testName = "test4";
                Solution test4 = new Solution(n, 2);
                test(test4.numOperations(new int[]{0, 2, 1}) == 3);
            } catch (Exception e) {
                System.out.println("Failed test:" + testName);
                return;
            }

            System.out.println("All good!");
        }

        void test(boolean expected) throws Exception {
            if (!expected) {
                throw new Exception(String.format("test failed"));
            }
        }

        public static void main(String[] args) {
            new Test().test();
        }

        class Solution {

            private final int n;
            private final int maxLen;
            private final NavigableSet<Integer> set;
            private int count = 0;

            Solution(int n, int maxLen) {
                this.n = n;
                this.maxLen = maxLen;
                set = new TreeSet<>();
            }

            Solution(int n, int maxLen, NavigableSet<Integer> set) {
                this.n = n;
                this.maxLen = maxLen;
                this.set = set;
            }

            int numOperations(int[] seq) {
                for (int num : seq) {
                    if (num > n - 1) {
                        throw new IllegalArgumentException("");
                    }

                    set.add(num);
                    count++;

                    if (getLenIncludeMe(num) >= maxLen) {
                        return count;
                    }
                }

                return 0;
            }

            private int getLenIncludeMe(int num) {
                int len = 1;

                Integer curr = num;
                while (curr != null){

                    Integer temp = set.higher(curr);
                    int delta = (temp != null ? temp : curr) - curr;
                    if(delta!=1) {
                        break;
                    }

                    curr  = temp;
                    len++;
                    if(len == maxLen){
                        return len;
                    }
                }

                curr = num;
                while (curr != null){
                    Integer temp = set.lower(curr);
                    int delta = curr - (temp != null ? temp : curr) ;
                    if(delta!=1) {
                        break;
                    }

                    curr  = temp;
                    len++;
                    if(len == maxLen){
                        return len;
                    }
                }

                return len;

//                int len = 1;
//
//                Integer lower = num, higher = num;
//                boolean lowerStop = false, higherStop = false;
//                while (lower != null || higher != null){
//                    if(!lowerStop && lower!=null && lower - set.lower(lower) == 1){
//                        len++;
//                        lower = set.lower(lower);
//                    } else {
//                      lowerStop = true;
//                    }
//
//                    if(!higherStop && higher!=null && higher - set.higher(lower) == 1){
//                        len++;
//                        higher = set.higher(higher);
//                    } else {
//                        higherStop = true;
//                    }
//                }
//
//                return len;
            }
        }


        class Solution3 {

            private final int n;
            private final int maxLen;
            private final NavigableSet<Integer> set;
            private int count = 0;

            Solution3(int n, int maxLen) {
                this.n = n;
                this.maxLen = maxLen;
                set = new TreeSet<>();
            }

            int numOperations(int[] seq) {
                for (int num : seq) {
                    if (num > n - 1) {
                        throw new IllegalArgumentException("");
                    }

                    set.add(num);
                    count++;

                    if (getLenIncludeMe(num) >= maxLen) {
                        return count;
                    }
                }

                return 0;
            }

            private int getLenIncludeMe(int num) {
                NavigableSet<Integer> tailSet = set.tailSet(num, false);
                Iterator<Integer> itrRight = tailSet.iterator();

                NavigableSet<Integer> headSet = set.headSet(num, false);
                Iterator<Integer> itrLeft = headSet.descendingIterator();

                int len = 1;
                int prevLeft = num, prevRight = num;
                boolean rightNotContinue = false, leftNotContinue = false;
                while (itrRight.hasNext() || itrLeft.hasNext()){

                    if(!rightNotContinue && itrRight.hasNext()){
                         int curRight = itrRight.next();
                         if(curRight - prevRight == 1){
                             len++;
                             prevRight = curRight;
                        } else {
                             rightNotContinue = true;
                        }
                    }

                    if(!leftNotContinue && itrLeft.hasNext()){
                        int curLeft = itrLeft.next();
                        if(prevLeft - curLeft == 1){
                            len++;
                            prevLeft = curLeft;
                        } else {
                            leftNotContinue = true;
                        }
                    }
                }

                return len;
            }

            private int getLenRight(int num) {
                NavigableSet<Integer> tailSet = set.tailSet(num, false);

                if(tailSet.size() == 0) {
                    return 0;
                }

                // 1, 2, 3
                //    p  c
                int len = 1;
                Iterator<Integer> itr = tailSet.iterator();
                Integer prev = itr.next();
                while (itr.hasNext()){
                    Integer curr = itr.next();
                    if(curr - prev != 1){
                        break;
                    }

                    len++;
                    prev = curr;
                }

                return len;
            }

            private int getLenLeft(int num) {
                NavigableSet<Integer> headSet = set.headSet(num, true);

                if(headSet.size() == 0) {
                    return 0;
                }

                // 1, 2, 3
                //    p  c
                int len = 1;
                Iterator<Integer> itr = headSet.descendingIterator();
                Integer prev = itr.next();
                while (itr.hasNext()){
                    Integer curr = itr.next();
                    if(prev - curr != 1){
                       break;
                    }

                    len++;
                    prev = curr;
                }

                return len;
            }
        }

            class Solution2 {
                private final int n;
                private final int maxLength;
                private boolean[] turnOn;
                private int count;

                Solution2(int n, int maxLength) {
                    this.n = n;
                    this.maxLength = maxLength;
                    this.turnOn = new boolean[n];
                }

                int numOperations(int[] seq) {
                    for (int num : seq) {
                        if (num > n - 1) {
                            throw new IllegalArgumentException("");
                        }

                        turnOn[num] = true;
                        count++;

                        if (getLenIncludeMe(num) >= maxLength) {
                            return count;
                        }
                    }

                    return -1;
                }

                private int getLenIncludeMe(int num) {
                    int lenLeft = 0, lenRight = 0;
                    boolean stoppedLeft = false, stoppedRight = false;

                    boolean movedFwd = false;
                    while ((num - 1 - lenLeft >= 0 || num + 1 + lenRight <= n - 1) && (lenLeft + lenRight + 1 < maxLength)) {
                        if (!stoppedLeft && (num - 1 - lenLeft >= 0 && turnOn[num - 1 - lenLeft])) {
                            lenLeft++;
                            movedFwd = true;
                        } else {
                            stoppedLeft = true;
                        }

                        if (!stoppedRight && (num + 1 + lenRight >= 0 && turnOn[num + 1 + lenRight])) {
                            lenRight++;
                            movedFwd = true;
                        } else {
                            stoppedRight = true;
                        }

                        if (!movedFwd) {
                            break;
                        }

                        movedFwd = false;
                    }

                    return lenLeft + lenRight + 1;
                }

                private int getLenLeft(int num) {
                    int len = 0;
                    while (num - len - 1 >= 0 && turnOn[num - len - 1]) {
                        len++;
                    }

                    return len;
                }

                private int getLenRight(int num) {
                    int len = 0;
                    while (num + len + 1 < n && turnOn[num + len + 1]) {
                        len++;
                    }

                    return len;
                }
            }

            class Solution1 {
                private final int n;
                private final int maxLength;
                private boolean[] turnOn;
                private int count;

                Solution1(int n, int maxLength) {
                    this.n = n;
                    this.maxLength = maxLength;
                    this.turnOn = new boolean[n];
                }

                int numOperations(int[] seq) {
                    for (int num : seq) {
                        if (num > n - 1) {
                            throw new IllegalArgumentException("");
                        }

                        turnOn[num] = true;
                        count++;

                        if (getLenLeft(num) + getLenRight(num) + 1 >= maxLength) {
                            return count;
                        }
                    }

                    return -1;
                }

                private int getLenLeft(int num) {
                    int len = 0;
                    while (num - len - 1 >= 0 && turnOn[num - len - 1]) {
                        len++;
                    }

                    return len;
                }

                private int getLenRight(int num) {
                    int len = 0;
                    while (num + len + 1 < n && turnOn[num + len + 1]) {
                        len++;
                    }

                    return len;
                }
            }
    }
}


