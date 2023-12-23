package utility;

public class LeetcodeMethodsCallStackInputParser implements IParser {
    private final String inputRegex;

    public LeetcodeMethodsCallStackInputParser(String inputRegex) {
        this.inputRegex = inputRegex;
    }

    @Override
    public String[] parse(String str) {
        boolean isEmpty = str == null || str.trim().length() == 0;
        if(isEmpty){
            throw new IllegalArgumentException("str should be valid");
        }

        StringBuilder temp = cutFirstAndLast(new StringBuilder(str));
        String[] split = temp.toString().split(inputRegex);
        for (int i = 0; i < split.length; i++) {
            split[i] = cutFirstAndLast(new StringBuilder(split[i])).toString();

        }
        return split;
    }

    private StringBuilder cutFirstAndLast(StringBuilder str){
        if(str.length()<2){
            return str;
        }

       return str.deleteCharAt(0).deleteCharAt(str.length()-1);
    }
}
