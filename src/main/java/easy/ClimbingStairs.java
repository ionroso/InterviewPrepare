package easy;

import java.util.Stack;


public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairsItr(4));
    }

    public static int climbStairsItr(int n) {
        if(n==1) return 1;

        int countTwos =  n/2;
        int countOnes = n - 2*countTwos;

        int i = n-1;
        int countPerm = 1;
        if(countOnes==1){
            while (i>=countOnes + countTwos){
                countPerm+=fact(i--);
            }
        } else {
            while (i>countTwos){
                countPerm+=fact(i--);
            }
            countPerm++;
        }
        return countPerm;
    }

    static int fact(int number) {
        int f = 1;
        int j = 1;
        while(j <= number) {
            f = f * j;
            j++;
        }
        return f;
    }

    static  int count = 0;
    public static int climbStairs(int n) {
        climbStairsRec(n);

        return count;
    }

    public static void climbStairsRec(int n) {
        if(n<0) return;
        if(n==0){
            count++;
            return;
        }
        climbStairsRec(n-1);
        climbStairsRec(n-2);
    }


}
