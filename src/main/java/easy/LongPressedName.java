package easy;

public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("vtkgn", "vttkgnn"));
    }
    boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();

        int i=0, j = 0;
        while( i < n && j < m && name.charAt(i) == typed.charAt(j)){
            i++;
            j++;
            if((i < n && j < m && name.charAt(i) != typed.charAt(j)) || i == n && j < m ){
                while(j < m && typed.charAt(j) == typed.charAt(j-1)) {
                    j++;
                }
            }
        }

        return i == n && j == m;
    }
}
