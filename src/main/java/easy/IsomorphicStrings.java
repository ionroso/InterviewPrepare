package easy;

import java.util.*;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {
        if((s == null &&  t != null) || (s != null &&  t == null)) return false;

        if(s.length() != t.length()) return false;


        Map<Character, List<Integer>> charIndexes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexes = charIndexes.get(s.charAt(i));
            if(indexes == null) {
                indexes = new ArrayList<>();
                charIndexes.put(s.charAt(i), indexes);
            }

            indexes.add(i);
        }

        char[] output = new char[s.length()];
        Set<Character> unq = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            char tc = t.charAt(i);
            if(!unq.contains(tc)){
                unq.add(tc);
                List<Integer> indexes = charIndexes.get(s.charAt(i));
                for (Integer index : indexes) {
                    output[index] = tc;
                }
            }
        }

        return new String(output).equals(t);
    }
}
