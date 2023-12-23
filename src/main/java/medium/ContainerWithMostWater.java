package medium;

// not solved fully

public class ContainerWithMostWater {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
            System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        }

        class Solution {
            Solution() {

            }

            public int maxArea(int[] height) {
                int n = height.length;

                int area = -1, pH = 0;
                for (int l = 0; l < n; l++) {
                    for (int r = n-1; r >l ; r--) {
                        if(r==n-1){
                            area = Math.max(area, getArea(height, l, n-1));
                            pH = height[n-1];
                            continue;
                        }

                        if(height[r]>pH){
                            area = Math.max(area, getArea(height, l, r));
                            pH =  Math.min(height[l], height[r]);
                        }

                    }
                }

                return area;
            }

            int getArea(int[] height, int l, int r){
                return Math.min(height[l], height[r]) * (r-l);
            }
        }
    }
}
