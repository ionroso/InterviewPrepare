package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class MyCalendarII {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test(){
            MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
            myCalendarTwo.book(10, 20); // return True, The event can be booked.
            myCalendarTwo.book(50, 60); // return True, The event can be booked.
            myCalendarTwo.book(10, 40); // return True, The event can be double booked.
            myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
            myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
            myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double
        }
        class MyCalendarTwo {
            TreeMap<Integer, Integer> calendar;

            public MyCalendarTwo() {
                calendar = new TreeMap<>();
            }

            public boolean book(int start, int end) {
                increase(start);
                decrease(end);

                int ongoing = 0;
                for (int v: calendar.values()) {
                    ongoing += v;
                    if (ongoing >= 3) {
                            decrease(start);
                            increase(end);

                        // --- optional to remove the tentative key --->
                        if (calendar.get(start) == 0) {
                            calendar.remove(start);
                        }
                        if (calendar.get(end) == 0) {
                            calendar.remove(end);
                        }
                        // <--- optional to remove the tentative key ---

                        return false;
                    }
                }
                return true;
            }

            private void decrease(int end) {
                calendar.put(end, calendar.getOrDefault(end, 0) - 1);
            }

            private void increase(int start) {
                calendar.put(start, calendar.getOrDefault(start, 0) + 1);
            }
        }
    }

    private static class Test2 {
        public void test() {
            MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
            myCalendarTwo.book(10, 20); // return True, The event can be booked.
            myCalendarTwo.book(50, 60); // return True, The event can be booked.
            myCalendarTwo.book(10, 40); // return True, The event can be double booked.
            myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
            myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
            myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double
        }

        class MyCalendarTwo {
            static class IntervalTree {
                static class Interval {
                    int low, high;

                    public Interval(int low, int high) {
                        this.low = low;
                        this.high = high;
                    }
                }

                static class INode {
                    Interval range;
                    int max;

                    INode left, right;

                    public INode(Interval range, int max) {
                        this.range = range;
                        this.max = max;
                    }
                }

                INode root;

                public void insert(int start, int end) {
                    root = insert(root, new Interval(start, end));
                }

                public INode insert(INode root, Interval range) {
                    if (root == null) {
                        return new INode(range, range.high);
                    }

                    if (range.low < root.range.low) {
                        root.left = insert(root.left, range);
                    } else {
                        root.right = insert(root.right, range);
                    }

                    if (root.max < range.high) {
                        root.max = range.high;
                    }

                    return root;
                }

                public static void inOrder(INode root) {
                    if (root == null) {
                        return;
                    }
                    inOrder(root.left);
                    System.out.print(root);
                    inOrder(root.right);
                }

                public void isOverlapping1(INode root, Interval queryRange, List<Interval> overlaps) {
                    if (root == null) {
                        // return a dummy interval range
                        return;
                    }

                    Interval intersection = getIntersection(root.range, queryRange);
                    if (intersection != null) {
                        Optional<Interval> found = overlaps.stream()
                                .filter(r -> doIntersect(intersection, r))
                                .findFirst();
//
//                    if(found.isPresent()) {
//                        return true;
//                    }

                        overlaps.add(intersection);
                    }

                    if (root.left != null && queryRange.low < root.left.max) {
                        // the overlapping node may be present in left
                        // child
                        isOverlapping1(root.left, queryRange, overlaps);
                    }

                    isOverlapping1(root.right, queryRange, overlaps);
                }

                public boolean isOverlapping(int start, int end) {
                    List<Interval> overlaps = new ArrayList<>();

                    return isOverlapping(root, new Interval(start, end), overlaps);
                }

                public boolean isOverlapping(INode root, Interval range, List<Interval> overlaps) {
                    if (root == null) {
                        // return a dummy interval range
                        return false;
                    }

                    Interval intersection = getIntersection(root.range, range);
                    if (intersection != null) {
                        Optional<Interval> found = overlaps.stream()
                                .filter(r -> doIntersect(intersection, r))
                                .findFirst();

                        if (found.isPresent()) {
                            return true;
                        }

                        overlaps.add(intersection);
                    }

                    return isOverlapping(root.left, range, overlaps) || isOverlapping(root.right, range, overlaps);
                }


                private boolean doIntersect(Interval range1, Interval range2) {
                    return getIntersection(range1, range2) != null;
                }

                private Interval getIntersection(Interval range1, Interval range2) {
                    if (range1.high < range2.low || range2.high < range1.low) {
                        return null;
                    }

                    return new Interval(Math.max(range1.low, range2.low), Math.min(range1.high, range2.high));
                }
            }

            IntervalTree it;

            public MyCalendarTwo() {
                it = new IntervalTree();
            }

            public boolean book(int start, int end) {
                if (it.isOverlapping(start, end)) {
                    return false;
                }

                it.insert(start, end);

                return true;
            }
        }
    }
}
