package medium;

import utility.IParser;
import utility.LeetcodeArgsParser;
import utility.LeetcodeInputIterator;
import utility.LeetcodeMethodsCallStackInputParser;

import java.util.*;

public class ProductOfTheLastKNumbers {
    public static void main(String[] args) {
        new Test().test();
    }

    private static class Test {
        void test(){

            String methods = "[\"ProductOfNumbers\",\"add\",\"add\",\"add\",\"add\",\"getProduct\",\"getProduct\",\"add\",\"add\",\"add\",\"getProduct\",\"getProduct\",\"add\",\"add\",\"getProduct\",\"getProduct\",\"getProduct\",\"getProduct\",\"add\",\"add\",\"add\",\"add\",\"getProduct\",\"getProduct\",\"getProduct\",\"add\",\"add\",\"add\",\"add\",\"getProduct\",\"add\",\"getProduct\",\"add\",\"add\",\"add\",\"add\",\"getProduct\",\"getProduct\"]";
            String input = "[[],[76],[96],[87],[63],[3],[1],[12],[0],[29],[4],[7],[29],[36],[9],[4],[5],[8],[27],[5],[0],[61],[7],[4],[3],[3],[49],[85],[72],[9],[10],[10],[0],[68],[67],[5],[4],[3]]";
            String output = "[null,null,null,null,null,526176,63,null,null,null,0,0,null,null,0,0,0,0,null,null,null,null,0,0,0,null,null,null,null,0,null,0,null,null,null,null,0,5]";

            IParser p = new LeetcodeMethodsCallStackInputParser(",");
            IParser p1 = new LeetcodeArgsParser();
            LeetcodeInputIterator methodItr = new LeetcodeInputIterator(p,methods);
            LeetcodeInputIterator inputItr = new LeetcodeInputIterator(p1,input);

            ProductOfNumbers productOfNumbers = new ProductOfNumbers();

            Iterator<String> methodIterator = methodItr;
            Iterator<String> inputIterator = inputItr;
            int y = -1;
            while (methodIterator.hasNext()) {
                y++;

                String methodName = methodIterator.next();
                String val = inputIterator.next();


                switch (methodName) {
                    case "ProductOfNumbers": {
                        System.out.println(y + " constr");
                        break;
                    }
                    case "add": {
                        System.out.println(y + " " + val + " ");
                        productOfNumbers.add(Integer.valueOf(val));
                        break;
                    }
                    case "getProduct": {
                        System.out.print(y + " " + val + " ");
                        System.out.println(productOfNumbers.getProduct(Integer.valueOf(val)));
                        break;
                    }

                }
            }
            System.out.println();
        }

        class ProductOfNumbers {

            int prod = 1;
            int zeroLastIdx = -1;

            float factor = 0.25f;

            LinkedList<Integer> buffer;

            ArrayList<Integer> al;

            public ProductOfNumbers() {
                al = new ArrayList<>();
                buffer = new LinkedList<>();
            }

            public void add(int num) {
                if(num == 0){
                    zeroLastIdx = al.size();
                }

                al.add( num);

                int sizeFactored = (int)(al.size() * factor);

                if(!buffer.isEmpty() & buffer.size() >= sizeFactored){
                    buffer.removeFirst();
                }

                buffer.addLast(num);
            }

            public int getProduct(int k) {
                if(zeroLastIdx>=al.size()-k){
                    return 0;
                }

                if(!buffer.isEmpty() && k<buffer.size()){
                    int prodRez = 1;
                    for (int i = buffer.size()-1; i >= buffer.size()-k; i--) {
                        prodRez *= buffer.get(i);
                    }

                    return prodRez;
                } else {
                    int prodRez = 1;
                    for (int i = al.size()-1; i >= al.size()-k; i--) {
                        prodRez *= al.get(i);
                    }

                    return prodRez;
                }
            }
        }
    }
}
