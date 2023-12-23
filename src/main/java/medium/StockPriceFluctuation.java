package medium;

import utility.*;

import java.util.*;

public class StockPriceFluctuation {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {

        /*
         - update (timestamp, price)
         -- insert
         -- update

         - get current price
         - get max price
         - get min price

         example:
          Insert:
          1. input = (1,100) - insert, (2,200)- insert, (3,300)- insert,   output = (1,100), (2,200), (3,300)
          2. input = (1,200), (2,100),(3,300)                              output = (2,100), (1,200), (3,300)
          Update:
          3. (1,200),(2,100),(3,300)
            update: (3,50) output = (3,50),(1,200),(2,100)

         Map<Integer, StockInfo> timestampToStock;
         Options:
         1. min heap + max heap
         Time complexity: get - O(1), insert 2 * O(log n), update - find O(1) + remove 2 * O(logh) + heapify = 2* O(logh)
         2. double linked list = LinkedList<StockInfo> stockStream;
         Time complexity: get - O(1), insert O(1) + find BS O(logn), update find BS O(logn) + remove and insert O(1)
         */

        void test() {

            IParser p = new LeetcodeMethodsCallStackInputParser(",");
            IParser p1 = new LeetcodeArgsParser();
            LeetcodeInputIterator method = new LeetcodeInputIterator(p,"[\"StockPrice\",\"update\",\"update\",\"current\",\"maximum\",\"update\",\"maximum\",\"update\",\"minimum\"]");
            LeetcodeInputIterator input = new LeetcodeInputIterator(p1,"[[],[1,10],[2,5],[],[],[1,3],[],[4,2],[]]");
            LeetcodeInputIterator expected = new LeetcodeInputIterator(new LeetcodeRegularParser(","),"[null,null,null,5,10,null,5,null,2]");

            StockPrice stockPrice = null;

            Iterator<String> methodIterator = method;
            Iterator<String> inputIterator = input;
            Iterator<String> expectedIterator = expected;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;
                System.out.print(y + " ");
                String methodName = methodIterator.next();
                String val = inputIterator.next();
                String expectedVal = expectedIterator.next();

                switch (methodName) {
                    case "StockPrice": {
                        stockPrice = new StockPrice();
                        break;
                    }
                    case "update": {
                        String[] split = val.split(",");
                        int val1 = Integer.valueOf(split[0]);
                        int val2 = Integer.valueOf(split[1]);
                        System.out.print("update: " + val1 + " - " + val2);
                        stockPrice.update(val1, val2);
                        break;
                    }
                    case "current": {
                        System.out.print("current: " + stockPrice.current() + " - " + expectedVal + " " + (stockPrice.current() != Integer.valueOf(expectedVal) ? "false" : "" ));
                        break;
                    }
                    case "maximum": {
                        System.out.print("maximum: " + stockPrice.maximum() + " - " + expectedVal + " " +  (stockPrice.maximum() != Integer.valueOf(expectedVal) ? "false" : "" ));
                        break;
                    }
                    case "minimum": {
                        System.out.print("minimum: " + stockPrice.minimum() + " - " + expectedVal + " " +  (stockPrice.minimum() != Integer.valueOf(expectedVal) ? "false" : "" ));
                        break;
                    }
                }
                System.out.println();
            }
//
//
//
//
//            StockPrice stockPrice = new StockPrice();
//            stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
//            stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
//            stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
//            stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
//            stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
//            // Timestamps are [1,2] with corresponding prices [3,5].
//            stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
//            stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
//            stockPrice.maximum();     // return 2, the minimum price is 2 at timestamp 4.
        }


        static
        class HashedAndSortedMap {
            class StockPrice {
                int latestTime;
                // Store price of each stock at each timestamp.
                Map<Integer, Integer> timestampPriceMap;
                // Store stock prices in increasing order to get min and max price.
                TreeMap<Integer, Integer> priceFrequency;

                public StockPrice() {
                    latestTime = 0;
                    timestampPriceMap = new HashMap<>();
                    priceFrequency = new TreeMap<>();
                }

                public void update(int timestamp, int price) {
                    // Update latestTime to latest timestamp.
                    latestTime = Math.max(latestTime, timestamp);

                    // If same timestamp occurs again, previous price was wrong.
                    if (timestampPriceMap.containsKey(timestamp)) {
                        // Remove previous price.
                        int oldPrice = timestampPriceMap.get(timestamp);
                        priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);

                        // Remove the entry from the map.
                        if (priceFrequency.get(oldPrice) == 0) {
                            priceFrequency.remove(oldPrice);
                        }
                    }

                    // Add latest price for timestamp.
                    timestampPriceMap.put(timestamp, price);
                    priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);
                }

                public int current() {
                    // Return latest price of the stock.
                    return timestampPriceMap.get(latestTime);
                }

                public int maximum() {
                    // Return the maximum price stored at the end of sorted-map.
                    return priceFrequency.lastKey();
                }

