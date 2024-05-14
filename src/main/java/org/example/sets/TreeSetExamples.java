package org.example.sets;

import org.example.queues.UserDefinedClass.StudentMarks;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExamples {

    // TreeSet implements SortedSet and NavigableSet interface
    // Since it is SortedSet - If we access the elements by for loop or iterator()
    // will get the element as per ordering

    // Sets are ordered either using Natural Ordering or Total Ordering

    /*
        Methods in SortedSet
        1. E first()
        2. E last()
     */

    // NavigableSet has method to get the closest match for specific search targets
    // NavigableSet has the following methods -
        /*
            First Last Element
            - E pollFirst()
            - E pollLast()

            Closest match
            - E ceiling(E e)    // returns the greater or equal to element than e
            - E floor(E e)      // returns the less than or equal to element than e

            - E higher(E e)     // returns the strictly greater to element than e
            - E lower(E e)      // returns the strictly less to element than e
         */

    public TreeSetExamples() {

        // In set also we need to pass the Custom class with either Comparable or Comparator methods implemented
        // Like for PriorityQueue, else we will get Exception
        Set<StudentMarks> treeSets = new TreeSet<>((a, b) -> b.getPhysics() - a.getPhysics());
        treeSets.add(new StudentMarks(85, 65));
        treeSets.add(new StudentMarks(75, 77));
        treeSets.add(new StudentMarks(26, 55));
        treeSets.add(new StudentMarks(94, 88));
        treeSets.add(new StudentMarks(12, 99));

        System.out.println("Tree Set 1 : " + treeSets);

        // If we do not pass any Comparator, the default natural ordering happens
        NavigableSet<Integer> set2 = new TreeSet<>();

        set2.add(5);
        set2.add(9);
        set2.add(3);
        set2.add(1);
        set2.add(13);

        System.out.println("Set 2 : " + set2);
        set2.add(5);

        System.out.println("Ceiling - 4 > " + set2.ceiling(4));
        System.out.println("Ceiling - 5 > " + set2.ceiling(5));
        System.out.println("Floor - 4 > " + set2.floor(4));
        System.out.println("Floor - 3 > " + set2.floor(3));

        System.out.println("Higher - 5 > " + set2.higher(5));
        System.out.println("Lower - 5 > " + set2.lower(5));

    }
}
