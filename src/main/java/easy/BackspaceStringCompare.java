package easy;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
    public boolean backspaceCompare(String s, String t) {

        String s1 = removeCharBackspaced(s);
        String t1 = removeCharBackspaced(t);

        if(s1.length() != t1.length()){
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != t1.charAt(i)){
                return false;
            }
        }

        return true;
    }

    public String removeCharBackspaced(String s) {
        if(s.isEmpty()) return "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#'){
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        char[] output = new char[stack.size()];
        int i = stack.size()-1;
        while (i>=0){
            output[i--] = stack.pop();
        }


        return new String(output);
    }
}
