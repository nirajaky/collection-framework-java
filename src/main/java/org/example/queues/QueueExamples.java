package org.example.queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {
    // Queue = FIFO
    // Stack = LIFO


    // Since LinkedList implements Deque interface, So, it can act as FIFO and LIFO
    // So, for FIFO we can use LinkedList concrete classes as it has all the Queue interface methods
    public QueueExamples() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println("Queue : " + queue);

        System.out.println("peek() First Element : " + queue.peek());
        System.out.println("poll() removes first Element : " + queue.poll());
        System.out.println("offer() add the Element at last : " + queue.offer(50));

        System.out.println("Final Queue : " + queue);
    }
}
