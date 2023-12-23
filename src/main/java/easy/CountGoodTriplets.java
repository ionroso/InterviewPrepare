package easy;

import java.util.Stack;

public class CountGoodTriplets {
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7}, 7,2,3));
    }
    static public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        if(n<3) {
            return -1;
        }

        int i=0, j=1, k=2;
        int count=0;
        while (i<n-2){
            if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                count++;
            }

            if(k<n-1){
                k++;
            } else if (j<n-2){
                j++;
                k = j + 1;
            } else {
                i++;
                j = i+1;
                k = j+1;
            }
        }

        return count;
    }
}
