package org.example;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        reverseOrderTreeMap();
        reverseOrderPriorityQueue();

        synchronizedTreeMapTest();
        synchronizedHashMapTest();

    }

    private static void synchronizedHashMapTest() {
        // New HashMap
        HashMap<Integer, String> hmap = new HashMap<>();

        // Add element to map
        hmap.put(1, "Akshay");
        hmap.put(2, "Bina");
        hmap.put(3, "Chintu");

        // Get synchronized map using
        // Collections.synchronizedMap()
        Map<Integer, String> synchrMap = Collections.synchronizedMap(hmap);

        System.out.println("Synchronized Map : ");

        // Synchronized block
        synchronized (synchrMap)
        {
            // Iterate synchronized map
            for (Map.Entry<Integer, String> entry : synchrMap.entrySet()) {
                // Print key : value
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    private static void synchronizedTreeMapTest() {
        // Try block to check if any exception occurs
            // Step1: Creating a TreeMap object
            // Declaring object of string type
            TreeMap<String, String> treeMap
                    = new TreeMap<String, String>();

            // Step2: Adding elements into the above Map
            // Custom inputs
            treeMap.put("1", "Welcome");
            treeMap.put("2", "To");
            treeMap.put("3", "Geeks");
            treeMap.put("4", "For");
            treeMap.put("5", "Geeks");

            // Printing all elements of the above Map object
            System.out.println("Map : " + treeMap);

            // Synchronizing the map using
            // synchronizedMap() method of Collection class
            Map<String, String> synchrMap = Collections.synchronizedMap(treeMap);

            // Printing the Collection
            System.out.println("Synchronized map is : " + synchrMap);


        // Synchronized block
        synchronized (synchrMap) {

            // Iterate synchronized map
            for (Map.Entry<String, String> entry : synchrMap.entrySet()) {

                // Print key : value
                System.out.println(entry.getKey() + " : " + entry.getValue());

            }
        }
    }

    private static void reverseOrderPriorityQueue() {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
    }

    private static void reverseOrderTreeMap() {
        // Map to store the elements
        Map<String, String> treemap = new TreeMap<String, String>(Collections.reverseOrder());

        // Put elements to the map
        treemap.put("1", "Welcome");
        treemap.put("2", "to");
        treemap.put("3", "the");
        treemap.put("4", "Geeks");
        treemap.put("5", "Community");

        Set set = treemap.entrySet();
        Iterator i = set.iterator();

        // Traverse map and print elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}
