package easy;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagarbm"));
    }

    public boolean isAnagram(String s, String t) {
        int[] s_count = new int[26];
        countLetters(s, s_count);

        int[] t_count = new int[26];
        countLetters(t, t_count);

        for (int i = 0; i < 26; i++) {
            if(s_count[i] != t_count[i]){
                return false;
            }
        }

        return true;
    }

    private void countLetters(String s, int[] arr)
    {
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
    }
}
