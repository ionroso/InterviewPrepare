package medium;

import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.Iterator;
import java.util.TreeMap;

public class MyCalendarI {
    public static void main(String[] args) {
        new Test1().test();
    }

    private static class Test1 {
        public void test(){
            MyCalendar myCalendar = new MyCalendar();
            myCalendar.book(10, 30);
            myCalendar.book(31, 40);
            myCalendar.book(55, 75);

            myCalendar.book(35, 50);
        }

        class MyCalendar {
            TreeMap<Integer, Integer> calendar;

            MyCalendar() {
                calendar = new TreeMap();
            }

            public boolean book(int start, int end) {
                Integer prevStart = calendar.floorKey(start),
                        nextStart = calendar.ceilingKey(start);

                if ((prevStart == null || calendar.get(prevStart) <= start) && (nextStart == null || end <= nextStart)) {
                    calendar.put(start, end);
                    return true;
                }

                return false;
            }
        }
    }

    private static class Test2 {
        public void test(){
            IParser p = new LeetcodeMethodsCallStackInputParser(",");
            IParser p1 = new LeetcodeArgsParser();
            LeetcodeInputIterator method = new LeetcodeInputIterator(p,"[\"MyCalendar\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\",\"book\"]");
            LeetcodeInputIterator input = new LeetcodeInputIterator(p1,"[[],[97,100],[33,51],[89,100],[83,100],[75,92],[76,95],[19,30],[53,63],[8,23],[18,37],[87,100],[83,100],[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15]]");

            MyCalendar myCalendar = new MyCalendar();

            Iterator<String> methodIterator = method;
            Iterator<String> inputIterator = input;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;

                String methodName = methodIterator.next();
                String val = inputIterator.next();


                switch (methodName) {
                    case "MyCalendar": {
                        System.out.println(y + " constr");
                        break;
                    }
                    case "book": {
                        String[] split = val.split(",");
                        System.out.print(y + " " + val + " ");
                        int val1 = Integer.valueOf(split[0]);
                        int val2 = Integer.valueOf(split[1]);
                        System.out.println(myCalendar.book(val1, val2));
                        break;
                    }

                }
            }

        }

        class MyCalendar {
            class IntervalTree {
                class Interval {
                    int low, high;

                    public Interval(int low, int high) {
                        this.low = low;
                        this.high = high;
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

                public boolean isOverlapping(int start, int end) {
                    Interval i = isOverlapping(root, new Interval(start, end));
                    return !(i.low == -1 && i.high == -1);
                }
                public Interval isOverlapping(INode root, Interval range)
                {
                    if (root == null) {
                        // return a dummy interval range
                        return new Interval(-1, -1);
                    }

                    // if x overlaps with root's interval
                    if ((range.low >= root.range.low && range.low < root.range.high)
                            || (range.high > root.range.low && range.high <= root.range.high)) {
                        return root.range;
                    } else if (root.left != null
                            && root.left.max > range.low) {
                        // the overlapping node may be present in left
                        // child
                        return isOverlapping(root.left, range);
                    }
                    else {
                        return isOverlapping(root.right, range);
                    }
                }
            }

            IntervalTree root;
            public MyCalendar() {
                root = new IntervalTree();
            }

            public boolean book(int start, int end) {
                if(root.isOverlapping(start, end))
                {
                    return false;
                }

                root.insert(start, end);
                return true;
            }
        }
    }
}
