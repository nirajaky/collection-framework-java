package org.example.lists;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExamples {

    // It only implements List

    // It is a dynamic array, which grows its size automatically
    // Internally ArrayList also uses normal array with some default size. 
    // Once that size is reached its content is copied and assigned to new Array. Now that new array reference is used.
    // Old array is garbage collected.

    public ArrayListExamples() {

        // ArrayList contains all the methods present in List
        List<Integer> aList = new ArrayList<>();

        aList.add(100);
        aList.add(101);
        aList.add(102);

        System.out.println("Print all list: " + aList);
        aList.set(1, 201);
        System.out.println("After Setting at index 1 : " + aList);

        // ArrayList takes a constructor , where we can pass any Collection
        List<Integer> aList2 = new ArrayList<>(aList);                      // a deep copy of aList
        aList2.add(103);
        aList2.add(104);

        System.out.println("aList2 : " + aList2);

        // OR
        // This automation conversion is done my compiler called unboxing, where Reference/Wrapper class is
        // Converted to primitive data type

        //        for (int e : aList2) {
        //            System.out.println(e);
        //        }

        // addAll utility method
        System.out.println("addAll method ------------------------------------");
        List<Integer> aList3 = new ArrayList<>();
        aList3.add(10);
        aList3.add(20);
        aList3.add(30);

        aList3.addAll(aList);
        System.out.println("aList3.addAll(aList) : " + aList3);

        aList3.addAll(1, aList);
        System.out.println("aList3.addAll(1, aList) : " + aList3);

        // subList - shallow copy means it's just a view, means any change in subList will make change in original List as well
        System.out.println("subList() a shallow copy ------------------------");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println("List1 : " + list1);

        List<Integer> list2 = list1.subList(1,3);
        System.out.println("list2 : " + list2);

        list2.set(0, 22);              // It will alter list1 as well, since list2 is shallow copy of list1
        System.out.println(list1);
        System.out.println(list2);


    }

}
