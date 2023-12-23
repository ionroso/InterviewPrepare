package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        if(s1 == null) return new String[]{s2};
        if(s2 == null) return new String[]{s1};

        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");

        Map<String, Integer> counts = new HashMap<>();
        for (String s : split1) {
            counts.put(s,counts.getOrDefault(s, 0)+1);
        }

        for (String s : split2) {
            counts.put(s,counts.getOrDefault(s, 0)+1);
        }

        return counts.entrySet().stream().filter(e -> e.getValue() == 1).map(e->e.getKey()).toArray(String[]::new);
    }
}
