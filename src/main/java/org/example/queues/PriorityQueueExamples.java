package org.example.queues;

import org.example.queues.UserDefinedClass.MyCustomComparator;
import org.example.queues.UserDefinedClass.StudentMarks;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueExamples {

    // Priority Queue works on the priority
    // In case of several elements with same priority, one of them is chosen randomly

    // Even though we have iterator present for Priority Queue, as it is part of Collection
    // But it is not a good idea to iterate.

    // A PriorityQueue is used when the objects are supposed to be processed based on the priority.
    // It is known that a Queue follows the First-In-First-Out algorithm, but sometimes
    // the elements of the queue are needed to be processed according to the priority,
    // that’s when the PriorityQueue comes into play.

    // The elements of the priority queue are ordered according to the natural ordering,
    // or by a Comparator provided at queue construction time, depending on which constructor is used.

    public PriorityQueueExamples() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(999);
        arrayList.add(2);
        arrayList.add(77);
        arrayList.add(1);
        arrayList.add(26);

        // We can add the data by passing Collection to constructor or via offer() method
        // arrayList has Integer Wrapper Class, which is by default implementing Comparable( and compareTo() method
        // For this reason we were not getting any Exception by using PriorityQueue.
        // PriorityQueue internally processed the data by using compareTo() method present in Integer class
        PriorityQueue<Integer> pq = new PriorityQueue<>(arrayList);

        //  pq.offer(10);
        //  pq.offer(3);
        //  pq.offer(8);
        //  pq.offer(100);
        //  pq.offer(45);

        System.out.println("Priority Queue : " + pq);

        // poll() ~ pop(), In PriorityQueue, element will be poll in ascending order
        // Data gets processed in ascending order as the compareTo() method of Integer class is implemented in such a way
        // If we want data to be processed in descending order, we need to use Comparator
        System.out.println("Priority Queue : " + pq.poll());
        System.out.println("Priority Queue : " + pq.poll());
        System.out.println("Priority Queue : " + pq.poll());

        // ------- -------- -------- --------
        // By passing custom Comparator class, PriorityQueue will process the data via
        // compare() method implementation
        // Descending order sorting
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(new MyCustomComparator());

          pq2.offer(10);
          pq2.offer(100);
          pq2.offer(8);
          pq2.offer(4);
          pq2.offer(45);

          System.out.println("Priority Queue 2 : " + pq2);
          System.out.println(pq2.poll());
          System.out.println(pq2.poll());

          /*
                Alternative to :
                PriorityQueue<Integer> pq2 = new PriorityQueue<>(new MyCustomComparator());

                is passing anonymous class as parameter, it overrides compare() method of Comparator.
                PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);

                Actually, constructor of PriorityQueue accepts comparator as parameter. So, we can implement
                it directory. But with ArrayList, we can't use that as its constructor does not accept Comparator

                We can use this -
                pq2.sort();
           */

        // --------------------------------------------------------------------------------------

        /*
          Get me the top 2 Students with math marks

          We can sort it using two option
          1. Comparable - at class level
          2. Comparator
         */

        ArrayList<StudentMarks> stMarks = new ArrayList<>();
        stMarks.add(new StudentMarks(85, 65));
        stMarks.add(new StudentMarks(75, 77));
        stMarks.add(new StudentMarks(26, 55));
        stMarks.add(new StudentMarks(94, 88));
        stMarks.add(new StudentMarks(12, 99));

        // On adding data to it, It will throw exception if StudentMarks haven't implemented Comparable (and compareTo() method)
        PriorityQueue<StudentMarks> marks = new PriorityQueue<>(stMarks);

//        System.out.println(marks);
        System.out.println("Rank 1 for Maths" + marks.poll());
        System.out.println("Rank 2 for Maths" + marks.poll());
        System.out.println("Rank 3 for Maths" + marks.poll());


        /*
              Comparable                                             Comparator
              -----------------------------------------------------------------------------------------------------
              1. Comparable Interface has compareTo() method         1. Comparator Interface has compare() method
              2. compareTo() method has 1 parameter                  2. compare() method has 2 parameter
              3. By default, class is implementing Comparable        3. Ordering which we are passing to PriorityQueue
                 also called as Natural Ordering                        as a Comparator called as Total Ordering
              4. Less priority (compareTo() )                        4. More priority (compare() )

         */

    }
}
