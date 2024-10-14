package org.example;

import java.util.*;

public class TreeMapTest {

    public static void main(String[] args) {
      // new MyCalendar().test();

//      iterateTest();
//      tailMapTest();
//      headMapTest();
//      firstKeyTest();
      lastKeyTest();

    }

    private static void lastKeyTest() {
        // Creating an object of TreeMap of type Character
        // and Integer
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        // Adding elements to the object created above
        // Custom entries
        treeMap.put('A', 1);
        treeMap.put('F', 5);
        treeMap.put('M', 2);
        treeMap.put('K', 9);
        treeMap.put('G', 4);
        treeMap.put('J', 7);

        // Print and display all the elements in the TreeMap
        System.out.println("Tree Map : " + treeMap);

        // Print the highest key in the TreeMap
        // using lastKey() method
        System.out.println("Highest Key is : " + treeMap.lastKey());
    }

    private static void firstKeyTest() {
        // Creating an object of TreeMap of type Character
        // and String
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        // Inserting elements to the object created above

        // Custom entries
        treeMap.put('A', 1);
        treeMap.put('F', 5);
        treeMap.put('M', 2);
        treeMap.put('K', 9);
        treeMap.put('G', 4);
        treeMap.put('J', 7);

        // Display all the elements in the object of TreeMap
        System.out.println("Tree Map : " + treeMap);

        // Print and display the lowest key
        // using firstkey() method
        System.out.println("Lowest Key is : " + treeMap.firstKey());
    }

    private static void headMapTest() {
        // Creating an empty TreeMap
        TreeMap<Integer, String> tree_map = new
                TreeMap<Integer, String>();

        // Mapping string values to int keys
        tree_map.put(10, "Geeks");
        tree_map.put(15, "4");
        tree_map.put(20, "Geeks");
        tree_map.put(25, "Welcomes");
        tree_map.put(30, "You");

        // Displaying the TreeMap
        System.out.println("Initial Tree is: " + tree_map);

        // Creating the sorted map for map head
        SortedMap<Integer, String> map_head = new TreeMap<Integer, String>();
        map_head = tree_map.headMap(20);

        // Getting the map head
        System.out.println("The headmap is: " + map_head);
    }

    private static void tailMapTest() {
        // Creating an empty TreeMap
        TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();

        // Mapping string values to int keys
        tree_map.put(10, "Geeks");
        tree_map.put(15, "4");
        tree_map.put(20, "Geeks");
        tree_map.put(25, "Welcomes");
        tree_map.put(30, "You");

        // Displaying the TreeMap
        System.out.println("The original map is: " + tree_map);

        // Displaying the submap
        System.out.println("The tailMap is " + tree_map.tailMap(15));
    }

    private static void iterateTest() {
        // Creating a TreeMap class object
        // Objects are of key-value pairs (integer and
        // string type)
        TreeMap<Integer, String> tm
                = new TreeMap<Integer, String>();

        // Customly adding elements
        tm.put(2, "For");
        tm.put(1, "Geeks");
        tm.put(3, "Geeks");

        //  Get all entries using the entrySet() method
        Set<Map.Entry<Integer, String>> entries = tm.entrySet();

        // Way 1
        // Using for loops
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        // New line to differentiate differences in output
        // between for loop and for each loop
        System.out.println();

        // Way 2 - getting code shorter and simpler
        // For each loops

        entries.forEach(entry -> { System.out.println(entry.getKey() + "->" + entry.getValue()); });

        // New line to differentiate differences in output
        // between for each loop and iterator traversal
        System.out.println();

        // Way 3 - New way to
        // Getting an iterator
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();

        // Additional step here
        // To Initialize object holding for
        // key-value pairs to null
        Map.Entry<Integer, String> entry = null;

        // Holds true till there is no element remaining in
        // the object using hasNExt() method
        while (iterator.hasNext()) {
            // Moving onto next pairs using next() method
            entry = iterator.next();

            // Printing the key-value pairs
            // using getKey() and getValue() methods
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    private static class MyCalendar {
        TreeMap<Integer, Integer> calendar;

        MyCalendar() {
            calendar = new TreeMap();
        }

        public void test() {
            MyCalendar myCalendar = new MyCalendar();
            myCalendar.book(10, 20); // return True
            myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
            myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
        }

        public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start),
                    next = calendar.ceilingKey(start);
            if ((prev == null || calendar.get(prev) <= start) &&
                    (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }
}
