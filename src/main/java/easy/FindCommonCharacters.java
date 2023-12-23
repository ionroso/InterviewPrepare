package easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        int a = 'a';
        int z = 'z';
        int a_i = 0;
        System.out.println((char)(a_i+97));
    }
    public List<String> commonChars(String[] words) {
        List<String> output = new ArrayList<>();
        if(words.length==0) return output;


        int[] inter = getLetterCounts(words[0]);
        for (int i = 1; i < words.length; i++) {
            int[] temp = getLetterCounts(words[i]);
            for (int j = 0; j < 26; j++) {
                inter[j] = Math.min(inter[j], temp[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 97);
            for (int j = 0; j < inter[i]; j++) {
                output.add(Character.toString(c));
            }
        }

        return output;
    }

    public int[] getLetterCounts(String word){
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a']++;
        }

        return chars;
    }
}
