package easy;

import java.util.ArrayList;
import java.util.List;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println(new FindTheIndexOfTheFirstOccurrenceInAString().strStr("sadbutsad", "sad"));
    }
    public int strStr(String haystack, String needle) {
        String[] output = new String[]{haystack, needle};
        for (int i = 0; i < 2; i++) {
            if (output[i] == null) return -1;
        }

        List<Integer> startIdx = new ArrayList<>();
        int firstChar = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == firstChar){
                startIdx.add(i);
            }
        }

        for (Integer idx : startIdx) {
            if(matches(haystack, needle, idx)){
                return idx;
            }
        }


        return -1;
    }

    private boolean matches(String haystack, String needle, Integer idx) {
        for (int i = 0; i < needle.length(); i++) {
            if((idx+i > haystack.length()-1) || (haystack.charAt(idx+i) != needle.charAt(idx))){
                return false;
            }
        }

        return true;
    }

}
