package easy;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public static void main(String[] args) {
        System.out.println(new RearrangeSpacesBetweenWords().reorderSpaces("  this   is  a sentence "));
    }
    public String reorderSpaces(String text) {
        List<String> words = new ArrayList<>();
        int countSpaces = 0;
        int wordStartIdx = -1;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' '){
                countSpaces++;

                if(wordStartIdx!=-1){
                    words.add(text.substring(wordStartIdx, i));
                    wordStartIdx = -1;
                }
            } else {
                if(wordStartIdx == -1){
                    wordStartIdx = i;
                }

                if(i == text.length()-1){
                    words.add(text.substring(wordStartIdx, text.length()-1));
                }
            }
        }



        int intPart = countSpaces / (words.size() - 1);
        int fractionPart = countSpaces % (words.size() - 1);

        StringBuilder spaceWindow = new StringBuilder();
        for (int i = 0; i < intPart; i++) {
            spaceWindow.append(" ");
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            output.append(words.get(i));
            if(i!=words.size()-1){
                output.append(spaceWindow);
            }
        }

        for (int i = 0; i < fractionPart; i++) {
            output.append(" ");
        }
        return output.toString();
    }
}
