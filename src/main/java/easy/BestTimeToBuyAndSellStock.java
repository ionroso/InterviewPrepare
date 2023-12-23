package easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n==0 || n == 1) return 0;


        int[] min = new int[n];
        int[] max = new int[n];

        min[0]=prices[0];
        for (int i = 1; i < n; i++) {
            min[i]=Math.min(min[i-1],prices[i]);
        }

        max[n-1]=prices[n-1];
        for (int i = n-2; i >=0; i++) {
            max[i]=Math.max(max[i+1],prices[i]);
        }

        int bestProfit = max[0] - min[0];
        for (int i = 1; i < n; i++) {
            bestProfit = Math.max(bestProfit, max[i] - min[i]);
        }

        return bestProfit > 0 ? bestProfit : 0;
    }
}
