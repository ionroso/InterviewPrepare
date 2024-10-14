package org.example;

/*
Some Built-in Java Functional Interfaces
Since Java SE 1.8 onwards, there are many interfaces that are converted into functional interfaces. All these interfaces are annotated with @FunctionalInterface. These interfaces are as follows –

Runnable –> This interface only contains the run() method.
Comparable –> This interface only contains the compareTo() method.
ActionListener –> This interface only contains the actionPerformed() method.
Callable –> This interface only contains the call() method.
Java SE 8 included four main kinds of functional interfaces which can be applied in multiple situations as mentioned below:

Consumer
Predicate
Function
Supplier

Amidst the previous four interfaces, the first three interfaces,i.e., Consumer, Predicate, and Function, likewise have additions that are provided beneath –

Consumer -> Bi-Consumer
Predicate -> Bi-Predicate
Function -> Bi-Function, Unary Operator, Binary Operator
 */

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {


    public static class AddThree implements Function<Long, Long> {

        @Override
        public Long apply(Long aLong) {
            return aLong + 3;
        }
    }



    /*
        @FunctionalInterface
        public interface UnaryOperator<T> extends Function<T, U>
        {
            ……...
        }
     */

    /*
        @FunctionalInterface
        public interface BinaryOperator<T> extends BiFunction<T, U, R>
        {
            ……...
        }
     */


    public class CheckForNull implements Predicate {
        @Override
        public boolean test(Object o) {
            return o != null;
        }
    }

    public static void main(String[] args) {
        // Functional Interfaces
        Function<Long, Long> adder = new AddThree();
        Long result = adder.apply((long) 4);
        System.out.println("result = " + result);

        Function<Long, Long> adder1 = (value) -> value + 3;
        Long resultLambda = adder1.apply((long) 8);
        System.out.println("resultLambda = " + resultLambda);

        // Bi-Function

        // Consumer
        Consumer<Integer> consumer = System.out::println;

        // Predicate
        Predicate predicate = Objects::nonNull;

        // Supplier
        Supplier<Integer> supplier = () -> (int) (Math.random() * 1000D);
    }
}
