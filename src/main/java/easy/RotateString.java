package easy;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
    }
    public boolean rotateString(String s, String goal) {
        if(s == null && goal != null) return false;
        if(s.equals(goal)) return true;

        StringBuilder sb = new StringBuilder(s);
        StringBuilder goalb = new StringBuilder(goal);

        for(int i=0; i<s.length(); i++){
            char c = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, c);
            System.out.println(sb.toString() + " " + goalb.toString());
            if(sb.compareTo(goalb) == 0) return true;
        }

        return false;
    }
}
