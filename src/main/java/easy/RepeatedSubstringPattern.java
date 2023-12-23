package easy;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("ababab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        List<Integer> patternSizes = validPatternSize(n);
        for (Integer patterSize : patternSizes) {
            boolean valid = true;
            for (int i = patterSize; i < n; i+=patterSize) {
                if(!matchPattern(s,patterSize, i)){
                    valid = false;
                    break;
                }
            }
            if(valid){
                return true;
            }
        }

        return false;
    }

    private boolean matchPattern(String s, Integer patterSize, int idx) {
        for (int i = 0; i < patterSize; i++) {
            if(s.charAt(i) != s.charAt(idx + i))
                return false;
        }
        return true;
    }

    List<Integer> validPatternSize(int n){
        List<Integer> output = new ArrayList<>();
        int i=1;
        while (i<=n/2){
            if(n%i==0){
                output.add(i);
            }
            i++;
        }

        return output;
    }




}
