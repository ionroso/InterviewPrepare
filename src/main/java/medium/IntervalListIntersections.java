package medium;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {


            int[][] i1 = new int[][] {{0,2}, {5,10}, {13,23}, {24,25} };
            int[][] i2 = new int[][] {{1,5}, {8,12}, {15,24}, {25,26} };

            System.out.println(new Solution().intervalIntersection(i1, i2));
        }

        class Solution {
            public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
                int firstLen = firstList.length;
                int secondLen = secondList.length;

                List<int[]> output = new ArrayList<>();

                int p1 = 0, p2 = 0;
                while (p1 < firstLen && p2 < secondLen){
                    int start1 = firstList[p1][0];
                    int end1 = firstList[p1][1];

                    int start2 = secondList[p2][0];
                    int end2 = secondList[p2][1];

                    if(isIntersecting(start1, end1, start2, end2)){
                        output.add(new int[]{Math.max(start1, start2), Math.min(end1, end2)});

                        if(p1+1<firstLen && !isIntersecting(start2, end2, firstList[p1+1][0], firstList[p1+1][1])) {
                            p1++;
                        }

                        if(p2+1<secondLen && !isIntersecting(start1, end1, secondList[p2+1][0], secondList[p2+1][1])) {
                            p2++;
                        }

                    } else if(isBigger(start1, end1, start2, end2)) {
                        output.add(new int[]{start2, end2});
                        p2++;
                    } else {
                        output.add(new int[]{start1, end1});
                        p1++;
                    }
                }

                int[][] out = new int[output.size()][2];
                int i = 0;
                for (int[] ints : output) {
                    out[i] = new int[]{ints[0], ints[1]};
                    i++;
                }

                return out;
            }

            private boolean isIntersecting(int start1, int end1, int start2, int end2) {
                return pointBetween(start1, start2, end2) || pointBetween(start2, start1, end1);
            }

            private boolean isBigger(int start_i1, int end_i1, int start_i2, int end_i2) {
                return (end_i1 < start_i2) || (end_i2 < start_i1);
            }
            private boolean pointBetween(int point, int start, int end) {
                return (point >= start && point < end);
            }
        }
    }

}
