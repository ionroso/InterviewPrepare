package easy;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        System.out.println(new ValidWordAbbreviation().validWordAbbreviation("substitution", "sub4u4"));
    }
    public boolean validWordAbbreviation(String word, String abbr) {
        int w_n = word.length();
        int a_n = abbr.length();
        int a_i=0;
        int w_i=0;

        StringBuilder sb=new StringBuilder();

        while (a_i < a_n && w_i < w_n){
            char a_c = abbr.charAt(a_i);

            if(Character.isLetter(a_c)){

                if(!sb.isEmpty()){
                    w_i+=Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }

                if(w_i >=w_n || a_c != word.charAt(w_i)) {
                    return false;
                }

                a_i++;
                w_i++;
                continue;
            }

            if(sb.isEmpty() && a_c == '0'){
                return false;
            }
            sb.append(a_c);
            a_i++;
        }

        if(!sb.isEmpty()){
            w_i+=Integer.parseInt(sb.toString());
            if(w_i<w_n && a_i < a_n && abbr.charAt(a_i) != word.charAt(w_i)) {
                return false;
            }
        }

        return a_i == a_n && w_i == w_n;
    }
}
