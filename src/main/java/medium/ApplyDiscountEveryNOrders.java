package medium;

import java.util.HashMap;
import java.util.Map;

public class ApplyDiscountEveryNOrders {

    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        public void test() {
        }


           private class Cashier {
               int n;
               int discount;

               Map<Integer, Integer> productPrice;
               int currAccountNumber;


                public Cashier(int n, int discount, int[] products, int[] prices) {
                    this.n = n;
                    this.discount = discount;
                    this.productPrice = new HashMap<>();

                    for (int i = 0; i < products.length; i++){
                        productPrice.put(products[i], prices[i]);
                    }

                }

                public double getBill(int[] product, int[] amount) {

                    currAccountNumber++;

                    int total=0;
                    for (int i = 0; i < product.length; i++) {
                        total += (productPrice.get(product[i])*amount[i]);
                    }


                    double rezult = total;
                    if(currAccountNumber == n){
                        currAccountNumber=0;
                        rezult = (double) total * (100-discount)/100;
                    }

                    return rezult;
                }
            }

    }
}
