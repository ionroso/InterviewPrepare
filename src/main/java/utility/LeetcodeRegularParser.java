package utility;

public class LeetcodeRegularParser implements IParser {

    private final String inputRegex;
    public LeetcodeRegularParser(String inputRegex) {
        this.inputRegex = inputRegex;
    }

    @Override
    public String[] parse(String str) {
        boolean isEmpty = str == null || str.trim().length() == 0;
        if(isEmpty){
            throw new IllegalArgumentException("str should be valid");
        }

        StringBuilder temp = cutFirstAndLast(new StringBuilder(str));
        return  temp.toString().split(inputRegex);
    }

    private StringBuilder cutFirstAndLast(StringBuilder str){
        if(str.length()<2){
            return str;
        }

       return str.deleteCharAt(0).deleteCharAt(str.length()-1);
    }
}
