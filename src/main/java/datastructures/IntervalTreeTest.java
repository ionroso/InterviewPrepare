package org.datastructures;

import java.io.*;

public class IntervalTreeTest {
    /*package whatever //do not write package name here */

    public static void main(String[] args)
    {
        GFG.Node root = GFG.insert(null, new GFG.Interval(15, 20));
        root = GFG.insert(root, new GFG.Interval(10, 30));
        root = GFG.insert(root, new GFG.Interval(17, 19));
        root = GFG.insert(root, new GFG.Interval(5, 20));
        root = GFG.insert(root, new GFG.Interval(12, 15));
        root = GFG.insert(root, new GFG.Interval(30, 40));

        System.out.println(
                "Inorder traversal of constructed Interval Tree is");
        GFG.inOrder(root);
        System.out.println("Overlaps with " + GFG.isOverlappingItr(root, new GFG.Interval(13, 15)));
    }

    static
    class GFG {
        static class Interval {
            int low, high;

            public Interval(int low, int high)
            {
                this.low = low;
                this.high = high;
            }

            public String toString()
            {
                return "[" + this.low + "," + this.high + "]";
            }
        }

        static class Node {
            Interval range;
            Node left, right;
            int max;

            public Node(Interval range, int max)
            {
                this.range = range;
                this.max = max;
            }

            public String toString()
            {
                return "[" + this.range.low + ", "
                        + this.range.high + "] "
                        + "max = " + this.max + "\n";
            }
        }

        public static Node insert(Node root, Interval x)
        {
            if (root == null) {
                return new Node(x, x.high);
            }
            if (x.low < root.range.low) {
                root.left = insert(root.left, x);
            }
            else {
                root.right = insert(root.right, x);
            }
            if (root.max < x.high) {
                root.max = x.high;
            }
            return root;
        }

        public static void inOrder(Node root)
        {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root);
            inOrder(root.right);
        }

        public static Interval isOverlappingItr(Node root, Interval x)
        {
            Node ptr = root;

            while (ptr != null){
                if ((x.low > ptr.range.low && x.low < ptr.range.high)
                        || (x.high > ptr.range.low && x.high < ptr.range.high)) {
                    return ptr.range;
                }

                if (ptr.left != null && ptr.left.max > x.low) {
                    ptr = ptr.left;
                } else {
                    ptr = ptr.left;
                }
            }

            return new Interval(-1, -1);
        }

        public static Interval isOverlapping(Node root,
                                             Interval x)
        {
            if (root == null) {
                // return a dummy interval range
                return new Interval(-1, -1);
            }
            // if x overlaps with root's interval
            if ((x.low > root.range.low
                    && x.low < root.range.high)
                    || (x.high > root.range.low
                    && x.high < root.range.high)) {
                return root.range;
            }
            else if (root.left != null
                    && root.left.max > x.low) {
                // the overlapping node may be present in left
                // child
                return isOverlapping(root.left, x);
            }
            else {
                return isOverlapping(root.right, x);
            }
        }
        // contributed by rishabhtiwari759
    }

}
