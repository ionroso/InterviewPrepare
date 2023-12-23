package easy;

public class MergeSortedArray {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int b = m+n-1; //backwards
        int p1 = m-1; // for num1
        int p2 = n-1; // for num2

        while (p1 >= 0 && p2 >=0)
        {
            int max = nums1[p1];
            p1--;
            if(max < nums2[p2]){
                max = nums2[p2--];
                p1++;
            }
            nums1[b--] = max;
        }

        while (p1>=0){
            nums1[b--] = nums1[p1--];
        }

        while (p2>=0){
            nums1[b--] = nums2[p2--];
        }
    }
}
