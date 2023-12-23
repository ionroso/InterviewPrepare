package hard;

import medium.MyCalendarI;
import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.*;

public class MyCalendarIII {
    public static void main(String[] args) {




        MyCalendarThree myCalendarThree = new MyCalendarThree();
        LeetcodeInputIterator method = new LeetcodeInputIterator(new LeetcodeMethodsCallStackInputParser(","),"[\"MyCalendarThree\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\"]");
        LeetcodeInputIterator input = new LeetcodeInputIterator(new LeetcodeArgsParser(),"[[],[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33],[23,28]]");


        Iterator<String> methodIterator = method;
        Iterator<String> inputIterator = input;
        int y = -1;
        while (methodIterator.hasNext()) {
            y++;

            String methodName = methodIterator.next();
            String val = inputIterator.next();

            switch (methodName) {
                case "MyCalendar": {
                    break;
                }
                case "book": {
                    String[] split = val.split(",");
                    int val1 = Integer.valueOf(split[0]);
                    int val2 = Integer.valueOf(split[1]);
                    myCalendarThree.book(val1, val2);
                    break;
                }

            }
        }




        myCalendarThree.book(10, 20); // return 1
        myCalendarThree.book(5, 10); // return 3
    }


    static
    class MyCalendarThree {
        class IntervalTree {
            static class Interval {
                int low, high;

                public Interval(int low, int high) {
                    this.low = low;
                    this.high = high;
                }

                @Override
                public String toString() {
                    return "Interval{" +
                            "low=" + low +
                            ", high=" + high +
                            '}';
                }
            }

            class INode {
                Interval range;
                int max;

                INode left, right;
                public INode(Interval range, int max) {
                    this.range = range;
                    this.max = max;
                }


            }

            INode root;

            public void insert(int start, int end){
                root = insert(root, new Interval(start, end));
            }

            public INode insert(INode root, Interval range){
                if(root == null) {
                    return new INode(range, range.high);
                }

                if(range.low < root.range.low) {
                    root.left = insert(root.left, range);
                } else {
                    root.right = insert(root.right, range);
                }

                if (root.max < range.high) {
                    root.max = range.high;
                }

                return root;
            }

            public static void inOrder(INode root)
            {
                if (root == null) {
                    return;
                }
                inOrder(root.left);
                System.out.print(root);
                inOrder(root.right);
            }

            public int isOverlapping(int start, int end) {
                List<Interval> overlaps = new ArrayList<>();

                return isOverlapping(root, new Interval(start, end), overlaps);
            }
            public int isOverlapping(INode root, Interval range, List<Interval> overlaps)
            {
                if (root == null) {
                    return 1;
                }

                long count = 0;

                Interval intersection = getIntersection(root.range, range);
                if(intersection != null){
                    System.out.println();
                    System.out.println("range:" + range + " : " + root.range);
                    count = 2 + overlaps.stream()
                            .filter(r -> doIntersect(intersection, r))
                            .count();


                    overlaps.add(intersection);
                }

                return Math.max((int)count, Math.max(isOverlapping(root.left, range, overlaps), isOverlapping(root.right, range, overlaps)));
            }


            private boolean doIntersect(Interval range1, Interval range2) {
                return getIntersection(range1, range2) != null;
            }

            private Interval getIntersection(Interval range1, Interval range2) {
                if(range1.high <= range2.low || range2.high <= range1.low) {
                    return null;
                }

                return new Interval(Math.max(range1.low, range2.low), Math.min(range1.high, range2.high));
            }
        }

        IntervalTree it;
        int max = -1;

        public MyCalendarThree() {

            Map<IntervalTree.Interval, Integer> map = new HashMap();
            IntervalTree.Interval i1 = new IntervalTree.Interval(0, 1);
            map.put(i1, 1);
            boolean i1IsThere = map.containsKey(i1);

            IntervalTree.Interval i2 = new IntervalTree.Interval(0, 1);
            boolean i2IsThere = map.containsKey(i2);


            it = new IntervalTree();
        }


        public int book(int start, int end) {
            max = Math.max(max, it.isOverlapping(start, end));

            it.insert(start, end);

            return max;
        }
    }
}
