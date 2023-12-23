package failed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Datadog {
    // latencies in buckets
    // given number_of_buckets, bucket_width, stream of numbers
    //


    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            List<List> rez = new Solution().distribute(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17}, 5, 3);
            System.out.println();
        }

        class Solution {
            List<List> distribute(int[] arr, int n, int s){
                List<List> output = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    output.add(new ArrayList());
                }

                for (int num : arr) {
                    int bucket = num/s;
                    if(bucket >= n){
                        bucket%=n;
                    }
                    output.get(bucket).add(num);
                }
                return output;
            }
        }
    }
}
