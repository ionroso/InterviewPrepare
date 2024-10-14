package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;


/*
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
 */
public class SupplierTest {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test4() {
        Supplier<Integer> randomNumbersSupp=() -> new Random().nextInt(10);
        Stream.generate(randomNumbersSupp)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void test3() {
        Java8Supplier2<String> obj = new Java8Supplier2();

        List<String> list = obj.supplier().get();
    }

    private static class Java8Supplier2<T> {
        public Supplier<List<T>> supplier() {
            return ArrayList::new;
        }

    }

    private static void test2() {
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
    }

    private static void test1() {
        // This function returns a random value.
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());
    }
}
