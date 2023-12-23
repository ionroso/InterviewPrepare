package easy;

import java.util.Objects;
import java.util.function.Predicate;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.isEmpty()) return false;
        if(word.length() == 1) return true;

        Predicate<Integer> predicate = Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1)) ? i -> Character.isUpperCase(word.charAt(i)) : i -> Character.isLowerCase(word.charAt(i));

        for (int i = 1; i < word.length(); i++) {
            if(!predicate.test(i)) return false;
        }

        return true;
    }
}
