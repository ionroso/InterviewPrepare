package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> lhmp=new LinkedHashMap<Integer,String>();
        lhmp.put(1,"Solve");
        lhmp.put(2,"Question Series");
        lhmp.put(3,"On Coding Ninjas Studio.");
        for(Map.Entry mp:lhmp.entrySet()){
            System.out.println(mp.getKey()+" "+mp.getValue());
        }
    }
}
