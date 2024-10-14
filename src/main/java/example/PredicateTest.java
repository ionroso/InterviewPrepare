package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}

@FunctionalInterface
public interface BiPredicate<T, U> {
    boolean test(T t, U u);
}
 */
public class PredicateTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test6() {
        BiPredicate<String, Integer> filter = (x, y) -> {
            return x.length() == y;
        };

        boolean result = filter.test("mkyong", 6);
        System.out.println(result);  // true

        boolean result2 = filter.test("java", 10);
        System.out.println(result2); // false
    }

    private static void test5() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));

        // This line uses Predicates to filter
        // out the list of users with the role "admin".
        // List admins = process(users, (User u) ->
        // u.getRole().equals("admin"));

        // Replacing it with the following line
        // using Stream API and lambda functions
        // produces the same output

        // the input to the filter() is a lambda
        // expression that returns a predicate: a
        // boolean value for each user encountered
        // (true if admin, false otherwise)
        List admins = users.stream()
                .filter((user) -> user.getRole().equals("admin"))
                .collect(Collectors.toList());

        System.out.println(admins);    }

    static class User {
        String name, role;

        User(String a, String b) {
            name = a;
            role = b;
        }

        String getRole() {
            return role;
        }

        String getName() {
            return name;
        }

        public String toString() {
            return "User Name : " + name + ", Role :" + role;
        }
    }

    private static List<User> process(List<User> users, Predicate<User> predicate)
    {
        List<User> result = new ArrayList<>();
        for (User user: users)
            if (predicate.test(user))
                result.add(user);
        return result;
    }
    private static void test4() {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", "admin"));
        users.add(new User("Peter", "member"));
        List admins = process(users, (User u) -> u.getRole().equals("admin"));
        System.out.println(admins);
    }


    public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
        @Override
        public boolean test(String t)
        {
            return t.length() > 10;
        }
    };

    private static void test3() {
        Predicate<String> nonNullPredicate = Objects::nonNull;

        String nullString = null;

        boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);
        System.out.println(outcome);

        String lengthGTThan10 = "Welcome to the machine";
        boolean outcome2 = nonNullPredicate.and(hasLengthOf10).
                test(lengthGTThan10);
        System.out.println(outcome2);
    }

    private static void test2() {
        Predicate<Integer> greaterThanTen = (i) -> i > 10;

        // Creating predicate
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
        System.out.println(result);

        // Calling Predicate method
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);
        System.out.println(result2);
    }

    private static void test1()
    {
        // Creating predicate
        Predicate<Integer> lesserthan = i -> (i < 18);

        // Calling Predicate method
        System.out.println(lesserthan.test(10));
    }
}
