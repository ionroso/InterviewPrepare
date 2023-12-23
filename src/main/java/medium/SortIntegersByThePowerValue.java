package medium;

import java.util.PriorityQueue;

public class SortIntegersByThePowerValue {
    public static void main(String[] args) {
        System.out.println(new SortIntegersByThePowerValue().getKth(7,11,4));
    }
        public int getKth(int lo, int hi, int k) {
            if(lo == hi && k ==1 ) return lo;
            int[] steps = new int[hi-lo+1];
            for (int i = lo; i <= hi; i++) {
                steps[i - lo] = steps(i);
            }

            int[] indexes = new int[steps.length];
            for (int i = 0; i < steps.length; i++) {
                indexes[i] = i;
            }

            new QuickSort().quickSortIterative(steps, indexes,0, steps.length-1);

            int l = k-1, h = k-1;
            while (steps[l] == steps[k-1] && steps[h] == steps[k-1]){
                if(steps[l] == steps[k-1] && l-1>=0) l--;
                if(steps[h] == steps[k-1] && h+1<steps.length) h++;
            }


            new QuickSort().quickSortIterative(indexes, steps, l, h);

            return indexes[k-1]+lo;
        }

        public int steps(int n)
        {
            if(n==1){
                return 0;
            }

            return steps(n%2==0 ? n/2 : 3*n+1) + 1;
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

            void quickSortIterative(int arr[], int indexes[], int l, int h)
            {

                if (l==h) return;

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
            }
        }
}
