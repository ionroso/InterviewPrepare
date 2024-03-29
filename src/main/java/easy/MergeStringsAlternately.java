package easy;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder output = new StringBuilder();
        int i=0, j=0;
        while (i<word1.length() && j<word2.length()){
            output.append(word1.charAt(i));
            output.append(word2.charAt(j));
            i++;
            j++;
        }

        while (i<word1.length()){
            output.append(word1.charAt(i));
            i++;
        }

        while (j<word2.length()){
            output.append(word2.charAt(j));
            j++;
        }

        return output.toString();
    }
}
