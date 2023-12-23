package easy;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String main) {
        int[] mainCounts = getLetterCounts(main);
        int totalCount = 0;
        for (String word : words) {
            int[] wordCounts = getLetterCounts(word);
            boolean good = true;
            for (int i = 0; i < 26; i++) {
                if(mainCounts[i] < wordCounts[i]){
                    good = false;
                    break;
                }
            }

            if(good){
                totalCount+=word.length();
            }
        }

        return totalCount;
    }

    public int[] getLetterCounts(String word){
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a']++;
        }

        return chars;
    }
}
