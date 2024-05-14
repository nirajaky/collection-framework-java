package org.example.sets;

import org.example.queues.UserDefinedClass.StudentMarks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetsExamples {

    // Set is used to store unique elements
    // HashSet implements Set
    // LinkedHashSet extends HashSet

    // HashSet uses Hashing Technique
    // Insertion and Deletion takes constant time
    // Elements are placed randomly ( no order of insertion also)

    public HashSetsExamples() {

        Set<Integer> set1 = new HashSet<>();

        set1.add(2);
        set1.add(4);
        set1.add(1);
        set1.add(9);
        set1.add(3);

        // Set does not keep the order of insertion or deletion
        // It randomly stores the value
        System.out.println("Set 1 : " + set1);

        Set<Integer> set2 = new HashSet<>();

        set2.add(3);
        set2.add(11);
        set2.add(22);
        set2.add(33);
        set2.add(9);

        set2.remove(33);             // Removes the passed element

        System.out.println("Set 2 : " + set2);

        set1.retainAll(set2);
        System.out.println("Intersection or common element (Set 1): " + set1);

        // set1 = [3, 9]
        set2.removeAll(set1);  // difference set1 - set2
        System.out.println("Set2 : " + set2);

        // set1 = [3, 9] set2 = [22,11]
        set1.addAll(set2);     // Union set1 + set2
        System.out.println(set1);

        /*
            contains() method
         */
        System.out.println("Contains method ******************");

        Set<Integer> cSet1 = new HashSet<>();

        cSet1.add(2);
        cSet1.add(4);
        cSet1.add(1);
        cSet1.add(9);

        System.out.println("Check 1 " + cSet1.contains(1));
        System.out.println("Check 2 " + cSet1.contains(55));

        Set<String> cSet2 = new HashSet<>();

        cSet2.add("Apple");
        cSet2.add("Banana");
        cSet2.add("PineApple");
        cSet2.add("Beet");

        System.out.println("Check 3 " + cSet2.contains("Apple"));
        System.out.println("Check 4 " + cSet2.contains("Graphs"));


        // ---------------------------------
        ArrayList<StudentMarks> stMarks = new ArrayList<>();
        stMarks.add(new StudentMarks(85, 65));
        stMarks.add(new StudentMarks(75, 77));
        stMarks.add(new StudentMarks(26, 55));
        stMarks.add(new StudentMarks(94, 88));
        stMarks.add(new StudentMarks(12, 99));

        Set<StudentMarks> cSet3 = new HashSet<>(stMarks);

        // Even though it is present, we are getting false
        // Because, HashSet inserts the data by hashing in different bucket
        // And it compares the memory address(returned from hashCode() method of Object class)


        System.out.println("Check 5 " + cSet3.contains(new StudentMarks(85, 65)));

        // To get the correct expected result, we need to implement the hashCode() and equals() method
        // for StudentMarks class. It is using default method present in the Object class


    }
}
