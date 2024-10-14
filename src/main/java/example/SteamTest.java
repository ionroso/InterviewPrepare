package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class SteamTest {

    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };
    private static List<Employee> empList = Arrays.asList(arrayOfEmps);

    public static void main(String[] args) {
//        createTest();
//        forEach();
//        mapTest();
//        colectTest();
//        filterTest();
//        findFirstTest();
//        findAnyTest();
//        toArrayTest();
//        flatMapTest();
//        peekTest();

        // pipelines
//        countTest();
//        skipLimitTest();
//        lazyEvalTest();
//        sortedTest();
//        minAndMaxTest();
//        distinctTest();
//        matchTest();
//        averageTest();
//        reduceTest();
//        collectorsJoinTest();
//        collectorsToSetTest();
//        collectorsToCollectionTest();
//        summarizingDoubleTest();
//        partitioningByTest();
//        groupingByTest();
//        mappingInsteadOfGroupingTest();
//        reducingTest(); // not reduce
//        parallelStreamTest();

//        generateTest(); //Infinite Streams
//        iterateTest();  //Infinite Streams
//        iterateWithStopConditionTest();
//        takeWhileTest();
//        dropWhileTest();
//        takeWhileVsFilterTest();
        ofNullableTest();
        // File Operations
//        writeToFileTest();
//        readFromFileTest();

    }

    private static void ofNullableTest() {
        Integer number = 2;
        Stream<Integer> result = number != null
                ? Stream.of(number)
                : Stream.empty();


        Stream<Integer> result1 = Stream.ofNullable(number);
        result1.map(x -> x * x).forEach(System.out::println);
    }

    private static void iterateWithStopConditionTest() {
        Stream.
                iterate(1, i -> i < 256, i -> i * 2)
                .forEach(System.out::println);
    }

    private static void dropWhileTest() {
        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .dropWhile(x -> x <= 5)
                .forEach(System.out::println);
    }

    private static void takeWhileVsFilterTest() {
        /*
            As you can see, filter() applies the predicate throughout the whole sequence.
            On the other hand, takeWhile stops evaluating as soon as it finds
            the first occurrence where the condition is false.
         */
        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .takeWhile(x -> x <= 5)
                .forEach(e->System.out.print(e + " "));

        System.out.println();

        Stream.of(1,2,3,4,5,6,7,8,9,0,9,8,7,6,5,4,3,2,1,0)
                .filter(x -> x <= 5)
                .forEach(e->System.out.print(e + " "));
    }

    private static void takeWhileTest() {
        // create a stream of numbers from 1 to 10
        Stream<Integer> stream
                = Stream.of(4, 4, 4, 5, 6, 7, 8, 9, 10);

        // apply takeWhile to take all the numbers
        // matches passed predicate
        List<Integer> list
                = stream.takeWhile(number -> (number / 4 == 1))
                .collect(Collectors.toList());

        // print list
        System.out.println(list);
    }

    private static void readFromFileTest() {
        try {
            List<String> str = getPalindrome(Files.lines(Paths.get("writeToFileTest")), 5);
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeToFileTest() {
        String[] words = {
                "hello",
                "refer",
                "world",
                "level"
        };

        try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(Paths.get("writeToFileTest")))) {
            Stream.of(words).forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getPalindrome(Stream<String> stream, int length) {
        return stream.filter(s -> s.length() == length)
                .filter(s -> s.compareToIgnoreCase(new StringBuilder(s).reverse().toString()) == 0)
                .collect(Collectors.toList());
    }

    private static void iterateTest() {
        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = evenNumStream
                .limit(5)
                .collect(Collectors.toList());

    }

    private static void generateTest() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void parallelStreamTest() {
        empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0));
    }

    private static void reducingTest() {
        Double percentage = 10.0;
        Double salIncrOverhead = empList.stream()
                .collect(Collectors.reducing(0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));
    }

    private static void mappingInsteadOfGroupingTest() {
        Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.mapping(Employee::getId, Collectors.toList())));

        System.out.println(idGroupedByAlphabet.get('B').get(0));
        System.out.println(idGroupedByAlphabet.get('J').get(0));
        System.out.println(idGroupedByAlphabet.get('M').get(0));
    }

    private static void groupingByTest() {
        Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0)));

        System.out.println(groupByAlphabet.get('B').get(0).getName());
        System.out.println(groupByAlphabet.get('J').get(0).getName());
        System.out.println(groupByAlphabet.get('M').get(0).getName());
        System.out.println();
    }

    /*
    partitioningBy
We can partition a stream into two – based on whether the elements satisfy certain criteria or not.
     */
    private static void partitioningByTest() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println();
    }

    private static void summarizingDoubleTest() {
        DoubleSummaryStatistics stats = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
    }

    private static void collectorsToCollectionTest() {
        Vector<String> empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));
    }

    private static void collectorsToSetTest() {
        Set<String> empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
    }

    private static void collectorsJoinTest() {
        String empNames = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "))
                .toString();
    }

    private static void reduceTest() {
        Double sumSal = empList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);

    }

    private static void averageTest() {
        Double avgSal = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    private static void matchTest() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);

        boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
    }

    private static void distinctTest() {
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
        List<Integer> distinctIntList =
                intList.stream()
                        .distinct()
                        .collect(Collectors.toList());
    }

    private static void minAndMaxTest() {
        Employee firstEmp = empList.stream()
                .min(Comparator.comparingInt(Employee::getId))
                .orElseThrow(NoSuchElementException::new);

        Employee maxSalEmp = empList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }

    private static void sortedTest() {
        List<Employee> employees = empList.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .toList();

        employees.forEach(System.out::println);
    }

    private static void lazyEvalTest() {
        Integer[] empIds = { 1, 2, 3, 4 };

        Employee employee = Stream.of(empIds)
                .map(EmployeeRepository::findById)
                .filter(Objects::nonNull)
                .filter(e -> e.getSalary() > 100000)
                .findFirst()
                .orElse(null);
    }

    private static void skipLimitTest() {
        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

    }

    private static void countTest() {
        Long empCount = empList.stream()
                .filter(e -> e.getSalary() > 200000)
                .count();
    }

    private static void peekTest() {
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(2, "Bill Gates", 200000.0),
                new Employee(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        List<Employee> collect = empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());


    }

    private static void flatMapTest() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        namesFlatStream.forEach(System.out::println);

        // Creating a List of Strings
        List<String> list = Arrays.asList("Geeks", "GFG",
                "GeeksforGeeks", "gfg");

        // Using Stream flatMap(Function mapper)
        Stream<Character> characterStream = list.stream().flatMap(str ->
                Stream.of(str.charAt(2)));
    }

    private static void toArrayTest() {
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        Employee[] employees = empList.stream().toArray(Employee[]::new);
        System.out.println();
    }

    private static void findFirstTest() {
        List<String> list = Arrays.asList("A", "B", "C", "D");

        Optional<String> result = list.stream().findFirst();
        result.ifPresent(System.out::println); ///!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    private static void findAnyTest() {
        List<String> list = Arrays.asList("A","B","C","D");

        Optional<String> result = list.stream().findAny();
        result.ifPresent(System.out::println); //!!!!!!!!!!!!!!!!!!!!!

        List<Integer> listParallel = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> resultParallel = listParallel
                .stream().parallel()
                .filter(num -> num < 4).findAny();
        resultParallel.ifPresent(System.out::println); //!!!!!!!!!!!!!!!!!!!!!
    }

    // Stream<T> filter(Predicate<? super T> predicate)


    private static void filterTest() {
        Customer john = new Customer("John P.", 15);
        Customer sarah = new Customer("Sarah M.", 200);
        Customer charles = new Customer("Charles B.", 150);
        Customer mary = new Customer("Mary T.", 1);

        List<Customer> customers = Arrays.asList(john, sarah, charles, mary);

        List<Customer> customersWithMoreThan100Points = customers
                .stream()
                .filter(c -> c.getPoints() > 100)
                .collect(Collectors.toList());

        List<Customer> customersWithMoreThan100Points1 = customers
                .stream()
                .filter(Customer::hasOverHundredPoints)
                .collect(Collectors.toList());

        List<Customer> charlesWithMoreThan100Points2 = customers
                .stream()
                .filter(c -> c.getPoints() > 100 && c.getName().startsWith("Charles"))
                .collect(Collectors.toList());

        List<Customer> customersWithValidProfilePhoto = customers
                .stream()
                .filter(c -> {
                    try {
                        return c.hasValidProfilePhoto();
                    } catch (IOException e) {
                        //handle exception
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    private static void colectTest() {
        User user = new User("john@gmail.com", "1234");
        List<String> emails = Optional.ofNullable(user)
                .stream()
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"))
                .map(User::getEmail)
                .collect(Collectors.toList());

        System.out.println();

    }

    private static void mapTest() {
        // Creating a list of Integers
        List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);

        // Using Stream map(Function mapper) and
        // displaying the corresponding new stream
        list.stream().map(number -> number * 3).forEach(System.out::println);
    }

    private static void createTest() {
        Stream<Employee> arrayOfEmps1 = Stream.of(arrayOfEmps);

        List<Employee> empList = Arrays.asList(arrayOfEmps);
        Stream<Employee> arrayOfEmps2 = empList.stream();

        Stream<Employee> arrayOfEmps3 = Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);


        Stream.Builder<Employee> empStreamBuilder = Stream.builder();
        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);
        Stream<Employee> empStream = empStreamBuilder.build();
    }

    private static void forEach() {
        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream().forEach(System.out::println);
        empList.stream().forEach(e -> e.salaryIncrement(10.0));
        empList.stream().forEach(System.out::println);
    }

    private static class EmployeeRepository {

        public static Employee findById(Integer id) {
          return   empList.stream().filter(e->e.id == id).findFirst().orElseGet(null);
        }
    }

    private static class Customer {
        private String name;
        private int points;

        public Customer(String name, int points) {

            this.name = name;
            this.points = points;
        }

        public int getPoints() {
            return points;
        }

        public boolean hasOverHundredPoints() {
            return this.points > 100;
        }

        public String getName() {
            return name;
        }

        public boolean hasValidProfilePhoto() throws IOException {
            throw new IOException("ddd");
        }
        //Constructor and standard getters
    }

    private static class Employee {
        private int id;
        private String name;
        private double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public void salaryIncrement(double v) {
            salary+=v;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + salary;
        }

        public double getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    private static class User {
        private final String mail;
        private final String number;

        public User(String mail, String number) {

            this.mail = mail;
            this.number = number;
        }

        public String getEmail() {
            return mail;
        }
    }
}
