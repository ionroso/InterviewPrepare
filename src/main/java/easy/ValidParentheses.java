package easy;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }
    // Declaring the static map
    private static Map<Character, Character> map = new HashMap<>();
    static
    {
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
    }

    public boolean isValid(String s) {
        if(s == null || s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == stack.peek()){
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }


        return stack.size() == 0;
    }
}
