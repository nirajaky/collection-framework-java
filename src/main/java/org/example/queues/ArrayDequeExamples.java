package org.example.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExamples {

    // ArrayDeque implements Deque
    // Insertion and Deletion happens at both the end

    public ArrayDequeExamples() {
        Deque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.offerFirst(1);
        arrayDeque.offerFirst(2);
        arrayDeque.offerFirst(3);
        arrayDeque.offerFirst(4);

        System.out.println("arrayDeque : " + arrayDeque);
        System.out.println("arrayDeque.pollLast() " + arrayDeque.pollLast());
        System.out.println("arrayDeque.offerFirst() " + arrayDeque.offerFirst(5));
        System.out.println("arrayDeque : " + arrayDeque);

        System.out.println("arrayDeque.peekLast() : " + arrayDeque.peekLast());
    }
}
