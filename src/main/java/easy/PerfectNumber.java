package easy;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(new PerfectNumber().checkPerfectNumber(28));
    }


    public boolean checkPerfectNumber(int num) {
        if (num==1) return false;
        int i=2;
        int total = 0;
        while(i<=num/i){
            if (num%i==0){
                System.out.println("i="+i+" num/i " + num + "/" + i);
                total += i+num/i;
            }
            i++;
        }
        return total+1==num;
    }
    public boolean checkPerfectNumber1(int num) {
        List<Integer> divs = getDivisors(num);

        return sum(divs) == num;
    }

    private int sum(List<Integer> divs){
        int sum = 0;
        for (Integer div : divs) {
            sum+=div;
        }

        return sum;
    }

    private List<Integer> getDivisors(int num) {
        List<Integer> divs = new ArrayList<>();
        for (int i = 1; i < num-1; i++) {
            if(num%i == 0){
                divs.add(i);
            }
        }

        return divs;
    }
}
