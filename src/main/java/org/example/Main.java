package org.example;

import org.example.genericlist.OurGenericList;
import org.example.lists.ArrayListExamples;
import org.example.lists.LinkedListExamples;
import org.example.queues.ArrayDequeExamples;
import org.example.queues.PriorityQueueExamples;
import org.example.queues.QueueExamples;
import org.example.queues.StackExample;
import org.example.sets.HashSetsExamples;
import org.example.sets.LinkedHashSetExamples;
import org.example.sets.TreeSetExamples;

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

        System.out.println("--------------------------------- ArrayList ---------------------------------------------");
        ArrayListExamples aList = new ArrayListExamples();

        System.out.println("--------------------------------- LinkedList --------------------------------------------");
        LinkedListExamples lList = new LinkedListExamples();

        System.out.println("---------------------------------- Queue FIFO -------------------------------------------");
        QueueExamples queueExamples = new QueueExamples();

        System.out.println("---------------------------------- Stack LIFO -------------------------------------------");
        StackExample stackExample = new StackExample();

        System.out.println("---------------------------------- ArrayDeque -------------------------------------------");
        ArrayDequeExamples arrayDequeExamples = new ArrayDequeExamples();

        System.out.println("---------------------------------- Priority Queue ---------------------------------------");
        PriorityQueueExamples priorityQueueExamples = new PriorityQueueExamples();

        System.out.println("---------------------------------- Hash Set ---------------------------------------------");
        HashSetsExamples setsExamples  = new HashSetsExamples();

        System.out.println("---------------------------------- Linked Hash Set --------------------------------------");
        LinkedHashSetExamples linkedHashSetExamples  = new LinkedHashSetExamples();

        System.out.println("---------------------------------- Tree Set ---------------------------------------------");
        TreeSetExamples treeSetExamples  = new TreeSetExamples();

        System.out.println("Ending...");
    }
}