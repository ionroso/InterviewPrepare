package easy;

public class RectangleOverlap {
    public static void main(String[] args) {
        System.out.println(new RectangleOverlap().isRectangleOverlap(new int[]{0,0,4,4}, new int[]{2,2,3,3}));
    }
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return isRectangleOverlapUtil(rec1, rec2) || isRectangleOverlapUtil(rec2, rec1);

    }

    public boolean isRectangleOverlapUtil(int[] rec1, int[] rec2) {
        boolean case1 = (getXLeftPlane(rec1) > getXLeftPlane(rec2)) && (getXLeftPlane(rec1) < getXRightPlane(rec2));
        boolean case2 = (getXRightPlane(rec1) > getXLeftPlane(rec2)) && (getXRightPlane(rec1) < getXRightPlane(rec2));

        boolean case3 = (getYTopPlane(rec1) > getYBottomPlane(rec2)) && (getYTopPlane(rec1) < getYTopPlane(rec2));
        boolean case4 = (getYBottomPlane(rec1) > getYBottomPlane(rec2)) && (getYBottomPlane(rec1) < getYTopPlane(rec2));

        return case1 || case2 || case3 || case4;

    }

    int getXLeftPlane(int[] rec){
        return rec[0];
    }
    int getXRightPlane(int[] rec){
        return rec[2];
    }

    int getYTopPlane(int[] rec){
        return rec[3];
    }

    int getYBottomPlane(int[] rec){
        return rec[1];
    }
}
