package easy;

import java.util.*;

public class SortingTheSentence {
    static public String sortSentence(String s) {
        if(s == null || s.isEmpty()){
            return s;
        }

        String[] split = s.split("\\ ");
        SortedMap<Integer, String> keys = new TreeMap<>();
        for (String s1 : split) {
            int intVal = s1.charAt(s1.length()-1);
            keys.put(intVal, s1.substring(0, s1.length()-2));
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Map.Entry<Integer, String> entry : keys.entrySet()) {
            sb.append(entry.getValue());
            count++;
            if(count<split.length){
                sb.append("\\ ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
