package org.example;

import org.example.genericlist.OurGenericList;
import org.example.lists.ArrayListExamples;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");

        OurGenericList<Integer> list = new OurGenericList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> integerIterator = list.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }
        // OR (Both are same)
        for (int item : list) {
            System.out.println(item);
        }

        System.out.println("---------------------------------ArrayList -------------------------------------------");
        ArrayListExamples aList = new ArrayListExamples();

        System.out.println("Ending...");
    }
}