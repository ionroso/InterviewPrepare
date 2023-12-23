package medium;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
        stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        stockSpanner.next(85);  // return 6
    }


    static
    class StockSpanner {

        class FirstBiggerInfo {
            int nextBiggerVal;
            int index;


            public  FirstBiggerInfo(int nextBiggerVal, int index) {
                this.nextBiggerVal = nextBiggerVal;
                this.index = index;
            }
        }

        List<Integer> stocks;
        List<FirstBiggerInfo> spanHistory;
        public StockSpanner() {
            stocks = new ArrayList<>();
            spanHistory = new ArrayList<>();
        }

        public int next(int price) {
            int n = stocks.size();

            if(stocks.size()==0){
                spanHistory.add(new FirstBiggerInfo(-1, 0));
                stocks.add(price);
                return 1;
            }

            int ptr = n-1;
            while (ptr > 0 && price>= stocks.get(ptr)){
                ptr = spanHistory.get(ptr).index;
            }

            int span;
            FirstBiggerInfo fbi;
            if(ptr == 0 && price >= stocks.get(ptr)) {
                span = n + 1;
                fbi = new FirstBiggerInfo(-1, 0);
            } else {
                span = n - ptr;
                fbi = new FirstBiggerInfo(stocks.get(ptr), ptr);
            }

            stocks.add(price);
            spanHistory.add(fbi);
            return span;
        }
    }
}
