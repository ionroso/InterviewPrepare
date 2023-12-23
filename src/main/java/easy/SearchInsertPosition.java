package easy;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{2,5,7}, 8));
    }
    public int searchInsert(int[] nums, int target) {
        int[] indexes = new QuickSort().quickSortIterative(nums, 0, nums.length-1);

        int l = 0, r = nums.length-1;
        if(target < nums[l]) return l;
        if(target > nums[r]) return r+1;

        while (l<=r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                return indexes[mid];
            }

            if(target<nums[mid]){
                r=mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return indexes[l];
    }

    private class QuickSort {
        int partition(int arr[],int[] indexes, int low, int high)
        {
            int pivot = arr[high];

            // index of smaller element
            int i = (low - 1);
            for (int j = low; j <= high - 1; j++) {
                // If current element is smaller than or
                // equal to pivot
                if (arr[j] <= pivot) {
                    i++;

                    swap(arr, indexes, i, j);
                    // swap arr[i] and arr[j]
                }
            }

            // swap arr[i+1] and arr[high] (or pivot)
            swap(arr, indexes, i + 1, high);

            return i + 1;
        }

        void swap(int[] arr, int[] indexes, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            temp = indexes[i];
            indexes[i] = indexes[j];
            indexes[j] = temp;
        }

        int[] quickSortIterative(int arr[], int l, int h)
        {
            int[] indexes = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                indexes[i] = i;
            }
            if(l==h){
                return indexes;
            }
            // Create an auxiliary stack
            int[] stack = new int[h - l + 1];

            // initialize top of stack
            int top = -1;

            // push initial values of l and h to stack
            stack[++top] = l;
            stack[++top] = h;

            // Keep popping from stack while is not empty
            while (top >= 0) {
                // Pop h and l
                h = stack[top--];
                l = stack[top--];

                // Set pivot element at its correct position
                // in sorted array
                int p = partition(arr, indexes, l, h);

                // If there are elements on left side of pivot,
                // then push left side to stack
                if (p - 1 > l) {
                    stack[++top] = l;
                    stack[++top] = p - 1;
                }

                // If there are elements on right side of pivot,
                // then push right side to stack
                if (p + 1 < h) {
                    stack[++top] = p + 1;
                    stack[++top] = h;
                }
            }

            return indexes;
        }
    }

}
