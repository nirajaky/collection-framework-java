package org.example.queues;

import java.util.Stack;

public class StackExample {

    // Stack class extends Vector
    public StackExample() {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack : " + stack);
        System.out.println("push() to Stack : " + stack.push(40));

        // peek() gives last element in case of Stack and gives First element in case of Queue
        System.out.println("Get peek() Last Element : " + stack.peek());
    }
}
