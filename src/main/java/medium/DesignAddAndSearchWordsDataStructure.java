package medium;


public class DesignAddAndSearchWordsDataStructure {

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("abc");
        System.out.println(wd.search("."));
    }

    static
    class WordDictionary {
        class TieNode {
            TieNode[] characters = new TieNode[26];
            boolean isLeaf;
        }


        TieNode tie;

        public WordDictionary() {
            tie = new TieNode();
        }

        public void addWord(String word) {
            addWordRec(tie, word, 0);
        }

        private void addWordRec(TieNode root, String word, int wordIdx) {
            if(root == null) return;
            if(wordIdx == word.length()){
                root.isLeaf = true;
                return;
            }

            int i = word.charAt(wordIdx)-'a';
            if(root.characters[i] == null){
                root.characters[i] = new TieNode();

            }

            addWordRec(root.characters[i], word, wordIdx+1);
        }

        public boolean search(String word) {
            return searchRec(tie, word, 0);
        }

        private boolean searchRec(TieNode root, String word, int wordIdx) {
            if(root == null) return false;
            if(wordIdx == word.length() && !root.isLeaf) return false;

            if(wordIdx == word.length() && root.isLeaf) {
                return true;
            }

            if(word.charAt(wordIdx) != '.'){
                int i = word.charAt(wordIdx)-'a';
                return searchRec(root.characters[i], word, wordIdx+1);
            }

            for (TieNode node : root.characters) {
                boolean rez = false;
                if(node!=null){
                    rez = searchRec(node, word, wordIdx+1);
                }

                if(rez) return true;
            }

            return false;
        }
    }

}
