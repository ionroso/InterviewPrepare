package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();

        if(arr.length == 2){
            List<Integer> p = new ArrayList<>();
            p.add(arr[0]);
            p.add(arr[1]);
            output.add(p);
            return output;
        }

        int min = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] == min){
                List<Integer> p = new ArrayList<>();
                p.add(arr[0]);
                p.add(arr[1]);
                output.add(p);
            }
        }

        return output;
    }
}
