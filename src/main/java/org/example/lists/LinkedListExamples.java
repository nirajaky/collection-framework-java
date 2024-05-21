package org.example.lists;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExamples {

    // LinedList implements List and Deque

    // Linked List implementation uses double LinkedList
    // Insertion and deletion is very much efficient in LinkedList

    //                   ArrayList                                           LinkedList
    //           --------------------                                    -----------------------
    //     Position based access has constant time performance.         It has liner time performance.
    //     Traversing is easy to do.                                    Traversing is expensive
    //     Insertion and deletion is costly.                            Insertion and deletion is worth considering
    //     Implements List only                                         Implements List and Deque, allows it to be as Stack and Deque

    public LinkedListExamples() {

        List<Integer> lk = new LinkedList<>();

        lk.add(10);
        lk.add(20);
        lk.add(30);

        System.out.println("Get Element by index : " + lk.get(1));

        // [1, 2, 3]
        ListIterator<Integer> iterator = lk.listIterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.previous());

        // toArray() converts List to array
        // in parameter, we can pass any size less than List size. Compiler will automatically recognise the size for array

        // Array --> List  =>  List<> al = Arrays.asList(arr)

        // List to Array
        Integer[] arr = lk.toArray(new Integer[0]);
        System.out.println("Convert list to normal java array : " );
        for (int x : arr) {
            System.out.println(x);
        }
        System.out.println(arr.length);
        System.out.println(lk.getClass());
    }
}
