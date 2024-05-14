package org.example.sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExamples {

    // It is also a HashSet, but maintains the order of insertion and deletion

    // It has slight performance issue compared top HashSet
    // Each CustomObject has hashCode(), which is just the memory address

    public LinkedHashSetExamples() {
        Set<Integer> set1 = new LinkedHashSet<>();

        set1.add(2);
        set1.add(4);
        set1.add(1);
        set1.add(9);
        set1.add(3);

        // Maintains the order of Insertion
        System.out.println("Set 1 : " + set1);

        set1.remove(9);
        System.out.println("Set 1 : " + set1);

    }
}
