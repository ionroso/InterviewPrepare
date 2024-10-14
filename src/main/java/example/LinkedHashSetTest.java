package org.example;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedset = new LinkedHashSet<String>();
        linkedset.add("A");
        linkedset.add("B");
        linkedset.add("C");
        linkedset.add("D");
        System.out.println("LinkedHashSet:" + linkedset);
        System.out.println("Size of LinkedHashSet = " + linkedset.size());
        linkedset.add("A");
        System.out.println("After adding duplicate element " + linkedset);
        System.out.println("Size of LinkedHashSet = " + linkedset.size());
        linkedset.add(null);
        linkedset.add(null);
        System.out.println("After adding null element " + linkedset);
        System.out.println("Size of LinkedHashSet = " + linkedset.size());

        System.out.println("Iterating over...");
        for (String item : linkedset) {
            System.out.print(item + " ");
        }
    }
}
