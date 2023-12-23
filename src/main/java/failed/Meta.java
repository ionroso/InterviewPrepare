package failed;

public class Meta {
    // find k-th missing number
    // given: for instance: 2,4,6,9 find 3th missing number => 8

    // 1,2,3,4

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().findKthMissingNumber(new int[]{1,8,16}, 8));
        }

        class Solution {
            int findKthMissingNumber(int[] arr, int k){
                int l=0, r = arr.length-1;

                while (l<r-1){
                    int mid = l + (r-l)/2;
                    int currMid = arr[mid];
                    int currLeft = arr[l];
                    int offSet=mid-l;
                    int shouldBe = currMid-offSet;
                    int missingLeft = shouldBe - currLeft;
                    if(k<=missingLeft){
                        r=mid;
                    } else {
                        l = mid;
                        k-=missingLeft;
                    }
                }

                if(arr[r]-arr[l]>=k){
                    return arr[l]+k;
                }

                return -1;
            }
        }
        class Solution1 {

            int findKthMissingNumber(int[] arr, int k){
                for (int i = 1; i < arr.length; i++) {
                    int delta = arr[i] - arr[i-1] - 1;

                    if(delta == 0){
                        continue;
                    }

                    if(k > delta){
                        k-=delta;
                        continue;
                    }

                    return arr[i-1] + k;
                }

                return -1;
            }
        }
    }
}