                public int minimum() {
                    // Return the maximum price stored at the front of sorted-map.
                    return priceFrequency.firstKey();
                }
            }
        }

        static
        class StockPrice {
            class StockInfo {
                int timestamp;
                int price;

                public StockInfo(int timestamp, int price) {
                    this.timestamp = timestamp;
                    this.price = price;
                }
            }

            Map<Integer, StockInfo> timestampToStockInfo;
            PriorityQueue<StockInfo> maxPQ;
            PriorityQueue<StockInfo> minPQ;

            int currentTS = -1;

            public StockPrice() {
                timestampToStockInfo = new HashMap<>();
                minPQ = new PriorityQueue<>((o1, o2) -> o1.price - o2.price);
                maxPQ = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);
            }

            public void update(int timestamp, int price) {

                currentTS = Math.max(currentTS, timestamp);
                StockInfo si = timestampToStockInfo.computeIfAbsent(timestamp, t -> new StockInfo(t, price));

                maxPQ.remove(si);
                minPQ.remove(si);

                si.price = price;

                maxPQ.offer(si);
                minPQ.offer(si);
            }

            public int current() {
                if (isEmpty()) {
                    return -1;
                }

                return timestampToStockInfo.get(currentTS).price;

            }

            public int maximum() {
                if (isEmpty()) {
                    return -1;
                }

                return maxPQ.peek().price;
            }

            public int minimum() {
                if (isEmpty()) {
                    return -1;
                }

                return minPQ.peek().price;
            }

            private boolean isEmpty() {
                return currentTS == -1;
            }
        }

        class StockPrice3 {
            class StockInfo {
                int timestamp;
                int price;

                public StockInfo(int timestamp, int price) {
                    this.timestamp = timestamp;
                    this.price = price;
                }
            }

            StockInfo current;

            boolean needsSorting = false;

            ArrayList<StockInfo> al = new ArrayList<StockInfo>();
            Map<Integer, StockInfo> map;

            public StockPrice3() {
                al = new ArrayList<>();
                map = new HashMap<>();
            }

            public void update(int timestamp, int price) {
                StockInfo si = new StockInfo(timestamp, price);
                needsSorting = true;
                if(current == null || current.timestamp <= si.timestamp) {
                    current = si;
                }

                if(!map.containsKey(timestamp)){
                    map.put(timestamp, si);
                    al.add(si);

                    return;
                }

                al.remove(map.get(timestamp));
                map.remove(timestamp);

                map.put(timestamp, si);
                al.add(si);
            }


            public int current() {
                if (isEmpty()) {
                    return -1;
                }

                return current.price;
            }

            public int maximum() {
                if (isEmpty()) {
                    return -1;
                }

                if(needsSorting){
                    Collections.sort(al, (o1, o2) -> o1.price - o2.price);
                }

                needsSorting = false;

                return al.get(al.size()-1).price;
            }

            public int minimum() {
                if (isEmpty()) {
                    return -1;
                }

                if(needsSorting){
                    Collections.sort(al, (o1, o2) -> o1.price - o2.price);
                }

                needsSorting = false;

                return al.get(0).price;
            }

            public boolean isEmpty() {
                return al.isEmpty();
            }
        }

        class StockPrice2 {
            class StockInfo {
                int timestamp;
                int price;

                public StockInfo(int timestamp, int price) {
                    this.timestamp = timestamp;
                    this.price = price;
                }
            }

            StockInfo current;
            LinkedList<StockInfo> orderedStockStream;
            Map<Integer, StockInfo> timeToStock;

            public StockPrice2() {
                orderedStockStream = new LinkedList<>();
                timeToStock = new HashMap<>();
            }

            public void update(int timestamp, int price) {
                StockInfo si = new StockInfo(timestamp, price);

                if(current == null || current.timestamp <= si.timestamp) {
                    current = si;
                }


                if(isEmpty()){
                    timeToStock.put(timestamp, si);
                    orderedStockStream.add(si);
                    return;
                }

                remove(timestamp);
                add(si, lookupLastBigger(si));
            }

            private void add(StockInfo si, int index) {
                timeToStock.put(si.timestamp, si);
                orderedStockStream.add(index, si);
            }

            private void remove(int timestamp) {
                if (timeToStock.containsKey(timestamp)) {

                    int index = lookup(timeToStock.get(timestamp));
                    orderedStockStream.remove(index);
                    timeToStock.remove(timestamp);
                }
            }

            private int lookup(StockInfo stockInfo) {
                int item = stockInfo.price;
                int low = 0, right = orderedStockStream.size() - 1;
                while (low <= right) {
                    int m = low + (right - low) / 2;

                    // Check if x is present at mid
                    if (orderedStockStream.get(m).price == item)
                        return m;

                    // If x greater, ignore left half
                    if (orderedStockStream.get(m).price < item)
                        low = m + 1;

                        // If x is smaller, ignore right half
                    else
                        right = m - 1;
                }

                // If we reach here, then element was
                // not present
                return -1;
            }

            private int lookupLastBigger(StockInfo stockInfo) {
                int item = stockInfo.price;
                int low = 0;
                int high = orderedStockStream.size()-1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if (item == orderedStockStream.get(mid).price)
                        return mid + 1;
                    else if (item > orderedStockStream.get(mid).price)
                        low = mid + 1;
                    else
                        high = mid - 1;
                }

                return low;
            }

            public int current() {
                if (isEmpty()) {
                    return -1;
                }

                return current.price;
            }

            public int maximum() {
                if (isEmpty()) {
                    return -1;
                }

                return orderedStockStream.get(orderedStockStream.size() - 1).price;
            }

            public int minimum() {
                if (isEmpty()) {
                    return -1;
                }

                return orderedStockStream.get(0).price;
            }

            public boolean isEmpty() {
                return orderedStockStream.isEmpty();
            }
        }


    }
}
