package easy;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(2147395600));
    }
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;

        int l = 1, r = num/2;
        while(l<r){
            int mid = (l+r)/2;
            long square = (long)mid * mid;

            if(square > num || square > Integer.MAX_VALUE) {
                r = mid;
            } else if(square < num) {
                l = mid;
            } else {
                return true;
            }

            if(l+1==r) break;
        }


        if(l*l == num || (l+1)*(l+1)==num || r*r == num) return true;

        return false;
    }
}
