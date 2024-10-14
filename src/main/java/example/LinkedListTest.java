package org.example;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> object = new LinkedList<String>();
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add(null);
        object.add(null);
        System.out.println("Linked list : " + object);
        System.out.println("Size of List:" + object.size());
    }
}
