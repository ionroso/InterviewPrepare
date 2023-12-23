package easy;

public class RansomNote {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomCounts = countLetters(ransomNote);
        int[] magazineCounts = countLetters(magazine);

        for (int i = 0; i < ransomCounts.length; i++) {
            if(ransomCounts[i] != 0 && ransomCounts[i] > magazineCounts[i]){
                return false;
            }
        }

        return true;

    }

    public static int[] countLetters(String s){
        int[] counts = new int[26];
        for (int i = 0; i <s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }

        return counts;
    }
}
