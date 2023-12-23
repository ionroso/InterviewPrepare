package utility;

import java.util.ArrayList;
import java.util.List;

public class LeetcodeOutputParser implements IParser {
    public LeetcodeOutputParser( ) {
    }

    @Override
    public String[] parse(String str) {
        boolean isEmpty = str == null || str.trim().length() == 0;
        if(isEmpty){
            throw new IllegalArgumentException("str should be valid");
        }

//        Pattern pa = Pattern.compile(inputRegex);
//        Matcher m = pa.matcher(str);
//        List<Integer> indexes = new ArrayList<>();
//
//        while (m.find()){
//            indexes.add(m.start());
//        }


        StringBuilder temp = cutFirstAndLast(new StringBuilder(str));

        String[] splits = temp.toString().split(",");

        // flatten
        boolean first = true;
        List<String> flatten = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String split : splits) {
            if(first){
                flatten.add("null");
                first=false;
                continue;
            }
            sb.append(split).append(",");
            if(split.equals("null")){
                sb.deleteCharAt(sb.length()-1);
                flatten.add(sb.toString());
                sb = new StringBuilder();
            } else if(split.contains("[") && split.contains("]")){
                sb.deleteCharAt(sb.length()-1);
                flatten.add(sb.toString());
                sb = new StringBuilder();
            } else if(split.contains("]")){
                sb.deleteCharAt(sb.length()-1);
                flatten.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        String[] output = flatten.toArray(new String[flatten.size()]);

        int i = 0;
        for (String s : output) {
            if(i==0){
                i++;
                continue;
            }

            if(s.contains("[") && s.contains("]")) {
                output[i] =  cutFirstAndLast(new StringBuilder(s)).toString();
            } else {
                output[i] = s;
            }
            i++;
        }

        return output;
    }

    private StringBuilder cutFirstAndLast(StringBuilder str){
        if(str.length()<2){
            return str;
        }

       return str.deleteCharAt(0).deleteCharAt(str.length()-1);
    }
}
