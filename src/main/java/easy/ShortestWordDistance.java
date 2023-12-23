package easy;

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int lastW1 = -1;
        int lastW2 = -1;
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)){
                lastW1=i;
            } else if(wordsDict[i].equals(word2)) {
                lastW2=i;
            }

            dist = lastW1!=-1 && lastW2!=-1 ? Math.min(dist, Math.abs(lastW1-lastW2)) : dist;
        }

        return dist;
    }
}
