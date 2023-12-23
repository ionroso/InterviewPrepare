package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        int curr = n;
        while (true)
        {
           List<Integer> digits = intToArray(curr);
           curr = sumOfSquares(digits);
           if(set.contains(curr)){
               break;
           }

           set.add(curr);
           if(curr==1){
               return true;
           }
        }

        return false;
    }

    public static int sumOfSquares(List<Integer> digits) {
        int rez = 0;
        for (Integer digit : digits) {
            rez+=Math.pow(digit,2);
        }
        return rez;
    }

    public static List<Integer> intToArray(int num) {
        int temp = num;
        List<Integer> array = new ArrayList<>();
        do{
            array.add(num % 10);
            num /= 10;
        } while  (num > 0);
        return array;
    }
}
